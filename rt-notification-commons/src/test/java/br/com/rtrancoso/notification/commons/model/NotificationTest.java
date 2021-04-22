package br.com.rtrancoso.notification.commons.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotificationTest {

    private static final String ID = "ID";
    private static final LocalDateTime CREATED_AT = LocalDateTime.now();
    private static final String REALM = "REALM";
    private static final String TEMPLATE_KEY = "TEMPLATE_KEY";
    private static final List<Notification.Channel> CHANNELS = List.of(Notification.Channel.APP, Notification.Channel.PUSH);
    private static final Map<String, String> PARAMS = Map.of("PARAM_1", "VALUE_1", "PARAM_2", "VALUE_2");

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void callNoArgsConstructor_ReturnsNotification() {
        Notification notification = new Notification();
        notification.setId(ID);
        notification.setCreatedAt(CREATED_AT);
        notification.setRealm(REALM);
        notification.setTemplateKey(TEMPLATE_KEY);
        notification.setChannels(CHANNELS);
        notification.setParams(PARAMS);
        notification.setNotificationApp(getValidAppExample());
        notification.setNotificationEmail(getValidEmailExample());
        notification.setNotificationPush(getValidPushExample());
        notification.setNotificationSms(getValidSmsExample());
        notification.setNotificationWhatsApp(getValidWhatsAppExample());

        assertNotNull(notification.getId());
        assertNotNull(notification.getCreatedAt());
        assertNotNull(notification.getRealm());
        assertNotNull(notification.getTemplateKey());
        assertNotNull(notification.getChannels());
        assertNotNull(notification.getParams());
        assertNotNull(notification.getNotificationApp());
        assertNotNull(notification.getNotificationEmail());
        assertNotNull(notification.getNotificationPush());
        assertNotNull(notification.getNotificationSms());
        assertNotNull(notification.getNotificationWhatsApp());
    }

    @Test
    void callAllArgsConstructor_ReturnsNotification() {
        Notification notification = new Notification(ID, CREATED_AT, REALM, TEMPLATE_KEY, CHANNELS, PARAMS, getValidAppExample(),
            getValidEmailExample(), getValidPushExample(), getValidSmsExample(), getValidWhatsAppExample());

        assertNotNull(notification.getId());
        assertNotNull(notification.getCreatedAt());
        assertNotNull(notification.getRealm());
        assertNotNull(notification.getTemplateKey());
        assertNotNull(notification.getChannels());
        assertNotNull(notification.getParams());
        assertNotNull(notification.getNotificationApp());
        assertNotNull(notification.getNotificationEmail());
        assertNotNull(notification.getNotificationPush());
        assertNotNull(notification.getNotificationSms());
        assertNotNull(notification.getNotificationWhatsApp());
    }

    @Test
    void callBuilder_ReturnsNotification() {
        Notification notification = Notification.builder()
            .id(ID)
            .createdAt(CREATED_AT)
            .realm(REALM)
            .templateKey(TEMPLATE_KEY)
            .channels(CHANNELS)
            .params(PARAMS)
            .notificationApp(getValidAppExample())
            .notificationEmail(getValidEmailExample())
            .notificationPush(getValidPushExample())
            .notificationSms(getValidSmsExample())
            .notificationWhatsApp(getValidWhatsAppExample())
            .build();

        assertNotNull(notification.getId());
        assertNotNull(notification.getCreatedAt());
        assertNotNull(notification.getRealm());
        assertNotNull(notification.getTemplateKey());
        assertNotNull(notification.getChannels());
        assertNotNull(notification.getParams());
        assertNotNull(notification.getNotificationApp());
        assertNotNull(notification.getNotificationEmail());
        assertNotNull(notification.getNotificationPush());
        assertNotNull(notification.getNotificationSms());
        assertNotNull(notification.getNotificationWhatsApp());
    }

    private NotificationApp getValidAppExample() {
        return easyRandom.nextObject(NotificationApp.class);
    }

    private NotificationEmail getValidEmailExample() {
        return easyRandom.nextObject(NotificationEmail.class);
    }

    private NotificationPush getValidPushExample() {
        return easyRandom.nextObject(NotificationPush.class);
    }

    private NotificationSms getValidSmsExample() {
        return easyRandom.nextObject(NotificationSms.class);
    }

    private NotificationWhatsApp getValidWhatsAppExample() {
        return easyRandom.nextObject(NotificationWhatsApp.class);
    }

}
