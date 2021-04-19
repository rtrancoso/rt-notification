package br.com.rtrancoso.notification.core.controller;

import br.com.rtrancoso.notification.core.controller.api.TemplateApi;
import br.com.rtrancoso.notification.core.dto.TemplateIn;
import br.com.rtrancoso.notification.core.dto.TemplateOut;
import br.com.rtrancoso.notification.core.facade.TemplateFacade;
import br.com.rtrancoso.springboot.base.exception.BusinessException;
import br.com.rtrancoso.springboot.base.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("templates")
@RequiredArgsConstructor
public class TemplateController implements TemplateApi {

    private final TemplateFacade templateFacade;

    @Override
    @GetMapping
    public ResponseEntity<List<TemplateOut>> findAll() {
        return ResponseEntity.ok().body(templateFacade.findAll());
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<TemplateOut> find(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(templateFacade.find(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<TemplateOut> create(@Valid @RequestBody TemplateIn templateIn) throws BusinessException {
        return ResponseEntity.status(HttpStatus.CREATED).body(templateFacade.create(templateIn));
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<TemplateOut> update(@PathVariable String id,
        @Valid @RequestBody TemplateIn templateIn) throws ResourceNotFoundException, BusinessException {
        return ResponseEntity.ok().body(templateFacade.update(id, templateIn));
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable String id) throws ResourceNotFoundException {
        templateFacade.delete(id);
        return ResponseEntity.noContent().build();
    }

}
