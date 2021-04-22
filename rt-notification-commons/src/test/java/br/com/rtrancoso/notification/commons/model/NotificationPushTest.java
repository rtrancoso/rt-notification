package br.com.rtrancoso.notification.commons.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotificationPushTest {

    private static final LocalDateTime SENT_AT = LocalDateTime.now();
    private static final String RECEIVER = "RECEIVER";
    private static final String TITLE = "TITLE";
    private static final String BODY = "BODY";

    @Test
    void callNoArgsConstructor_ReturnsNotificationPush() {
        NotificationPush notificationPush = new NotificationPush();
        notificationPush.setSentAt(SENT_AT);
        notificationPush.setReceiver(RECEIVER);
        notificationPush.setTitle(TITLE);
        notificationPush.setBody(BODY);

        assertNotNull(notificationPush.getSentAt());
        assertNotNull(notificationPush.getReceiver());
        assertNotNull(notificationPush.getTitle());
        assertNotNull(notificationPush.getBody());
    }

    @Test
    void callAllArgsConstructor_ReturnsNotificationPush() {
        NotificationPush notificationPush = new NotificationPush(SENT_AT, RECEIVER, TITLE, BODY);

        assertNotNull(notificationPush.getSentAt());
        assertNotNull(notificationPush.getReceiver());
        assertNotNull(notificationPush.getTitle());
        assertNotNull(notificationPush.getBody());
    }

    @Test
    void callBuilder_ReturnsNotificationPush() {
        NotificationPush notificationPush = NotificationPush.builder()
            .sentAt(SENT_AT)
            .receiver(RECEIVER)
            .title(TITLE)
            .body(BODY)
            .build();

        assertNotNull(notificationPush.getSentAt());
        assertNotNull(notificationPush.getReceiver());
        assertNotNull(notificationPush.getTitle());
        assertNotNull(notificationPush.getBody());
    }

}
