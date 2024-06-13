package org.bst.avito.client;

import org.bst.avito.dto.CrmTokenResponseDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class CrmTokenUpdateService {

    private final AvitoConfigParamsService avitoConfigParamsService;

    public CrmTokenUpdateService(AvitoConfigParamsService avitoConfigParamsService) {
        this.avitoConfigParamsService = avitoConfigParamsService;
    }

    public String updateToken() {
        String clientId = avitoConfigParamsService.getCrmClient();
        String clientSecret = avitoConfigParamsService.getCrmSecret();

        String auth = clientId + ":" + clientSecret;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic " + encodedAuth;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", authHeader);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);


        ResponseEntity<CrmTokenResponseDTO> response =
                restTemplate.exchange(AvitoApiConst.CRM_AUTH_TOKEN, HttpMethod.POST, requestEntity, CrmTokenResponseDTO.class);

        return response.getBody().getAccessToken();
    }
}
