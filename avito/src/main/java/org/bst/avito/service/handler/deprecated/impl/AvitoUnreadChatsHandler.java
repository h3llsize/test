package org.bst.avito.service.handler.deprecated.impl;

import org.bst.avito.client.AvitoMessengerService;
import org.bst.avito.dto.AvitoChatDTO;
import org.bst.avito.dto.AvitoUserDTO;
import org.bst.avito.service.UserService;
import org.bst.avito.service.utils.MessageBuilderService;
import org.springframework.stereotype.Service;

@Service
@Deprecated
public class AvitoUnreadChatsHandler {

    private final UserService userService;

    private final MessageBuilderService messageBuilderService;

    private final AvitoMessengerService avitoMessengerService;

    public AvitoUnreadChatsHandler(UserService userService, MessageBuilderService messageBuilderService, AvitoMessengerService avitoMessengerService) {
        this.userService = userService;
        this.messageBuilderService = messageBuilderService;
        this.avitoMessengerService = avitoMessengerService;
    }

    public void handleChat(AvitoChatDTO avitoChatDTO) {
        AvitoUserDTO avitoUserDTO = avitoChatDTO.getUsers().get(0);

        if(isUserExists(avitoUserDTO)) {
            return;
        }

//        userService.saveUser(avitoUserDTO);
//        avitoMessengerService.sendMessage(avitoChatDTO.getId(), messageBuilderService.getFirstMessage());
    }


    private boolean isUserExists(AvitoUserDTO avitoUserDTO) {
        return userService.exists(avitoUserDTO.getId());
    }
}
