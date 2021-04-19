package br.com.rtrancoso.notification.commons.broker.event;

import br.com.rtrancoso.notification.commons.enums.NotificationEventType;
import br.com.rtrancoso.notification.commons.model.Notification;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotifyEventSourceTest {

    private static final String REALM = "REALM";
    private static final String TEMPLATE_KEY = "TEMPLATE_KEY";
    private static final List<Notification.Channel> CHANNELS = List.of(Notification.Channel.APP, Notification.Channel.PUSH);
    private static final Map<String, String> PARAMS = Map.of("PARAM_1", "VALUE_1", "PARAM_2", "VALUE_2");

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void callAllArgsConstructor_ReturnsNotifyEventSource() {
        NotifyEventSource notifyEventSource = new NotifyEventSource(REALM, TEMPLATE_KEY, CHANNELS, PARAMS);

        assertNotNull(notifyEventSource.getRealm());
        assertNotNull(notifyEventSource.getTemplateKey());
        assertNotNull(notifyEventSource.getChannels());
        assertNotNull(notifyEventSource.getParams());
    }

    @Test
    void callBuilder_ReturnsNotifyEventSource() {
        NotifyEventSource notifyEventSource = NotifyEventSource.builder()
            .realm(REALM)
            .templateKey(TEMPLATE_KEY)
            .channels(CHANNELS)
            .params(PARAMS)
            .build();

        assertNotNull(notifyEventSource.getRealm());
        assertNotNull(notifyEventSource.getTemplateKey());
        assertNotNull(notifyEventSource.getChannels());
        assertNotNull(notifyEventSource.getParams());
    }

    @Test
    void callGetEventType_ReturnsAPP_NOTIFY() {
        NotifyEventSource notifyEventSource = easyRandom.nextObject(NotifyEventSource.class);

        assertEquals(NotificationEventType.NOTIFY, notifyEventSource.getEventType());
    }

}
