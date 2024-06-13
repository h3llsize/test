package org.bst.avito.client.requests;

import org.bst.avito.client.AvitoRequestService;
import org.bst.avito.client.requests.impl.AvitoGetAdvertsRequest;
import org.bst.avito.client.requests.impl.AvitoGetAdvertsResponse;
import org.bst.avito.dto.AvitoAdvertDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvitoAdvertsService {
    private final AvitoRequestService avitoRequestService;

    public AvitoAdvertsService(AvitoRequestService avitoRequestService) {
        this.avitoRequestService = avitoRequestService;
    }

    public List<AvitoAdvertDTO> getAdverts(Long perPage, Long page) {
        AvitoGetAdvertsRequest avitoGetAdvertsRequest = new AvitoGetAdvertsRequest();
        avitoGetAdvertsRequest.setPage(page);
        avitoGetAdvertsRequest.setPerPage(perPage);

        return avitoRequestService.sendRequest(avitoGetAdvertsRequest, AvitoGetAdvertsResponse.class).getResources();
    }

    public AvitoAdvertDTO findById(Long id) {
        for (AvitoAdvertDTO advert : getAdverts(100L, 0L)) {
            if(advert.getId().equals(id))
                return advert;
        }

        return null;
    }
}
