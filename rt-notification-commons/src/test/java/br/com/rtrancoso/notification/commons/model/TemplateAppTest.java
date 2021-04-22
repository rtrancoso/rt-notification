package br.com.rtrancoso.notification.commons.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TemplateAppTest {

    private static final String MESSAGE = "MESSAGE";

    @Test
    void callNoArgsConstructor_ReturnsTemplateApp() {
        TemplateApp templateApp = new TemplateApp();
        templateApp.setMessage(MESSAGE);

        assertNotNull(templateApp.getMessage());
    }

    @Test
    void callAllArgsConstructor_ReturnsTemplateApp() {
        TemplateApp templateApp = new TemplateApp(MESSAGE);

        assertNotNull(templateApp.getMessage());
    }

    @Test
    void callBuilder_ReturnsTemplateApp() {
        TemplateApp templateApp = TemplateApp.builder()
            .message(MESSAGE)
            .build();

        assertNotNull(templateApp.getMessage());
    }

}
