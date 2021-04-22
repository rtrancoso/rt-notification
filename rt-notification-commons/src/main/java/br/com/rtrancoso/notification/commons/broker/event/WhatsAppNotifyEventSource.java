package br.com.rtrancoso.notification.commons.broker.event;

import br.com.rtrancoso.notification.commons.enums.NotificationEventType;
import br.com.rtrancoso.springboot.base.stream.event.EventSource;
import br.com.rtrancoso.springboot.base.stream.event.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class WhatsAppNotifyEventSource implements EventSource {

    private final String notificationId;

    @Override
    public EventType getEventType() {
        return NotificationEventType.WHATSAPP_NOTIFY;
    }

}
