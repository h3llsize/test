package org.bst.avito;

import org.bst.avito.client.*;
import org.bst.avito.client.requests.impl.AvitoChatsForTimeRequest;
import org.bst.avito.client.requests.impl.AvitoGetCallsFromTimeRequest;
import org.bst.avito.client.requests.impl.AvitoGetChatsResponse;
import org.bst.avito.dto.AvitoMessageDTO;
import org.bst.avito.scheduler.AvitoScheduler;
import org.bst.avito.service.handler.deprecated.impl.AvitoChatActionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RequestTests {

    @Autowired
    private AvitoRequestService avitoRequestService;

    @Autowired
    private AvitoTokenUpdateService avitoTokenUpdateService;

    @Autowired
    private AvitoAuthService avitoAuthService;

    @Autowired
    private AvitoMessengerService avitoMessengerService;

    @Autowired
    private AvitoChatActionHandler avitoChatActionHandler;

    @Autowired
    private AvitoScheduler avitoScheduler;

    @Autowired
    private CrmTokenUpdateService crmTokenUpdateService;

    @Test
    void testAvitoChatsFromTimeRequest() {
        AvitoChatsForTimeRequest avitoChatsForTimeRequest = new AvitoChatsForTimeRequest();
        LocalDateTime localDateTime = LocalDateTime.now().minus(96, TimeUnit.HOURS.toChronoUnit());

        avitoChatsForTimeRequest.setDateTimeFrom(localDateTime);
        avitoChatsForTimeRequest.setOffset(0L);
        avitoChatsForTimeRequest.setLimit(2L);

        String response = avitoRequestService.sendRequest(avitoChatsForTimeRequest, String.class);

        System.out.println(response);
    }

    @Test
    void testAvitoGetChats() {
        AvitoGetChatsResponse avitoGetChatsResponse = avitoMessengerService.getChats(true);

        System.out.println(avitoGetChatsResponse.getChats().get(0).getId());
    }

    @Test
    void testTokenUpdateService() {
        String token = avitoTokenUpdateService.updateToken();

        System.out.println(token);
    }

    @Test
    void testSendMessage() {
        AvitoMessageDTO avitoSendMessageResponse = avitoMessengerService.sendMessage("u2i-XEdKcITW0AVftinbclRNqw", "Тестовое сообщение");

        System.out.println(avitoSendMessageResponse.getContent().getText());
    }

    @Test
    void testGetCalls() {
        AvitoGetCallsFromTimeRequest avitoGetCallsFromTimeRequest = new AvitoGetCallsFromTimeRequest();
        avitoGetCallsFromTimeRequest.setDateTimeFrom(LocalDateTime.now().minusHours(10));
        avitoGetCallsFromTimeRequest.setDateTimeTo(LocalDateTime.now());
        avitoGetCallsFromTimeRequest.setOffset(0L);
        avitoGetCallsFromTimeRequest.setLimit(100L);

        String response = avitoRequestService.sendRequest(avitoGetCallsFromTimeRequest, String.class);

        System.out.println(response);
    }

    @Test
    void testGetGenericClassName() {
        System.out.println(avitoChatActionHandler.getClassHandled());
    }
//
//    @Test
//    void testCrmUpdate() {
//        System.out.println(crmTokenUpdateService.updateToken());
//    }
}
