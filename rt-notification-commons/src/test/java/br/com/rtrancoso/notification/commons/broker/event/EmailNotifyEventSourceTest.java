package br.com.rtrancoso.notification.commons.broker.event;

import br.com.rtrancoso.notification.commons.enums.NotificationEventType;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmailNotifyEventSourceTest {

    private static final String NOTIFICATION_ID = "NOTIFICATION_ID";

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void callAllArgsConstructor_ReturnsEmailNotifyEventSource() {
        EmailNotifyEventSource emailNotifyEventSource = new EmailNotifyEventSource(NOTIFICATION_ID);

        assertNotNull(emailNotifyEventSource.getNotificationId());
    }

    @Test
    void callBuilder_ReturnsEmailNotifyEventSource() {
        EmailNotifyEventSource emailNotifyEventSource = EmailNotifyEventSource.builder()
            .notificationId(NOTIFICATION_ID)
            .build();

        assertNotNull(emailNotifyEventSource.getEventType());
    }

    @Test
    void callGetEventType_ReturnsAPP_NOTIFY() {
        EmailNotifyEventSource emailNotifyEventSource = easyRandom.nextObject(EmailNotifyEventSource.class);

        assertEquals(NotificationEventType.EMAIL_NOTIFY, emailNotifyEventSource.getEventType());
    }

}
