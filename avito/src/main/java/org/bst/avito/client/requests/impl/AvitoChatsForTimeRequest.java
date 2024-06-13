package org.bst.avito.client.requests.impl;

import lombok.Data;
import org.bst.avito.client.requests.AvitoPostRequest;
import org.bst.avito.client.requests.NeedXSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Data
public class AvitoChatsForTimeRequest implements AvitoPostRequest, NeedXSource {

    private String dateTimeFrom;

    private Long limit;

    private Long offset;

    @Override
    public String getMethodPath() {
        return "/cpa/v2/chatsByTime";
    }

    public void setDateTimeFrom(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        this.dateTimeFrom = date.atOffset(ZoneOffset.UTC).format(formatter);
    }
}
