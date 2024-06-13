package org.bst.avito.client;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
public class CrmTokenService {

    private final CrmTokenUpdateService crmTokenUpdateService;

    private String currentToken;

    private LocalDateTime lastUpdate;

    public CrmTokenService(CrmTokenUpdateService crmTokenUpdateService) {
        this.crmTokenUpdateService = crmTokenUpdateService;
    }

    private boolean isExpired() {
        if(lastUpdate == null)
            return true;

        return lastUpdate.plus(23, TimeUnit.HOURS.toChronoUnit()).isAfter(LocalDateTime.now());
    }

    public String getToken() {
        if(isExpired()) {
            currentToken = crmTokenUpdateService.updateToken();
            lastUpdate = LocalDateTime.now();
        }

        return currentToken;
    }
}
