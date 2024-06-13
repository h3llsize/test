package org.bst.avito.dto;

import lombok.Data;

@Data
public class AvitoCallDTO {
    private String buyerPhone;

    private String callId;

    private String callTime;

    private String sellerPhone;

    private Long talkDuration;

    private String virtualPhone;

    private Long itemId;

    private Long waitingDuration;
}
