package br.com.rtrancoso.notification.commons.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TemplateSmsTest {

    private static final String MESSAGE = "MESSAGE";

    @Test
    void callNoArgsConstructor_ReturnsTemplateSms() {
        TemplateSms templateSms = new TemplateSms();
        templateSms.setMessage(MESSAGE);

        assertNotNull(templateSms.getMessage());
    }

    @Test
    void callAllArgsConstructor_ReturnsTemplateSms() {
        TemplateSms templateSms = new TemplateSms(MESSAGE);

        assertNotNull(templateSms.getMessage());
    }

    @Test
    void callBuilder_ReturnsTemplateSms() {
        TemplateSms templateSms = TemplateSms.builder()
            .message(MESSAGE)
            .build();

        assertNotNull(templateSms.getMessage());
    }

}
