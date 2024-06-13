package org.bst.avito.client.requests.impl;

import lombok.Data;
import org.bst.avito.client.requests.AvitoPostRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class AvitoGetCallsFromTimeRequest implements AvitoPostRequest {
    private String dateTimeFrom;

    private String dateTimeTo;

    private Long limit;

    private Long offset;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public void setDateTimeFrom(LocalDateTime dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom.format(formatter);
    }

    public void setDateTimeTo(LocalDateTime dateTimeTo) {
        this.dateTimeTo = dateTimeTo.format(formatter);
    }

    @Override
    public String getMethodPath() {
        return "/calltracking/v1/getCalls/";
    }
}
