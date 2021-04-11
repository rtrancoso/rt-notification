package br.com.rtrancoso.notification.core.controller;

import br.com.rtrancoso.notification.core.controller.api.NotifyApi;
import br.com.rtrancoso.notification.core.dto.NotifyIn;
import br.com.rtrancoso.notification.core.facade.NotifyFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("notifies")
@RequiredArgsConstructor
public class NotifyController implements NotifyApi {

    private final NotifyFacade notifyFacade;

    @Override
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody NotifyIn notifyIn) {
        notifyFacade.create(notifyIn);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
