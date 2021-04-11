package br.com.rtrancoso.notification.worker.broker.listener;

import br.com.rtrancoso.notification.commons.broker.event.PushNotifyEventSource;
import br.com.rtrancoso.notification.worker.facade.PushNotificationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class PushNotifyEventListener {

    private final PushNotificationFacade pushNotificationFacade;

    @Bean
    public Consumer<Message<PushNotifyEventSource>> pushNotifyEventSourceConsumer() {
        return message -> {
            log.info("received message on channel 'pushNotifyEventSourceConsumer' notification {}", message.getPayload().getNotificationId());
            pushNotificationFacade.notify(message.getPayload().getNotificationId());
        };
    }

}
