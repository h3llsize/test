package org.bst.avito.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AvitoChatDTO implements ExportUserDetails{
    private AvitoContextDTO context;

    private Long created;

    private String id;

    private Long updated;

    private List<AvitoUserDTO> users;

    @JsonProperty("last_message")
    private AvitoMessageDTO lastMessage;

    @Override
    public UserDetails toUserDetails() {
        return null;
    }
}
