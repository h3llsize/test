package org.bst.avito.client;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AvitoConfigParamsService {

    @Value("${service.secret_key}")
    private String secretKey;

    @Value("${service.client_id}")
    private String clientId;

    @Value("${service.profile_id}")
    private String profileId;

    @Value("${crm.client_id}")
    private String crmClient;

    @Value("${crm.secret}")
    private String crmSecret;
}
