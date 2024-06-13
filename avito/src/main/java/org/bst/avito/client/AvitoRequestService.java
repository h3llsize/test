package org.bst.avito.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bst.avito.client.requests.AvitoGetRequest;
import org.bst.avito.client.requests.AvitoPostRequest;
import org.bst.avito.client.requests.NeedXSource;
import org.bst.avito.increptors.HeaderRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
public class AvitoRequestService {
    private final RestTemplate restTemplate;

    private final AvitoConfigParamsService avitoConfigParamsService;

    public AvitoRequestService(RestTemplate restTemplate, AvitoConfigParamsService avitoConfigParamsService) {
        this.restTemplate = restTemplate;
        this.avitoConfigParamsService = avitoConfigParamsService;
    }

    public <T> T sendRequest(AvitoPostRequest request, Class<T> response) {
        String url = AvitoApiConst.AVITO_API_URL + request.getMethodPath();
        return restTemplate.postForObject(url, request, response, url);
    }

    public <T> T sendRequest(AvitoGetRequest request, Class<T> response) {
        String url = AvitoApiConst.AVITO_API_URL + request.getMethodPath().replaceAll("USER_ID", avitoConfigParamsService.getProfileId());
        return sendRequest(request, response, url);
    }
    public <T> T sendRequestWithChatId(AvitoPostRequest request, Class<T> response, String chatId) {
        String url = AvitoApiConst.AVITO_API_URL + request.getMethodPath().replaceAll("USER_ID", avitoConfigParamsService.getProfileId())
                .replaceAll("CHAT_ID", chatId);

        return sendRequest(request, response, url);
    }


    /**
     *
     * Two main methods
     *
     */

    public <T> T sendRequest(AvitoPostRequest request, Class<T> response, String url) {
        if(request instanceof NeedXSource) {
            restTemplate.getInterceptors().add(new HeaderRequestInterceptor("X-Source", AvitoApiConst.SERVICE_NAME));
        }

            return restTemplate.postForObject(url, request, response);
    }


    public <T> T sendRequest(AvitoGetRequest request, Class<T> response, String url) {
        if(request instanceof NeedXSource) {
            restTemplate.getInterceptors().add(new HeaderRequestInterceptor("X-Source", AvitoApiConst.SERVICE_NAME));
        }

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> options = objectMapper.convertValue(request, new TypeReference<>() {});

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        options.forEach(builder::queryParam);

        return restTemplate.getForObject(builder.toUriString(), response);

    }
}
