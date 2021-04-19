package br.com.rtrancoso.notification.commons.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TemplateTest {

    private static final String ID = "ID";
    private static final LocalDateTime CREATED_AT = LocalDateTime.now();
    private static final LocalDateTime UPDATED_AT = LocalDateTime.now();
    private static final String KEY = "KEY";
    private static final String NAME = "NAME";

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void callNoArgsConstructor_ReturnsTemplate() {
        Template template = new Template();
        template.setId(ID);
        template.setCreatedAt(CREATED_AT);
        template.setUpdatedAt(UPDATED_AT);
        template.setKey(KEY);
        template.setName(NAME);
        template.setTemplateApp(getValidAppExample());
        template.setTemplateEmail(getValidEmailExample());
        template.setTemplatePush(getValidPushExample());
        template.setTemplateSms(getValidSmsExample());
        template.setTemplateWhatsApp(getValidWhatsAppExample());
        template.setStatus(Template.Status.ACTIVE);

        assertNotNull(template.getId());
        assertNotNull(template.getCreatedAt());
        assertNotNull(template.getUpdatedAt());
        assertNotNull(template.getKey());
        assertNotNull(template.getName());
        assertNotNull(template.getTemplateApp());
        assertNotNull(template.getTemplateEmail());
        assertNotNull(template.getTemplatePush());
        assertNotNull(template.getTemplateSms());
        assertNotNull(template.getTemplateWhatsApp());
        assertNotNull(template.getStatus());
    }

    @Test
    void callAllArgsConstructor_ReturnsTemplate() {
        Template template = new Template(ID, CREATED_AT, UPDATED_AT, KEY, NAME, getValidAppExample(), getValidEmailExample(),
            getValidPushExample(), getValidSmsExample(), getValidWhatsAppExample(), Template.Status.ACTIVE);

        assertNotNull(template.getId());
        assertNotNull(template.getCreatedAt());
        assertNotNull(template.getUpdatedAt());
        assertNotNull(template.getKey());
        assertNotNull(template.getName());
        assertNotNull(template.getTemplateApp());
        assertNotNull(template.getTemplateEmail());
        assertNotNull(template.getTemplatePush());
        assertNotNull(template.getTemplateSms());
        assertNotNull(template.getTemplateWhatsApp());
        assertNotNull(template.getStatus());
    }

    @Test
    void callBuilder_ReturnsTemplate() {
        Template template = Template.builder()
            .id(ID)
            .createdAt(CREATED_AT)
            .updatedAt(UPDATED_AT)
            .key(KEY)
            .name(NAME)
            .templateApp(getValidAppExample())
            .templateEmail(getValidEmailExample())
            .templatePush(getValidPushExample())
            .templateSms(getValidSmsExample())
            .templateWhatsApp(getValidWhatsAppExample())
            .status(Template.Status.ACTIVE)
            .build();

        assertNotNull(template.getId());
        assertNotNull(template.getCreatedAt());
        assertNotNull(template.getUpdatedAt());
        assertNotNull(template.getKey());
        assertNotNull(template.getName());
        assertNotNull(template.getTemplateApp());
        assertNotNull(template.getTemplateEmail());
        assertNotNull(template.getTemplatePush());
        assertNotNull(template.getTemplateSms());
        assertNotNull(template.getTemplateWhatsApp());
        assertNotNull(template.getStatus());
    }

    @Test
    void isActive_StatusActive_ReturnsTrue() {
        Template template = getValidExample();
        template.setStatus(Template.Status.ACTIVE);

        assertTrue(template.isActive());
    }

    @Test
    void isActive_StatusInactive_ReturnsTrue() {
        Template template = getValidExample();
        template.setStatus(Template.Status.INACTIVE);

        assertFalse(template.isActive());
    }

    @Test
    void isInactive_StatusActive_ReturnsFalse() {
        Template template = getValidExample();
        template.setStatus(Template.Status.ACTIVE);

        assertFalse(template.isInactive());
    }

    @Test
    void isInactive_StatusInactive_ReturnsTrue() {
        Template template = getValidExample();
        template.setStatus(Template.Status.INACTIVE);

        assertTrue(template.isInactive());
    }

    @Test
    void hasSpecification_WithoutAnySpecification_ReturnsFalse() {
        Template template = getValidExample();
        template.setTemplateApp(null);
        template.setTemplateEmail(null);
        template.setTemplatePush(null);
        template.setTemplateSms(null);
        template.setTemplateWhatsApp(null);

        assertFalse(template.hasSpecification());
    }

    private Template getValidExample() {
        return easyRandom.nextObject(Template.class);
    }

    private TemplateApp getValidAppExample() {
        return easyRandom.nextObject(TemplateApp.class);
    }

    private TemplateEmail getValidEmailExample() {
        return easyRandom.nextObject(TemplateEmail.class);
    }

    private TemplatePush getValidPushExample() {
        return easyRandom.nextObject(TemplatePush.class);
    }

    private TemplateSms getValidSmsExample() {
        return easyRandom.nextObject(TemplateSms.class);
    }

    private TemplateWhatsApp getValidWhatsAppExample() {
        return easyRandom.nextObject(TemplateWhatsApp.class);
    }

}
