package br.com.rtrancoso.notification.worker.broker.listener;

import br.com.rtrancoso.notification.commons.broker.event.NotifyEventSource;
import br.com.rtrancoso.notification.worker.facade.NotificationFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class NotifyEventListener {

    @Bean
    public Consumer<Message<NotifyEventSource>> notifyEventSourceConsumer(NotificationFacade notificationFacade) {
        return message -> {
            log.info("received message on channel 'notifyEventSourceConsumer'");
            notificationFacade.processEvent(message.getPayload());
        };
    }

}
