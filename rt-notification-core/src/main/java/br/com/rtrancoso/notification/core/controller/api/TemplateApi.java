package br.com.rtrancoso.notification.core.controller.api;

import br.com.rtrancoso.notification.core.dto.TemplateIn;
import br.com.rtrancoso.notification.core.dto.TemplateOut;
import br.com.rtrancoso.springboot.base.controller.model.ErrorResponse;
import br.com.rtrancoso.springboot.base.exception.BusinessException;
import br.com.rtrancoso.springboot.base.exception.ResourceNotFoundException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TemplateApi {

    @ApiOperation("List of templates")
    @ApiResponse(code = 200, message = "Success on get list of Templates", response = TemplateOut.class)
    ResponseEntity<List<TemplateOut>> findAll();

    @ApiOperation("Show a template")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success on get a template", response = TemplateOut.class),
        @ApiResponse(code = 404, message = "Resource not found")
    })
    ResponseEntity<TemplateOut> find(String id) throws ResourceNotFoundException;

    @ApiOperation("Create a template")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success on create a template", response = TemplateOut.class),
        @ApiResponse(code = 400, message = "Invalid request", response = ErrorResponse.class),
        @ApiResponse(code = 404, message = "Resource not found")
    })
    ResponseEntity<TemplateOut> create(TemplateIn templateIn) throws BusinessException;

    @ApiOperation("Update a template")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success on update a template", response = TemplateOut.class),
        @ApiResponse(code = 400, message = "Invalid request", response = ErrorResponse.class),
        @ApiResponse(code = 404, message = "Resource not found")
    })
    ResponseEntity<TemplateOut> update(String id, TemplateIn templateIn) throws ResourceNotFoundException, BusinessException;

    @ApiOperation("Remove a template")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success on get a template", response = TemplateOut.class),
        @ApiResponse(code = 404, message = "Resource not found")
    })
    ResponseEntity<?> delete(String id) throws ResourceNotFoundException;
    
}
