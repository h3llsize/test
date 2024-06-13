package org.bst.avito.service;

import org.bst.avito.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class AvitoChatService implements AvitoBot {
    @Override
    public void onMessageReceived(UserEntity userEntity, String message, boolean isNew) {

    }
}
