package org.bst.avito.client.requests.impl;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.bst.avito.client.requests.AvitoPostRequest;
import org.bst.avito.dto.AvitoMessageContentDTO;

@Data
public class AvitoSendMessageRequest implements AvitoPostRequest {
    private AvitoMessageContentDTO message = new AvitoMessageContentDTO();

    @Setter(AccessLevel.PRIVATE)
    private String type = "text";

    public void setMessageText(String text) {
        this.message.setText(text);
    }

    @Override
    public String getMethodPath() {
        return "/messenger/v1/accounts/USER_ID/chats/CHAT_ID/messages";
    }
}
