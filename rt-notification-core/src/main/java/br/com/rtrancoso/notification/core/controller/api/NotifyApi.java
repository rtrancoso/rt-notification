package br.com.rtrancoso.notification.core.controller.api;

import br.com.rtrancoso.notification.core.dto.NotifyIn;
import br.com.rtrancoso.springboot.base.controller.model.ErrorResponse;
import br.com.rtrancoso.springboot.base.exception.BusinessException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface NotifyApi {

    @ApiOperation("Request to send a notify")
    @ApiResponses({
        @ApiResponse(code = 202, message = "Success on request to send a notify"),
        @ApiResponse(code = 400, message = "Invalid request", response = ErrorResponse.class)
    })
    ResponseEntity<?> create(NotifyIn notifyIn) throws BusinessException;

}
