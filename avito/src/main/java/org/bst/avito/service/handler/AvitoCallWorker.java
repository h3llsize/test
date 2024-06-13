package org.bst.avito.service.handler;

import org.bst.avito.client.AvitoMessengerService;
import org.bst.avito.client.requests.AvitoAdvertsService;
import org.bst.avito.dto.AvitoAdvertDTO;
import org.bst.avito.dto.AvitoCallDTO;
import org.bst.avito.dto.ClientClaimAvitoRequest;
import org.bst.avito.entity.EmployeeEntity;
import org.bst.avito.service.CrmRequestService;
import org.bst.avito.service.EmployeeQueue;
import org.bst.avito.service.UserService;
import org.bst.avito.service.utils.MessageBuilderService;
import org.springframework.stereotype.Component;

@Component
public class AvitoCallWorker {
    private final UserService userService;

    private final AvitoAdvertsService avitoAdvertsService;

    private final CrmRequestService crmRequestService;

    private final EmployeeQueue employeeQueue;

    public AvitoCallWorker(UserService userService, AvitoAdvertsService avitoAdvertsService, AvitoMessengerService avitoMessengerService, EmployeeQueue employeeQueue, MessageBuilderService messageBuilderService, CrmRequestService crmRequestService) {
        this.userService = userService;
        this.avitoAdvertsService = avitoAdvertsService;
        this.employeeQueue = employeeQueue;
        this.crmRequestService = crmRequestService;
    }

    public void handle(AvitoCallDTO avitoCallDTO) {
        if(!userService.existsCall(avitoCallDTO.getBuyerPhone())) {
            EmployeeEntity entity = employeeQueue.get();

            AvitoAdvertDTO avitoAdvertDTO = avitoAdvertsService.findById(avitoCallDTO.getItemId());
            userService.saveCall(avitoCallDTO, entity, avitoAdvertDTO.getTitle());

            ClientClaimAvitoRequest clientClaimAvitoRequest = new ClientClaimAvitoRequest();
            clientClaimAvitoRequest.setName("По номеру");
            clientClaimAvitoRequest.setContact(avitoCallDTO.getBuyerPhone());
            clientClaimAvitoRequest.setAdvertName(avitoAdvertDTO.getTitle());
            clientClaimAvitoRequest.setEmployeeId(employeeQueue.get().getCrmId());

            crmRequestService.sendRequest(clientClaimAvitoRequest, String.class);
        }
    }
}
