package org.bst.avito.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AvitoContextValueDTO {
    private Long id;

    @JsonProperty("price_string")
    private String price;

    @JsonProperty("status_id")
    private Long statusId;

    private String title;

    private String url;

    private Long userId;
}
