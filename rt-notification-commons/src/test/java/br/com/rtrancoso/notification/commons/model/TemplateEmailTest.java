package br.com.rtrancoso.notification.commons.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TemplateEmailTest {

    private static final String TEMPLATE_ID = "TEMPLATE_ID";
    private static final String TEMPLATE_CATEGORY = "TEMPLATE_CATEGORY";
    private static final String SENDER = "SENDER";
    private static final String SENDER_NAME = "SENDER_NAME";

    @Test
    void callNoArgsConstructor_ReturnsTemplateEmail() {
        TemplateEmail templateEmail = new TemplateEmail();
        templateEmail.setTemplateId(TEMPLATE_ID);
        templateEmail.setTemplateCategory(TEMPLATE_CATEGORY);
        templateEmail.setSender(SENDER);
        templateEmail.setSenderName(SENDER_NAME);

        assertNotNull(templateEmail.getTemplateId());
        assertNotNull(templateEmail.getTemplateCategory());
        assertNotNull(templateEmail.getSender());
        assertNotNull(templateEmail.getSenderName());
    }

    @Test
    void callAllArgsConstructor_ReturnsTemplateEmail() {
        TemplateEmail templateEmail = new TemplateEmail(TEMPLATE_ID, TEMPLATE_CATEGORY, SENDER, SENDER_NAME);

        assertNotNull(templateEmail.getTemplateId());
        assertNotNull(templateEmail.getTemplateCategory());
        assertNotNull(templateEmail.getSender());
        assertNotNull(templateEmail.getSenderName());
    }

    @Test
    void callBuilder_ReturnsTemplateEmail() {
        TemplateEmail templateEmail = TemplateEmail.builder()
            .templateId(TEMPLATE_ID)
            .templateCategory(TEMPLATE_CATEGORY)
            .sender(SENDER)
            .senderName(SENDER_NAME)
            .build();

        assertNotNull(templateEmail.getTemplateId());
        assertNotNull(templateEmail.getTemplateCategory());
        assertNotNull(templateEmail.getSender());
        assertNotNull(templateEmail.getSenderName());
    }

}
