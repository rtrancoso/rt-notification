package br.com.rtrancoso.notification.commons.broker.event;

import br.com.rtrancoso.notification.commons.enums.NotificationEventType;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PushNotifyEventSourceTest {

    private static final String NOTIFICATION_ID = "NOTIFICATION_ID";

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void callAllArgsConstructor_ReturnsPushNotifyEventSource() {
        PushNotifyEventSource pushNotifyEventSource = new PushNotifyEventSource(NOTIFICATION_ID);

        assertNotNull(pushNotifyEventSource.getNotificationId());
    }

    @Test
    void callBuilder_ReturnsPushNotifyEventSource() {
        PushNotifyEventSource pushNotifyEventSource = PushNotifyEventSource.builder()
            .notificationId(NOTIFICATION_ID)
            .build();

        assertNotNull(pushNotifyEventSource.getEventType());
    }

    @Test
    void callGetEventType_ReturnsAPP_NOTIFY() {
        PushNotifyEventSource pushNotifyEventSource = easyRandom.nextObject(PushNotifyEventSource.class);

        assertEquals(NotificationEventType.PUSH_NOTIFY, pushNotifyEventSource.getEventType());
    }

}
