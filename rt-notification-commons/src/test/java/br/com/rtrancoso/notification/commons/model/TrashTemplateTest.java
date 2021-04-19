package br.com.rtrancoso.notification.commons.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TrashTemplateTest {

    private static final String ID = "ID";
    private static final LocalDateTime CREATED_AT = LocalDateTime.now();
    private static final Template TEMPLATE = new EasyRandom().nextObject(Template.class);

    @Test
    void callNoArgsConstructor_ReturnsTrashTemplate() {
        TrashTemplate trashTemplate = new TrashTemplate();
        trashTemplate.setId(ID);
        trashTemplate.setCreatedAt(CREATED_AT);
        trashTemplate.setTemplate(TEMPLATE);

        assertNotNull(trashTemplate.getId());
        assertNotNull(trashTemplate.getCreatedAt());
        assertNotNull(trashTemplate.getTemplate());
    }

    @Test
    void callAllArgsConstructor_ReturnsTrashTemplate() {
        TrashTemplate trashTemplate = new TrashTemplate(ID, CREATED_AT, TEMPLATE);

        assertNotNull(trashTemplate.getId());
        assertNotNull(trashTemplate.getCreatedAt());
        assertNotNull(trashTemplate.getTemplate());
    }

    @Test
    void callBuilder_ReturnsTrashTemplate() {
        TrashTemplate trashTemplate = TrashTemplate.builder()
            .id(ID)
            .createdAt(CREATED_AT)
            .template(TEMPLATE)
            .build();

        assertNotNull(trashTemplate.getId());
        assertNotNull(trashTemplate.getCreatedAt());
        assertNotNull(trashTemplate.getTemplate());
    }

}