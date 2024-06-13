package org.bst.avito.service;

import org.bst.avito.entity.UserEntity;

public interface AvitoBot {
    void onMessageReceived(UserEntity userEntity, String message, boolean isNew);
}
