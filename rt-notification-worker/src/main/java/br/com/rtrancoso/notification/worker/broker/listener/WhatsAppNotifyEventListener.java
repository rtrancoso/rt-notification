package br.com.rtrancoso.notification.worker.broker.listener;

import br.com.rtrancoso.notification.commons.broker.event.WhatsAppNotifyEventSource;
import br.com.rtrancoso.notification.worker.facade.WhatsAppNotificationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class WhatsAppNotifyEventListener {

    private final WhatsAppNotificationFacade whatsAppNotificationFacade;

    @Bean
    public Consumer<Message<WhatsAppNotifyEventSource>> whatsAppNotifyEventSourceConsumer() {
        return message -> {
            log.info("received message on channel 'whatsAppNotifyEventSourceConsumer' notification {}", message.getPayload().getNotificationId());
            whatsAppNotificationFacade.notify(message.getPayload().getNotificationId());
        };
    }

}
