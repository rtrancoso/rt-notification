package br.com.rtrancoso.notification.core.mapper;

import br.com.rtrancoso.notification.commons.model.Template;
import br.com.rtrancoso.notification.core.dto.TemplateIn;
import br.com.rtrancoso.notification.core.dto.TemplateOut;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TemplateMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void prepareUpdate(Template source, @MappingTarget Template target);

    Template templateInToTemplate(TemplateIn source);

    TemplateOut templateToTemplateOut(Template source);

    List<TemplateOut> templateToTemplateOut(List<Template> sources);

}
