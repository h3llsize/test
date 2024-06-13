package org.bst.avito.beans;

import org.bst.avito.client.AvitoAuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateBean {

    private final AvitoAuthService avitoAuthService;

    public RestTemplateBean(AvitoAuthService avitoAuthService) {
        this.avitoAuthService = avitoAuthService;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        avitoAuthService.addAuth(restTemplate);

        return restTemplate;
    }

}
