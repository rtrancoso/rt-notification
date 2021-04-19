package br.com.rtrancoso.notification.commons.model;

import br.com.rtrancoso.notification.commons.enums.ExceptionCode;
import br.com.rtrancoso.springboot.base.exception.model.Error;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class InvalidNotificationTest {

    private static final String ID = "ID";
    private static final LocalDateTime CREATED_AT = LocalDateTime.now();
    private static final String REALM = "REALM";
    private static final String SYSTEM = "SYSTEM";
    private static final String TEMPLATE_KEY = "TEMPLATE_KEY";
    private static final List<Notification.Channel> CHANNELS = List.of(Notification.Channel.APP, Notification.Channel.PUSH);
    private static final Map<String, String> PARAMS = Map.of("PARAM_1", "VALUE_1", "PARAM_2", "VALUE_2");
    private static final List<Error> ERRORS = List.of(ExceptionCode.NOTIFICATION_001);

    @Test
    void callNoArgsConstructor_ReturnsInvalidNotification() {
        InvalidNotification invalidNotification = new InvalidNotification();
        invalidNotification.setId(ID);
        invalidNotification.setCreatedAt(CREATED_AT);
        invalidNotification.setRealm(REALM);
        invalidNotification.setSystem(SYSTEM);
        invalidNotification.setTemplateKey(TEMPLATE_KEY);
        invalidNotification.setChannels(CHANNELS);
        invalidNotification.setParams(PARAMS);
        invalidNotification.setErrors(ERRORS);

        assertNotNull(invalidNotification.getId());
        assertNotNull(invalidNotification.getCreatedAt());
        assertNotNull(invalidNotification.getRealm());
        assertNotNull(invalidNotification.getSystem());
        assertNotNull(invalidNotification.getTemplateKey());
        assertNotNull(invalidNotification.getChannels());
        assertNotNull(invalidNotification.getParams());
        assertNotNull(invalidNotification.getErrors());
    }

    @Test
    void callAllArgsConstructor_ReturnsInvalidNotification() {
        InvalidNotification invalidNotification = new InvalidNotification(ID, CREATED_AT, REALM, SYSTEM, TEMPLATE_KEY, CHANNELS, PARAMS, ERRORS);

        assertNotNull(invalidNotification.getId());
        assertNotNull(invalidNotification.getCreatedAt());
        assertNotNull(invalidNotification.getRealm());
        assertNotNull(invalidNotification.getSystem());
        assertNotNull(invalidNotification.getTemplateKey());
        assertNotNull(invalidNotification.getChannels());
        assertNotNull(invalidNotification.getParams());
        assertNotNull(invalidNotification.getErrors());
    }

    @Test
    void callBuilder_ReturnsInvalidNotification() {
        InvalidNotification invalidNotification = InvalidNotification.builder()
            .id(ID)
            .createdAt(CREATED_AT)
            .realm(REALM)
            .system(SYSTEM)
            .templateKey(TEMPLATE_KEY)
            .channels(CHANNELS)
            .params(PARAMS)
            .errors(ERRORS)
            .build();

        assertNotNull(invalidNotification.getId());
        assertNotNull(invalidNotification.getCreatedAt());
        assertNotNull(invalidNotification.getRealm());
        assertNotNull(invalidNotification.getSystem());
        assertNotNull(invalidNotification.getTemplateKey());
        assertNotNull(invalidNotification.getChannels());
        assertNotNull(invalidNotification.getParams());
        assertNotNull(invalidNotification.getErrors());
    }

}
