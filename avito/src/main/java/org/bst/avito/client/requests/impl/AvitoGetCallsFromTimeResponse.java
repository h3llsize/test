package org.bst.avito.client.requests.impl;

import lombok.Data;
import org.bst.avito.dto.AvitoCallDTO;

import java.util.List;

@Data
public class AvitoGetCallsFromTimeResponse {
    private List<AvitoCallDTO> calls;
}
