package br.com.rtrancoso.notification.worker.broker.listener;

import br.com.rtrancoso.notification.commons.broker.event.EmailNotifyEventSource;
import br.com.rtrancoso.notification.worker.facade.EmailNotificationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailNotifyEventListener {

    private final EmailNotificationFacade emailNotificationFacade;

    @Bean
    public Consumer<Message<EmailNotifyEventSource>> emailNotifyEventSourceConsumer() {
        return message -> {
            log.info("received message on channel 'emailNotifyEventSourceConsumer' notification {}", message.getPayload().getNotificationId());
            emailNotificationFacade.notify(message.getPayload().getNotificationId());
        };
    }

}
