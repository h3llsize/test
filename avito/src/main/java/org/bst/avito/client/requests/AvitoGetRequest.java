package org.bst.avito.client.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface AvitoGetRequest {

    /**
     * USER_ID - replacement profileId from config path
     *
     * @return method path
     */
    @JsonIgnore
    String getMethodPath();
}
