package br.com.rtrancoso.notification.core.unit.dto;

import br.com.rtrancoso.notification.commons.model.TemplateApp;
import br.com.rtrancoso.notification.commons.model.TemplateEmail;
import br.com.rtrancoso.notification.commons.model.TemplatePush;
import br.com.rtrancoso.notification.commons.model.TemplateSms;
import br.com.rtrancoso.notification.commons.model.TemplateWhatsApp;
import br.com.rtrancoso.notification.core.dto.TemplateOut;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TemplateOutTest {

    private static final String ID = "ID";
    private static final LocalDateTime CREATED_AT = LocalDateTime.now();
    private static final LocalDateTime UPDATED_AT = LocalDateTime.now();
    private static final String REALM = "REALM";
    private static final String KEY = "KEY";
    private static final String NAME = "NAME";

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void callNoArgsConstructor_ReturnsTemplateIn() {
        TemplateOut templateOut = new TemplateOut();
        templateOut.setId(ID);
        templateOut.setCreatedAt(CREATED_AT);
        templateOut.setUpdatedAt(UPDATED_AT);
        templateOut.setRealm(REALM);
        templateOut.setKey(KEY);
        templateOut.setName(NAME);
        templateOut.setTemplateApp(getValidAppExample());
        templateOut.setTemplateEmail(getValidEmailExample());
        templateOut.setTemplatePush(getValidPushExample());
        templateOut.setTemplateSms(getValidSmsExample());
        templateOut.setTemplateWhatsApp(getValidWhatsAppExample());

        assertNotNull(templateOut.getId());
        assertNotNull(templateOut.getCreatedAt());
        assertNotNull(templateOut.getUpdatedAt());
        assertNotNull(templateOut.getRealm());
        assertNotNull(templateOut.getKey());
        assertNotNull(templateOut.getName());
        assertNotNull(templateOut.getTemplateApp());
        assertNotNull(templateOut.getTemplateEmail());
        assertNotNull(templateOut.getTemplatePush());
        assertNotNull(templateOut.getTemplateSms());
        assertNotNull(templateOut.getTemplateWhatsApp());
    }

    @Test
    void callAllArgsConstructor_ReturnsTemplateIn() {
        TemplateOut templateOut = new TemplateOut(ID, CREATED_AT, UPDATED_AT, REALM, KEY, NAME, getValidAppExample(), getValidEmailExample(),
            getValidPushExample(), getValidSmsExample(), getValidWhatsAppExample());

        assertNotNull(templateOut.getId());
        assertNotNull(templateOut.getCreatedAt());
        assertNotNull(templateOut.getUpdatedAt());
        assertNotNull(templateOut.getRealm());
        assertNotNull(templateOut.getKey());
        assertNotNull(templateOut.getName());
        assertNotNull(templateOut.getTemplateApp());
        assertNotNull(templateOut.getTemplateEmail());
        assertNotNull(templateOut.getTemplatePush());
        assertNotNull(templateOut.getTemplateSms());
        assertNotNull(templateOut.getTemplateWhatsApp());
    }

    @Test
    void callBuilder_ReturnsTemplateIn() {
        TemplateOut templateOut = TemplateOut.builder()
            .id(ID)
            .createdAt(CREATED_AT)
            .updatedAt(UPDATED_AT)
            .realm(REALM)
            .key(KEY)
            .name(NAME)
            .templateApp(getValidAppExample())
            .templateEmail(getValidEmailExample())
            .templatePush(getValidPushExample())
            .templateSms(getValidSmsExample())
            .templateWhatsApp(getValidWhatsAppExample())
            .build();

        assertNotNull(templateOut.getId());
        assertNotNull(templateOut.getCreatedAt());
        assertNotNull(templateOut.getUpdatedAt());
        assertNotNull(templateOut.getRealm());
        assertNotNull(templateOut.getKey());
        assertNotNull(templateOut.getName());
        assertNotNull(templateOut.getTemplateApp());
        assertNotNull(templateOut.getTemplateEmail());
        assertNotNull(templateOut.getTemplatePush());
        assertNotNull(templateOut.getTemplateSms());
        assertNotNull(templateOut.getTemplateWhatsApp());
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
