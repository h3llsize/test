package org.bst.avito.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AvitoPublicUserProfileDTO {

    @JsonProperty("item_id")
    private Long itemId;

    private String url;

    @JsonProperty("user_id")
    private String userId;
}
