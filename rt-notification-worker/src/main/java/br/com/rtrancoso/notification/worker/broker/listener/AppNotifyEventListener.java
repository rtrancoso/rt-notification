package br.com.rtrancoso.notification.worker.broker.listener;

import br.com.rtrancoso.notification.commons.broker.event.AppNotifyEventSource;
import br.com.rtrancoso.notification.worker.facade.AppNotificationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppNotifyEventListener {

    private final AppNotificationFacade appNotificationFacade;

    @Bean
    public Consumer<Message<AppNotifyEventSource>> appNotifyEventSourceConsumer() {
        return message -> {
            log.info("received message on channel 'appNotifyEventSourceConsumer' notification {}", message.getPayload().getNotificationId());
            appNotificationFacade.notify(message.getPayload().getNotificationId());
        };
    }

}
