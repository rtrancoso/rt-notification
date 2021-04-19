package br.com.rtrancoso.notification.commons.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotificationEmailTest {

    private static final LocalDateTime SENT_AT = LocalDateTime.now();
    private static final String TEMPLATE_ID = "TEMPLATE_ID";
    private static final String TEMPLATE_CATEGORY = "TEMPLATE_CATEGORY";
    private static final String SENDER = "SENDER";
    private static final String SENDER_NAME = "SENDER_NAME";
    private static final String RECEIVER = "RECEIVER";
    private static final String RECEIVER_NAME = "RECEIVER_NAME";

    @Test
    void callNoArgsConstructor_ReturnsNotificationEmail() {
        NotificationEmail notificationEmail = new NotificationEmail();
        notificationEmail.setSentAt(SENT_AT);
        notificationEmail.setTemplateId(TEMPLATE_ID);
        notificationEmail.setTemplateCategory(TEMPLATE_CATEGORY);
        notificationEmail.setSender(SENDER);
        notificationEmail.setSenderName(SENDER_NAME);
        notificationEmail.setReceiver(RECEIVER);
        notificationEmail.setReceiverName(RECEIVER_NAME);

        assertNotNull(notificationEmail.getSentAt());
        assertNotNull(notificationEmail.getTemplateId());
        assertNotNull(notificationEmail.getTemplateCategory());
        assertNotNull(notificationEmail.getSender());
        assertNotNull(notificationEmail.getSenderName());
        assertNotNull(notificationEmail.getReceiver());
        assertNotNull(notificationEmail.getReceiverName());
    }

    @Test
    void callAllArgsConstructor_ReturnsNotificationEmail() {
        NotificationEmail notificationEmail = new NotificationEmail(SENT_AT, TEMPLATE_ID, TEMPLATE_CATEGORY, SENDER, SENDER_NAME, RECEIVER,
            RECEIVER_NAME);

        assertNotNull(notificationEmail.getSentAt());
        assertNotNull(notificationEmail.getTemplateId());
        assertNotNull(notificationEmail.getTemplateCategory());
        assertNotNull(notificationEmail.getSender());
        assertNotNull(notificationEmail.getSenderName());
        assertNotNull(notificationEmail.getReceiver());
        assertNotNull(notificationEmail.getReceiverName());
    }

    @Test
    void callBuilder_ReturnsNotificationEmail() {
        NotificationEmail notificationEmail = NotificationEmail.builder()
            .sentAt(SENT_AT)
            .templateId(TEMPLATE_ID)
            .templateCategory(TEMPLATE_CATEGORY)
            .sender(SENDER)
            .senderName(SENDER_NAME)
            .receiver(RECEIVER)
            .receiverName(RECEIVER_NAME)
            .build();

        assertNotNull(notificationEmail.getSentAt());
        assertNotNull(notificationEmail.getTemplateId());
        assertNotNull(notificationEmail.getTemplateCategory());
        assertNotNull(notificationEmail.getSender());
        assertNotNull(notificationEmail.getSenderName());
        assertNotNull(notificationEmail.getReceiver());
        assertNotNull(notificationEmail.getReceiverName());
    }

}
