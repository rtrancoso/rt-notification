package br.com.rtrancoso.notification.commons.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotificationAppTest {

    private static final LocalDateTime SENT_AT = LocalDateTime.now();
    private static final String RECEIVER = "RECEIVER";
    private static final String MESSAGE = "MESSAGE";

    @Test
    void callNoArgsConstructor_ReturnsNotificationApp() {
        NotificationApp notificationApp = new NotificationApp();
        notificationApp.setSentAt(SENT_AT);
        notificationApp.setReceiver(RECEIVER);
        notificationApp.setMessage(MESSAGE);

        assertNotNull(notificationApp.getSentAt());
        assertNotNull(notificationApp.getReceiver());
        assertNotNull(notificationApp.getMessage());
    }

    @Test
    void callAllArgsConstructor_ReturnsNotificationApp() {
        NotificationApp notificationApp = new NotificationApp(SENT_AT, RECEIVER, MESSAGE);

        assertNotNull(notificationApp.getSentAt());
        assertNotNull(notificationApp.getReceiver());
        assertNotNull(notificationApp.getMessage());
    }

    @Test
    void callBuilder_ReturnsNotificationApp() {
        NotificationApp notificationApp = NotificationApp.builder()
            .sentAt(SENT_AT)
            .receiver(RECEIVER)
            .message(MESSAGE)
            .build();

        assertNotNull(notificationApp.getSentAt());
        assertNotNull(notificationApp.getReceiver());
        assertNotNull(notificationApp.getMessage());
    }

}
