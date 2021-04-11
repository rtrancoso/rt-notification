package br.com.rtrancoso.notification.worker.facade;

import br.com.rtrancoso.notification.commons.broker.event.NotifyEventSource;
import br.com.rtrancoso.notification.commons.model.Notification;
import br.com.rtrancoso.notification.worker.channel.ChannelNotifierSupplier;
import br.com.rtrancoso.notification.worker.mapper.NotificationMapper;
import br.com.rtrancoso.notification.worker.service.NotificationService;
import br.com.rtrancoso.springboot.base.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationFacade {

    private final NotificationService notificationService;
    private final NotificationMapper notificationMapper;
    private final ChannelNotifierSupplier channelNotifierSupplier;

    public void processEvent(NotifyEventSource notifyEventSource) {
        try {
            Notification notification = notificationService.create(notificationMapper.notifyEventSourceToNotification(notifyEventSource));
            notification.getChannels().forEach(channel -> channelNotifierSupplier.supplyChannelNotifier(channel).dispatchEvent(notification.getId()));
        } catch (BusinessException ex) {
            notificationService.create(notificationMapper.notifyEventSourceToInvalidNotification(notifyEventSource, ex.getErrors()));
        }
    }

}
