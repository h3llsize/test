package org.bst.avito.scheduler;

import org.bst.avito.client.AvitoCallTrackerService;
import org.bst.avito.client.AvitoMessengerService;
import org.bst.avito.dto.AvitoCallDTO;
import org.bst.avito.dto.AvitoChatDTO;
import org.bst.avito.service.handler.AvitoCallWorker;
import org.bst.avito.service.handler.AvitoChatWorker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@EnableScheduling
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class AvitoScheduler {

    private final AvitoMessengerService avitoMessengerService;

    private final AvitoCallTrackerService avitoCallTrackerService;

//    private final AvitoActionWorker avitoActionWorker;

    private final AvitoChatWorker avitoChatWorker;

    private final AvitoCallWorker avitoCallWorker;

    private final static int DELAY = 30;

    public AvitoScheduler(AvitoMessengerService avitoMessengerService, AvitoCallTrackerService avitoCallTrackerService, AvitoChatWorker avitoChatWorker, AvitoCallWorker avitoCallWorker) {
        this.avitoMessengerService = avitoMessengerService;
        this.avitoCallTrackerService = avitoCallTrackerService;
        this.avitoChatWorker = avitoChatWorker;
        this.avitoCallWorker = avitoCallWorker;
    }

    @Scheduled(fixedDelay = DELAY, timeUnit = TimeUnit.SECONDS)
    private void scheduleMessages() {
        List<AvitoChatDTO> avitoChatDTOS = avitoMessengerService.getChats(true).getChats();

        for (AvitoChatDTO avitoChatDTO : avitoChatDTOS) {
            avitoChatWorker.handle(avitoChatDTO);
        }
    }

    @Scheduled(fixedDelay = DELAY, timeUnit = TimeUnit.SECONDS)
    private void scheduleCalls() {
        List<AvitoCallDTO> avitoCallDTOS = avitoCallTrackerService.getCalls(LocalDateTime.now().minusSeconds(DELAY + 5));

        for (AvitoCallDTO avitoCallDTO : avitoCallDTOS) {
            avitoCallWorker.handle(avitoCallDTO);
        }
    }
}
