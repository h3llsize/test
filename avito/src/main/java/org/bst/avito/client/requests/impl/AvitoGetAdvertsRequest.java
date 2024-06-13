package org.bst.avito.client.requests.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bst.avito.client.requests.AvitoGetRequest;

@Data
public class AvitoGetAdvertsRequest implements AvitoGetRequest {
    @JsonProperty("per_page")
    private Long perPage;

    @JsonProperty("page")
    private Long page;

    @JsonProperty("status")
    private String status;

    private String updatedAtFrom;

    private String category;

    @Override
    public String getMethodPath() {
        return "/core/v1/items";
    }
}
