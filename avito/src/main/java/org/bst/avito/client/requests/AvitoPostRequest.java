package org.bst.avito.client.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface AvitoPostRequest {
    @JsonIgnore
    String getMethodPath();
}
