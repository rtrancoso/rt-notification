package br.com.rtrancoso.notification.commons.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TemplateWhatsAppTest {

    private static final String MESSAGE = "MESSAGE";

    @Test
    void callNoArgsConstructor_ReturnsTemplateWhatsApp() {
        TemplateWhatsApp templateWhatsApp = new TemplateWhatsApp();
        templateWhatsApp.setMessage(MESSAGE);

        assertNotNull(templateWhatsApp.getMessage());
    }

    @Test
    void callAllArgsConstructor_ReturnsTemplateWhatsApp() {
        TemplateWhatsApp templateWhatsApp = new TemplateWhatsApp(MESSAGE);

        assertNotNull(templateWhatsApp.getMessage());
    }

    @Test
    void callBuilder_ReturnsTemplateWhatsApp() {
        TemplateWhatsApp templateWhatsApp = TemplateWhatsApp.builder()
            .message(MESSAGE)
            .build();

        assertNotNull(templateWhatsApp.getMessage());
    }

}
