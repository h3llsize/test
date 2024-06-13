package org.bst.avito.service.handler;

import org.bst.avito.client.AvitoMessengerService;
import org.bst.avito.dto.AvitoChatDTO;
import org.bst.avito.dto.ClientClaimAvitoRequest;
import org.bst.avito.entity.EmployeeEntity;
import org.bst.avito.entity.UserEntity;
import org.bst.avito.service.CrmRequestService;
import org.bst.avito.service.EmployeeQueue;
import org.bst.avito.service.UserService;
import org.bst.avito.service.utils.MessageBuilderService;
import org.springframework.stereotype.Component;

@Component
public class AvitoChatWorker {
    private final UserService userService;

    private final AvitoMessengerService avitoMessengerService;

    private final EmployeeQueue employeeQueue;

    private final MessageBuilderService messageBuilderService;

    private final CrmRequestService crmRequestService;


    public AvitoChatWorker(UserService userService, AvitoMessengerService avitoMessengerService, EmployeeQueue employeeQueue, MessageBuilderService messageBuilderService, CrmRequestService crmRequestService) {
        this.userService = userService;
        this.avitoMessengerService = avitoMessengerService;
        this.employeeQueue = employeeQueue;
        this.messageBuilderService = messageBuilderService;
        this.crmRequestService = crmRequestService;
    }

    //TODO refactor
    public void handle(AvitoChatDTO avitoChatDTO) {
        if(!userService.exists(avitoChatDTO.getUsers().get(0).getId())) {

            EmployeeEntity entity = employeeQueue.get();
            UserEntity user = userService.saveUser(avitoChatDTO.getUsers().get(0), entity);
            userService.saveChat(avitoChatDTO, user);
            avitoMessengerService.sendMessage(avitoChatDTO.getId(), messageBuilderService.getFirstMessage(entity));

            ClientClaimAvitoRequest clientClaimAvitoRequest = new ClientClaimAvitoRequest();
            clientClaimAvitoRequest.setName(avitoChatDTO.getUsers().get(0).getName());
            clientClaimAvitoRequest.setContact(avitoChatDTO.getUsers().get(0).getPublicUserProfile().getUrl());
            clientClaimAvitoRequest.setAdvertName(avitoChatDTO.getContext().getValue().getTitle());
            clientClaimAvitoRequest.setEmployeeId(entity.getCrmId());

            crmRequestService.sendRequest(clientClaimAvitoRequest, String.class);

        } else if (!userService.existsChat(avitoChatDTO.getId())) {
            UserEntity userEntity = userService.getUser(avitoChatDTO.getUsers().get(0).getId());

            userService.saveChat(avitoChatDTO, userEntity);

            avitoMessengerService.sendMessage(avitoChatDTO.getId(), messageBuilderService.getNewMessage(userEntity.getEmployee()));

            ClientClaimAvitoRequest clientClaimAvitoRequest = new ClientClaimAvitoRequest();
            clientClaimAvitoRequest.setName(avitoChatDTO.getUsers().get(0).getName());
            clientClaimAvitoRequest.setContact(avitoChatDTO.getUsers().get(0).getPublicUserProfile().getUrl());
            clientClaimAvitoRequest.setAdvertName(avitoChatDTO.getContext().getValue().getTitle());
            clientClaimAvitoRequest.setEmployeeId(userEntity.getEmployee().getCrmId());

            crmRequestService.sendRequest(clientClaimAvitoRequest, String.class);
        }

    }
}
