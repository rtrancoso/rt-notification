package br.com.rtrancoso.notification.worker.mapper;

import br.com.rtrancoso.notification.commons.broker.event.NotifyEventSource;
import br.com.rtrancoso.notification.commons.model.InvalidNotification;
import br.com.rtrancoso.notification.commons.model.Notification;
import br.com.rtrancoso.springboot.base.exception.model.Error;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    Notification notifyEventSourceToNotification(NotifyEventSource source);

    InvalidNotification notifyEventSourceToInvalidNotification(NotifyEventSource source, List<Error> errors);

}
