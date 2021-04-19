package br.com.rtrancoso.notification.core.dto;

import br.com.rtrancoso.notification.commons.model.TemplateApp;
import br.com.rtrancoso.notification.commons.model.TemplateEmail;
import br.com.rtrancoso.notification.commons.model.TemplatePush;
import br.com.rtrancoso.notification.commons.model.TemplateSms;
import br.com.rtrancoso.notification.commons.model.TemplateWhatsApp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class TemplateIn {

    @NotBlank
    private String key;

    @NotBlank
    private String name;

    @Valid
    private TemplateApp templateApp;

    @Valid
    private TemplateEmail templateEmail;

    @Valid
    private TemplatePush templatePush;

    @Valid
    private TemplateSms templateSms;

    @Valid
    private TemplateWhatsApp templateWhatsApp;

}
