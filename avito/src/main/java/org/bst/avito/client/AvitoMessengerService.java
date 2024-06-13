package org.bst.avito.client;

import org.bst.avito.client.requests.impl.AvitoGetChatsRequest;
import org.bst.avito.client.requests.impl.AvitoGetChatsResponse;
import org.bst.avito.client.requests.impl.AvitoSendMessageRequest;
import org.bst.avito.dto.AvitoMessageDTO;
import org.springframework.stereotype.Component;

@Component
public class AvitoMessengerService {
    private final AvitoRequestService avitoRequestService;

    public AvitoMessengerService(AvitoRequestService avitoRequestService) {
        this.avitoRequestService = avitoRequestService;
    }

    public AvitoGetChatsResponse getChats(boolean isUnread) {;
        return avitoRequestService.sendRequest(AvitoGetChatsRequest.builder().unreadOnly(isUnread).build(), AvitoGetChatsResponse.class);
    }

    public AvitoMessageDTO sendMessage(String chatId, String text) {
        AvitoSendMessageRequest avitoSendMessageRequest = new AvitoSendMessageRequest();
        avitoSendMessageRequest.setMessageText(text);

        return avitoRequestService.sendRequestWithChatId(avitoSendMessageRequest, AvitoMessageDTO.class, chatId);
    }
}
