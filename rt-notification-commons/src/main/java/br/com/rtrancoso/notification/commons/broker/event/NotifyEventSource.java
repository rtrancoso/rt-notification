package br.com.rtrancoso.notification.commons.broker.event;

import br.com.rtrancoso.notification.commons.enums.NotificationEventType;
import br.com.rtrancoso.notification.commons.model.Notification;
import br.com.rtrancoso.springboot.base.stream.event.EventSource;
import br.com.rtrancoso.springboot.base.stream.event.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotifyEventSource implements EventSource {

    private String realm;
    private String templateKey;
    private List<Notification.Channel> channels;
    private Map<String, String> params;

    @Override
    public EventType getEventType() {
        return NotificationEventType.NOTIFY;
    }

}
