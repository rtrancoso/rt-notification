package br.com.rtrancoso.notification.core.facade;


import br.com.rtrancoso.notification.core.dto.TemplateIn;
import br.com.rtrancoso.notification.core.dto.TemplateOut;
import br.com.rtrancoso.notification.core.mapper.TemplateMapper;
import br.com.rtrancoso.notification.core.service.TemplateService;
import br.com.rtrancoso.springboot.base.exception.BusinessException;
import br.com.rtrancoso.springboot.base.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TemplateFacade {

    private final TemplateService templateService;
    private final TemplateMapper templateMapper;

    public List<TemplateOut> findAll() {
        return templateMapper.templateToTemplateOut(templateService.findAll());
    }

    public TemplateOut find(String id) throws ResourceNotFoundException {
        return templateMapper.templateToTemplateOut(templateService.find(id));
    }

    public TemplateOut create(TemplateIn templateIn) throws BusinessException {
        return templateMapper.templateToTemplateOut(templateService.create(templateMapper.templateInToTemplate(templateIn)));
    }

    public TemplateOut update(String id, TemplateIn templateIn) throws ResourceNotFoundException, BusinessException {
        return templateMapper.templateToTemplateOut(templateService.update(id, templateMapper.templateInToTemplate(templateIn)));
    }

    public void delete(String id) throws ResourceNotFoundException {
        templateService.delete(id);
    }

}
