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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TemplateIn {

    private String realm;
    private String key;
    private String name;
    private TemplateApp templateApp;
    private TemplateEmail templateEmail;
    private TemplatePush templatePush;
    private TemplateSms templateSms;
    private TemplateWhatsApp templateWhatsApp;

}
