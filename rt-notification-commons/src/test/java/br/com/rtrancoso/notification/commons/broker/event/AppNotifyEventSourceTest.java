package br.com.rtrancoso.notification.commons.broker.event;

import br.com.rtrancoso.notification.commons.enums.NotificationEventType;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppNotifyEventSourceTest {

    private static final String NOTIFICATION_ID = "NOTIFICATION_ID";

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void callAllArgsConstructor_ReturnsAppNotifyEventSource() {
        AppNotifyEventSource appNotifyEventSource = new AppNotifyEventSource(NOTIFICATION_ID);

        assertNotNull(appNotifyEventSource.getNotificationId());
    }

    @Test
    void callBuilder_ReturnsAppNotifyEventSource() {
        AppNotifyEventSource appNotifyEventSource = AppNotifyEventSource.builder()
            .notificationId(NOTIFICATION_ID)
            .build();

        assertNotNull(appNotifyEventSource.getEventType());
    }

    @Test
    void callGetEventType_ReturnsAPP_NOTIFY() {
        AppNotifyEventSource appNotifyEventSource = easyRandom.nextObject(AppNotifyEventSource.class);

        assertEquals(NotificationEventType.APP_NOTIFY, appNotifyEventSource.getEventType());
    }

}
