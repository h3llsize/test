package org.bst.avito.client;

import org.bst.avito.client.requests.impl.AvitoGetCallsFromTimeRequest;
import org.bst.avito.client.requests.impl.AvitoGetCallsFromTimeResponse;
import org.bst.avito.dto.AvitoCallDTO;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AvitoCallTrackerService {

    private final AvitoRequestService avitoRequestService;

    public AvitoCallTrackerService(AvitoRequestService avitoRequestService) {
        this.avitoRequestService = avitoRequestService;
    }

    public List<AvitoCallDTO> getCalls(LocalDateTime dateTimeFrom) {
        return getCalls(dateTimeFrom, LocalDateTime.now());
    }

    public List<AvitoCallDTO> getCalls(LocalDateTime dateTimeFrom, LocalDateTime dateTimeTo) {
        AvitoGetCallsFromTimeRequest avitoGetCallsFromTimeRequest = new AvitoGetCallsFromTimeRequest();
        avitoGetCallsFromTimeRequest.setDateTimeFrom(dateTimeFrom);
        avitoGetCallsFromTimeRequest.setDateTimeTo(dateTimeTo);
        avitoGetCallsFromTimeRequest.setOffset(0L);
        avitoGetCallsFromTimeRequest.setLimit(100L);

        return avitoRequestService.sendRequest(avitoGetCallsFromTimeRequest, AvitoGetCallsFromTimeResponse.class).getCalls();
    }
}
