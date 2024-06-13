package org.bst.avito.client.requests.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bst.avito.dto.AvitoChatDTO;

import java.util.List;

@Data
public class AvitoGetChatsResponse {
    @JsonProperty("chats")
    private List<AvitoChatDTO> chats;
}
