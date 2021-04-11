package br.com.rtrancoso.notification.worker.service;

import br.com.rtrancoso.notification.commons.model.Template;
import br.com.rtrancoso.notification.commons.model.TemplateApp;
import br.com.rtrancoso.notification.commons.model.TemplatePush;
import br.com.rtrancoso.notification.commons.model.TemplateSms;
import br.com.rtrancoso.notification.commons.model.TemplateWhatsApp;
import br.com.rtrancoso.notification.commons.repository.TemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@Validated
@RequiredArgsConstructor
public class TemplateService {

    private final TemplateRepository templateRepository;

    public Optional<Template> findByRealmAndKey(String realm, String key) {
        return templateRepository.findByRealmAndKey(realm, key);
    }

    public String parseAppMessage(TemplateApp templateApp, Map<String, String> params) {
        return replaceParams(templateApp.getMessage(), params);
    }

    public String parsePushTitle(TemplatePush templatePush, Map<String, String> params) {
        return replaceParams(templatePush.getTitle(), params);
    }

    public String parsePushBody(TemplatePush templatePush, Map<String, String> params) {
        return replaceParams(templatePush.getBody(), params);
    }

    public String parseSms(TemplateSms templateSms, Map<String, String> params) {
        return replaceParams(templateSms.getMessage(), params);
    }

    public String parseWhatsApp(TemplateWhatsApp templateWhatsApp, Map<String, String> params) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    private String replaceParams(String text, Map<String, String> params) {
        if (Objects.nonNull(params)) {
            for (Map.Entry<String, String> e : params.entrySet()) {
                text = text.replace("[" + e.getKey() + "]", e.getValue());
            }
        }
        return text;
    }

}
