package br.com.rtrancoso.notification.commons.broker.event;

import br.com.rtrancoso.notification.commons.enums.NotificationEventType;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SmsNotifyEventSourceTest {

    private static final String NOTIFICATION_ID = "NOTIFICATION_ID";

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void callAllArgsConstructor_ReturnsSmsNotifyEventSource() {
        SmsNotifyEventSource smsNotifyEventSource = new SmsNotifyEventSource(NOTIFICATION_ID);

        assertNotNull(smsNotifyEventSource.getNotificationId());
    }

    @Test
    void callBuilder_ReturnsSmsNotifyEventSource() {
        SmsNotifyEventSource smsNotifyEventSource = SmsNotifyEventSource.builder()
            .notificationId(NOTIFICATION_ID)
            .build();

        assertNotNull(smsNotifyEventSource.getEventType());
    }

    @Test
    void callGetEventType_ReturnsAPP_NOTIFY() {
        SmsNotifyEventSource smsNotifyEventSource = easyRandom.nextObject(SmsNotifyEventSource.class);

        assertEquals(NotificationEventType.SMS_NOTIFY, smsNotifyEventSource.getEventType());
    }

}
