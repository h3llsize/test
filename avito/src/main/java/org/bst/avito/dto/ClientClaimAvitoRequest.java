package org.bst.avito.dto;


import lombok.Data;

import java.util.UUID;

@Data
public class ClientClaimAvitoRequest implements CrmRequest{
    private String name;

    private String contact;

    private String advertName;

    private UUID employeeId;

    @Override
    public String getMethodPath() {
        return "/avito/create-claim";
    }
}
