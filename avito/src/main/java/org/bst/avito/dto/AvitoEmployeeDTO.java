package org.bst.avito.dto;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

public class AvitoEmployeeDTO {
    @Getter
    private UUID id;

    @Getter
    private String name;

    @Getter
    private String phoneNumber;

    private Boolean isActive;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
