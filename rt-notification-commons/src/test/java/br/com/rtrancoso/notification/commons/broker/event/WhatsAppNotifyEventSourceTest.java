package br.com.rtrancoso.notification.commons.broker.event;

import br.com.rtrancoso.notification.commons.enums.NotificationEventType;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WhatsWhatsAppNotifyEventSourceTest {

    private static final String NOTIFICATION_ID = "NOTIFICATION_ID";

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void callAllArgsConstructor_ReturnsWhatsWhatsAppNotifyEventSource() {
        WhatsAppNotifyEventSource whatsAppNotifyEventSource = new WhatsAppNotifyEventSource(NOTIFICATION_ID);

        assertNotNull(whatsAppNotifyEventSource.getNotificationId());
    }

    @Test
    void callBuilder_ReturnsWhatsAppNotifyEventSource() {
        WhatsAppNotifyEventSource whatsAppNotifyEventSource = WhatsAppNotifyEventSource.builder()
            .notificationId(NOTIFICATION_ID)
            .build();

        assertNotNull(whatsAppNotifyEventSource.getEventType());
    }

    @Test
    void callGetEventType_ReturnsAPP_NOTIFY() {
        WhatsAppNotifyEventSource whatsAppNotifyEventSource = easyRandom.nextObject(WhatsAppNotifyEventSource.class);

        assertEquals(NotificationEventType.WHATSAPP_NOTIFY, whatsAppNotifyEventSource.getEventType());
    }

}
