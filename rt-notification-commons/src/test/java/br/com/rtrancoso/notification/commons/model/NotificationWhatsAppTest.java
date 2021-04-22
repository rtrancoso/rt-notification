package br.com.rtrancoso.notification.commons.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotificationWhatsAppTest {

    private static final LocalDateTime SENT_AT = LocalDateTime.now();
    private static final String RECEIVER = "RECEIVER";
    private static final String MESSAGE = "MESSAGE";

    @Test
    void callNoArgsConstructor_ReturnsNotificationWhatsApp() {
        NotificationWhatsApp notificationWhatsApp = new NotificationWhatsApp();
        notificationWhatsApp.setSentAt(SENT_AT);
        notificationWhatsApp.setReceiver(RECEIVER);
        notificationWhatsApp.setMessage(MESSAGE);

        assertNotNull(notificationWhatsApp.getSentAt());
        assertNotNull(notificationWhatsApp.getReceiver());
        assertNotNull(notificationWhatsApp.getMessage());
    }

    @Test
    void callAllArgsConstructor_ReturnsNotificationWhatsApp() {
        NotificationWhatsApp notificationWhatsApp = new NotificationWhatsApp(SENT_AT, RECEIVER, MESSAGE);

        assertNotNull(notificationWhatsApp.getSentAt());
        assertNotNull(notificationWhatsApp.getReceiver());
        assertNotNull(notificationWhatsApp.getMessage());
    }

    @Test
    void callBuilder_ReturnsNotificationWhatsApp() {
        NotificationWhatsApp notificationWhatsApp = NotificationWhatsApp.builder()
            .sentAt(SENT_AT)
            .receiver(RECEIVER)
            .message(MESSAGE)
            .build();

        assertNotNull(notificationWhatsApp.getSentAt());
        assertNotNull(notificationWhatsApp.getReceiver());
        assertNotNull(notificationWhatsApp.getMessage());
    }

}
