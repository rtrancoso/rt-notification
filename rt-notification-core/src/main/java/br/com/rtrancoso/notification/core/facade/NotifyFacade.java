package br.com.rtrancoso.notification.core.facade;

import br.com.rtrancoso.notification.commons.broker.event.NotifyEventSource;
import br.com.rtrancoso.notification.core.dto.NotifyIn;
import br.com.rtrancoso.springboot.base.stream.event.producer.EventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotifyFacade {

    private final EventProducer eventProducer;

    public void create(NotifyIn notifyIn) {
        eventProducer.sendMessage(NotifyEventSource.builder()
            .templateKey(notifyIn.getTemplateKey())
            .channels(notifyIn.getChannels())
            .params(notifyIn.getParams())
            .build());
    }

}
