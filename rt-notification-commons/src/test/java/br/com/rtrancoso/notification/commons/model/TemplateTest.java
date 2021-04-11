package br.com.rtrancoso.notification.commons.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TemplateTest {

    private final EasyRandom easyRandom = new EasyRandom();

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
    void isInactive_StatusActive_ReturnsTrue() {
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

    private Template getValidExample() {
        return easyRandom.nextObject(Template.class);
    }

}
