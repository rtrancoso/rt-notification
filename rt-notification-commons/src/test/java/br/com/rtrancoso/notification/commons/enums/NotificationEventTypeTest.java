package br.com.rtrancoso.notification.commons.enums;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotificationEventTypeTest {

    private static final Map<String, NotificationEventType> NOTIFICATION_EVENT_TYPE_MAP = new HashMap<>();

    @BeforeAll
    static void setup() {
        for (NotificationEventType notificationEventType : NotificationEventType.values()) {
            NOTIFICATION_EVENT_TYPE_MAP.put(notificationEventType.name(), notificationEventType);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "NOTIFY", "APP_NOTIFY", "EMAIL_NOTIFY", "PUSH_NOTIFY", "SMS_NOTIFY", "WHATSAPP_NOTIFY"
    })
    void existsNotificationEventsType_ReturnsTrue(String notificationEventTypeName) {
        assertNotNull(NOTIFICATION_EVENT_TYPE_MAP.get(notificationEventTypeName));
    }

    @ParameterizedTest
    @CsvSource({
        "NOTIFY,notify-output",
        "APP_NOTIFY,app-notify-output",
        "EMAIL_NOTIFY,email-notify-output",
        "PUSH_NOTIFY,push-notify-output",
        "SMS_NOTIFY,sms-notify-output",
        "WHATSAPP_NOTIFY,whatsapp-notify-output"
    })
    void verifyChannel_ReturnsTrue(String notificationEventTypeName, String notificationEventTypeChannel) {
        assertEquals(notificationEventTypeChannel, NOTIFICATION_EVENT_TYPE_MAP.get(notificationEventTypeName).getChannel());
    }

}
