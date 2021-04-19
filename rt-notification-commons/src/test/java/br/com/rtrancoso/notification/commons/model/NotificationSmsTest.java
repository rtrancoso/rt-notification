package br.com.rtrancoso.notification.commons.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotificationSmsTest {

    private static final LocalDateTime SENT_AT = LocalDateTime.now();
    private static final String RECEIVER = "RECEIVER";
    private static final String MESSAGE = "MESSAGE";

    @Test
    void callNoArgsConstructor_ReturnsNotificationSms() {
        NotificationSms notificationSms = new NotificationSms();
        notificationSms.setSentAt(SENT_AT);
        notificationSms.setReceiver(RECEIVER);
        notificationSms.setMessage(MESSAGE);

        assertNotNull(notificationSms.getSentAt());
        assertNotNull(notificationSms.getReceiver());
        assertNotNull(notificationSms.getMessage());
    }

    @Test
    void callAllArgsConstructor_ReturnsNotificationSms() {
        NotificationSms notificationSms = new NotificationSms(SENT_AT, RECEIVER, MESSAGE);

        assertNotNull(notificationSms.getSentAt());
        assertNotNull(notificationSms.getReceiver());
        assertNotNull(notificationSms.getMessage());
    }

    @Test
    void callBuilder_ReturnsNotificationSms() {
        NotificationSms notificationSms = NotificationSms.builder()
            .sentAt(SENT_AT)
            .receiver(RECEIVER)
            .message(MESSAGE)
            .build();

        assertNotNull(notificationSms.getSentAt());
        assertNotNull(notificationSms.getReceiver());
        assertNotNull(notificationSms.getMessage());
    }

}
