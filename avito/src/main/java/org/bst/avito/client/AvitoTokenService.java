package org.bst.avito.client;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class AvitoTokenService {

    private final AvitoTokenUpdateService avitoTokenUpdateService;

    private String currentToken;

    private LocalDateTime lastUpdate;

    public AvitoTokenService(AvitoTokenUpdateService avitoTokenUpdateService) {
        this.avitoTokenUpdateService = avitoTokenUpdateService;
    }

    private boolean isExpired() {
        if(lastUpdate == null)
            return true;

        return lastUpdate.plus(23, TimeUnit.HOURS.toChronoUnit()).isAfter(LocalDateTime.now());
    }

    public String getToken() {
        if(isExpired()) {
            currentToken = avitoTokenUpdateService.updateToken();
            lastUpdate = LocalDateTime.now();
        }

        return currentToken;
    }
}
