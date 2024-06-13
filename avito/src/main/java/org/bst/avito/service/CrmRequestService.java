package org.bst.avito.service;

import org.bst.avito.client.AvitoApiConst;
import org.bst.avito.client.AvitoAuthService;
import org.bst.avito.dto.CrmRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CrmRequestService {
    private final AvitoAuthService avitoAuthService;

    public CrmRequestService(AvitoAuthService avitoAuthService) {
        this.avitoAuthService = avitoAuthService;
    }

    public <T> T sendRequest(CrmRequest crmRequest, Class<T> response) {
        String url = AvitoApiConst.CRM_API_URL + crmRequest.getMethodPath();

        RestTemplate restTemplate = new RestTemplate();

        avitoAuthService.addAuthCrm(restTemplate);

        return restTemplate.postForObject(url, crmRequest, response);
    }
}
