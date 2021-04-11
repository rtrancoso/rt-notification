package br.com.rtrancoso.notification.worker.broker.listener;

import br.com.rtrancoso.notification.commons.broker.event.SmsNotifyEventSource;
import br.com.rtrancoso.notification.worker.facade.SmsNotificationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class SmsNotifyEventListener {

    private final SmsNotificationFacade smsNotificationFacade;

    @Bean
    public Consumer<Message<SmsNotifyEventSource>> smsNotifyEventSourceConsumer() {
        return message -> {
            log.info("received message on channel 'smsNotifyEventSourceConsumer' notification {}", message.getPayload().getNotificationId());
            smsNotificationFacade.notify(message.getPayload().getNotificationId());
        };
    }

}
