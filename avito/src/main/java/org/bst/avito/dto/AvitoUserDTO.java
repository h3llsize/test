package org.bst.avito.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AvitoUserDTO {
    private Long id;

    private String name;

    @JsonProperty("public_user_profile")
    private AvitoPublicUserProfileDTO publicUserProfile;
}
