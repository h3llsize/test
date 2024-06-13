package org.bst.avito.dto;

import lombok.Data;

@Data
public class AvitoAdvertDTO {
    private String address;

    private AvitoCategoryDTO category;

    private Long id;

    private Long price;

    private String status;

    private String title;

    private String url;
}
