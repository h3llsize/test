package org.bst.avito.client.requests.impl;

import lombok.Data;
import org.bst.avito.dto.AvitoAdvertDTO;
import org.bst.avito.dto.AvitoMetaDTO;

import java.util.List;

@Data
public class AvitoGetAdvertsResponse {
    private AvitoMetaDTO meta;

    private List<AvitoAdvertDTO> resources;
}
