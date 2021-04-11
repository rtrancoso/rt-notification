package br.com.rtrancoso.notification.worker.channel.impl;

import br.com.rtrancoso.notification.commons.broker.event.WhatsAppNotifyEventSource;
import br.com.rtrancoso.notification.commons.model.Notification;
import br.com.rtrancoso.notification.worker.channel.ChannelNotifier;
import br.com.rtrancoso.springboot.base.stream.event.producer.EventProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class WhatsAppChannelNotifier implements ChannelNotifier {

    private final EventProducer eventProducer;

    @Override
    public Notification.Channel getChannel() {
        return Notification.Channel.WHATSAPP;
    }

    @Override
    public void dispatchEvent(final String notificationId) {
        log.info("sending event to notify by channel {} the notification {}", getChannel(), notificationId);
        eventProducer.sendMessage(WhatsAppNotifyEventSource.builder().notificationId(notificationId).build());
    }

}
