package br.com.rtrancoso.notification.commons.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Template {

    private String id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private String key;

    private String name;

    private TemplateApp templateApp;

    private TemplateEmail templateEmail;

    private TemplatePush templatePush;

    private TemplateSms templateSms;

    private TemplateWhatsApp templateWhatsApp;

    private Status status;

    public boolean isActive() {
        return status == Status.ACTIVE;
    }

    public boolean isInactive() {
        return status == Status.INACTIVE;
    }

    public boolean hasSpecification() {
        List<Object> templates = new ArrayList<>();
        templates.add(templateApp);
        templates.add(templateEmail);
        templates.add(templatePush);
        templates.add(templateSms);
        templates.add(templateWhatsApp);
        return templates.stream().anyMatch(Objects::nonNull);
    }

    public enum Status {
        ACTIVE,
        INACTIVE
    }

}
