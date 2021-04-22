package br.com.rtrancoso.notification.commons.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TemplatePushTest {

    private static final String TITLE = "TITLE";
    private static final String BODY = "BODY";

    @Test
    void callNoArgsConstructor_ReturnsTemplatePush() {
        TemplatePush templatePush = new TemplatePush();
        templatePush.setTitle(TITLE);
        templatePush.setBody(BODY);

        assertNotNull(templatePush.getTitle());
        assertNotNull(templatePush.getBody());
    }

    @Test
    void callAllArgsConstructor_ReturnsTemplatePush() {
        TemplatePush templatePush = new TemplatePush(TITLE, BODY);

        assertNotNull(templatePush.getTitle());
        assertNotNull(templatePush.getBody());
    }

    @Test
    void callBuilder_ReturnsTemplatePush() {
        TemplatePush templatePush = TemplatePush.builder()
            .title(TITLE)
            .body(BODY)
            .build();

        assertNotNull(templatePush.getTitle());
        assertNotNull(templatePush.getBody());
    }

}
