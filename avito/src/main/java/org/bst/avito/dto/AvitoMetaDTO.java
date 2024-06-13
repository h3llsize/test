package org.bst.avito.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AvitoMetaDTO {
    private Long page;

    @JsonProperty("per_page")
    private Long perPage;
}
