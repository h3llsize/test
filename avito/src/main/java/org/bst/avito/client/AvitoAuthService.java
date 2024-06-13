package org.bst.avito.client;


import org.bst.avito.increptors.HeaderRequestInterceptor;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class AvitoAuthService {

    private final AvitoTokenService avitoTokenService;

    private final CrmTokenService crmTokenService;

    public AvitoAuthService(AvitoTokenService avitoTokenService, CrmTokenService crmTokenService) {
        this.avitoTokenService = avitoTokenService;
        this.crmTokenService = crmTokenService;
    }

    public RestTemplate addAuth(RestTemplate restTemplate) {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Authorization", "Bearer " + avitoTokenService.getToken()));

        restTemplate.setInterceptors(interceptors);

        return restTemplate;
    }

    public RestTemplate addAuthCrm(RestTemplate restTemplate) {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Authorization", "Bearer " + crmTokenService.getToken()));

        restTemplate.setInterceptors(interceptors);

        return restTemplate;
    }
}
