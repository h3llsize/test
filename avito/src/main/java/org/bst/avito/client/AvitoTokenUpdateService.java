package org.bst.avito.client;

import org.bst.avito.dto.AvitoTokenRequestDTO;
import org.bst.avito.dto.AvitoTokenResponseDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class AvitoTokenUpdateService {

    private final AvitoConfigParamsService avitoConfigParamsService;

    public AvitoTokenUpdateService(AvitoConfigParamsService avitoConfigParamsService) {
        this.avitoConfigParamsService = avitoConfigParamsService;
    }

    public String updateToken() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        AvitoTokenRequestDTO tokenRequest = new AvitoTokenRequestDTO(
                AvitoApiConst.GRANT_TYPE,
                avitoConfigParamsService.getClientId(),
                avitoConfigParamsService.getSecretKey()
        );

        MultiValueMap<String, String> formParams = new LinkedMultiValueMap<>();
        formParams.add("grant_type", tokenRequest.getGrantType());
        formParams.add("client_id", tokenRequest.getClientId());
        formParams.add("client_secret", tokenRequest.getClientSecret());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formParams, headers);

        ResponseEntity<AvitoTokenResponseDTO> response = restTemplate.exchange(
                AvitoApiConst.AVITO_TOKEN_API_URL,
                HttpMethod.POST,
                request,
                AvitoTokenResponseDTO.class
        );

        return response.getBody().getAccessToken();
    }
}
