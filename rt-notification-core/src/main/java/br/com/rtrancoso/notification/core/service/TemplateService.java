package br.com.rtrancoso.notification.core.service;

import br.com.rtrancoso.notification.commons.enums.ExceptionCode;
import br.com.rtrancoso.notification.commons.model.Template;
import br.com.rtrancoso.notification.commons.model.TrashTemplate;
import br.com.rtrancoso.notification.commons.repository.TemplateRepository;
import br.com.rtrancoso.notification.commons.repository.TrashTemplateRepository;
import br.com.rtrancoso.notification.core.mapper.TemplateMapper;
import br.com.rtrancoso.springboot.base.exception.BusinessException;
import br.com.rtrancoso.springboot.base.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TemplateService {

    private final TemplateRepository templateRepository;
    private final TrashTemplateRepository trashTemplateRepository;

    private final TemplateMapper templateMapper;

    public List<Template> findAll() {
        return templateRepository.findAll();
    }

    public Template find(String id) throws ResourceNotFoundException {
        return templateRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Template create(Template template) throws BusinessException {
        template.setStatus(Template.Status.ACTIVE);
        validate(template);
        return templateRepository.save(template);
    }

    public Template update(String id, Template template) throws ResourceNotFoundException, BusinessException {
        Template templateOnDatabase = find(id);

        templateMapper.prepareUpdate(template, templateOnDatabase);

        validate(templateOnDatabase);
        return templateRepository.save(templateOnDatabase);
    }

    public void delete(String id) throws ResourceNotFoundException {
        Template templateOnDatabase = find(id);
        templateRepository.deleteById(templateOnDatabase.getId());
        trashTemplateRepository.save(TrashTemplate.builder().template(templateOnDatabase).build());
    }

    private void validate(Template template) throws BusinessException {
        List<ExceptionCode> errors = new ArrayList<>();

        validateSameKey(template, errors);
        validateSameName(template, errors);
        validateTemplateSpecification(template, errors);
        validateTemplateApp(template, errors);
        validateTemplateEmail(template, errors);
        validateTemplatePush(template, errors);
        validateTemplateSms(template, errors);
        validateTemplateWhatsApp(template, errors);

        if (!errors.isEmpty()) {
            throw new BusinessException(errors);
        }
    }

    private void validateSameKey(Template template, List<ExceptionCode> errors) {
        Template templateWithSameKey;
        if (Objects.isNull(template.getId())) {
            templateWithSameKey = templateRepository.findByKey(template.getKey()).orElse(null);
        } else {
            templateWithSameKey = templateRepository.findByKeyAndIdNot(template.getKey(), template.getId()).orElse(null);
        }

        if (!Objects.isNull(templateWithSameKey)) {
            errors.add(ExceptionCode.TEMPLATE_001);
        }
    }

    private void validateSameName(Template template, List<ExceptionCode> errors) {
        Template templateWithSameName;
        if (Objects.isNull(template.getId())) {
            templateWithSameName = templateRepository.findByName(template.getName()).orElse(null);
        } else {
            templateWithSameName = templateRepository.findByNameAndIdNot(template.getName(), template.getId()).orElse(null);
        }

        if (!Objects.isNull(templateWithSameName)) {
            errors.add(ExceptionCode.TEMPLATE_002);
        }
    }

    private void validateTemplateSpecification(Template template, List<ExceptionCode> errors) {
        if (!template.hasSpecification()) {
            errors.add(ExceptionCode.TEMPLATE_003);
        }
    }

    private void validateTemplateApp(Template template, List<ExceptionCode> errors) {
        if (Objects.nonNull(template.getTemplateApp())) {
            Template templateWithSameAppMessage;
            if (Objects.isNull(template.getId())) {
                templateWithSameAppMessage = templateRepository.findByTemplateAppMessage(template.getTemplateApp().getMessage()).orElse(null);
            } else {
                templateWithSameAppMessage = templateRepository.findByTemplateAppMessageAndIdNot(template.getTemplateApp().getMessage(),
                    template.getId()).orElse(null);
            }

            if (!Objects.isNull(templateWithSameAppMessage)) {
                errors.add(ExceptionCode.TEMPLATE_004);
            }
        }
    }

    private void validateTemplateEmail(Template template, List<ExceptionCode> errors) {
        if (Objects.nonNull(template.getTemplateEmail())) {
            Template templateWithSameEmailTemplateId;
            if (Objects.isNull(template.getId())) {
                templateWithSameEmailTemplateId = templateRepository.findByTemplateEmailTemplateId(
                    template.getTemplateEmail().getTemplateId()).orElse(null);
            } else {
                templateWithSameEmailTemplateId = templateRepository.findByTemplateEmailTemplateIdAndIdNot(
                    template.getTemplateEmail().getTemplateId(), template.getId()).orElse(null);
            }

            if (!Objects.isNull(templateWithSameEmailTemplateId)) {
                errors.add(ExceptionCode.TEMPLATE_005);
            }
        }
    }

    private void validateTemplatePush(Template template, List<ExceptionCode> errors) {
        if (Objects.nonNull(template.getTemplatePush())) {
            Template templateWithSamePushBody;
            if (Objects.isNull(template.getId())) {
                templateWithSamePushBody = templateRepository.findByTemplatePushBody(template.getTemplatePush().getBody()).orElse(null);
            } else {
                templateWithSamePushBody = templateRepository.findByTemplatePushBodyAndIdNot(template.getTemplatePush().getBody(),
                    template.getId()).orElse(null);
            }

            if (!Objects.isNull(templateWithSamePushBody)) {
                errors.add(ExceptionCode.TEMPLATE_006);
            }
        }
    }

    private void validateTemplateSms(Template template, List<ExceptionCode> errors) {
        if (Objects.nonNull(template.getTemplateSms())) {
            Template templateWithSameSmsMessage;
            if (Objects.isNull(template.getId())) {
                templateWithSameSmsMessage = templateRepository.findByTemplateSmsMessage(template.getTemplateSms().getMessage()).orElse(null);
            } else {
                templateWithSameSmsMessage = templateRepository.findByTemplateSmsMessageAndIdNot(template.getTemplateSms().getMessage(),
                    template.getId()).orElse(null);
            }

            if (!Objects.isNull(templateWithSameSmsMessage)) {
                errors.add(ExceptionCode.TEMPLATE_007);
            }
        }
    }

    private void validateTemplateWhatsApp(Template template, List<ExceptionCode> errors) {
        if (Objects.nonNull(template.getTemplateWhatsApp())) {
            Template templateWithSameWhatsAppMessage;
            if (Objects.isNull(template.getId())) {
                templateWithSameWhatsAppMessage = templateRepository.findByTemplateWhatsAppMessage(
                    template.getTemplateWhatsApp().getMessage()).orElse(null);
            } else {
                templateWithSameWhatsAppMessage = templateRepository.findByTemplateWhatsAppMessageAndIdNot(
                    template.getTemplateWhatsApp().getMessage(), template.getId()).orElse(null);
            }

            if (!Objects.isNull(templateWithSameWhatsAppMessage)) {
                errors.add(ExceptionCode.TEMPLATE_008);
            }
        }
    }

}
