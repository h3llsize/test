package org.bst.avito.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AvitoMessageDTO {

    @JsonProperty("author_id")
    private Long authorId;

    private AvitoMessageContentDTO content;

    private Long created;

    private String direction;

    private String id;

    private String type;
}
