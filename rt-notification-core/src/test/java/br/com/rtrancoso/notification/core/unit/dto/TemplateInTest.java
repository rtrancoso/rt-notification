package br.com.rtrancoso.notification.core.unit.dto;

import br.com.rtrancoso.notification.commons.model.TemplateApp;
import br.com.rtrancoso.notification.commons.model.TemplateEmail;
import br.com.rtrancoso.notification.commons.model.TemplatePush;
import br.com.rtrancoso.notification.commons.model.TemplateSms;
import br.com.rtrancoso.notification.commons.model.TemplateWhatsApp;
import br.com.rtrancoso.notification.core.dto.TemplateIn;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TemplateInTest {

    private static final String KEY = "KEY";
    private static final String NAME = "NAME";

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void callNoArgsConstructor_ReturnsTemplateIn() {
        TemplateIn templateIn = new TemplateIn();
        templateIn.setKey(KEY);
        templateIn.setName(NAME);
        templateIn.setTemplateApp(getValidAppExample());
        templateIn.setTemplateEmail(getValidEmailExample());
        templateIn.setTemplatePush(getValidPushExample());
        templateIn.setTemplateSms(getValidSmsExample());
        templateIn.setTemplateWhatsApp(getValidWhatsAppExample());

        assertNotNull(templateIn.getKey());
        assertNotNull(templateIn.getName());
        assertNotNull(templateIn.getTemplateApp());
        assertNotNull(templateIn.getTemplateEmail());
        assertNotNull(templateIn.getTemplatePush());
        assertNotNull(templateIn.getTemplateSms());
        assertNotNull(templateIn.getTemplateWhatsApp());
    }

    @Test
    void callAllArgsConstructor_ReturnsTemplateIn() {
        TemplateIn templateIn = new TemplateIn(KEY, NAME, getValidAppExample(), getValidEmailExample(),
            getValidPushExample(), getValidSmsExample(), getValidWhatsAppExample());

        assertNotNull(templateIn.getKey());
        assertNotNull(templateIn.getName());
        assertNotNull(templateIn.getTemplateApp());
        assertNotNull(templateIn.getTemplateEmail());
        assertNotNull(templateIn.getTemplatePush());
        assertNotNull(templateIn.getTemplateSms());
        assertNotNull(templateIn.getTemplateWhatsApp());
    }

    @Test
    void callBuilder_ReturnsTemplateIn() {
        TemplateIn templateIn = TemplateIn.builder()
            .key(KEY)
            .name(NAME)
            .templateApp(getValidAppExample())
            .templateEmail(getValidEmailExample())
            .templatePush(getValidPushExample())
            .templateSms(getValidSmsExample())
            .templateWhatsApp(getValidWhatsAppExample())
            .build();

        assertNotNull(templateIn.getKey());
        assertNotNull(templateIn.getName());
        assertNotNull(templateIn.getTemplateApp());
        assertNotNull(templateIn.getTemplateEmail());
        assertNotNull(templateIn.getTemplatePush());
        assertNotNull(templateIn.getTemplateSms());
        assertNotNull(templateIn.getTemplateWhatsApp());
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
