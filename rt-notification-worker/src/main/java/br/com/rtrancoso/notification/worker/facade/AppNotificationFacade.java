package br.com.rtrancoso.notification.worker.facade;

import br.com.rtrancoso.notification.commons.model.Notification;
import br.com.rtrancoso.notification.commons.model.NotificationApp;
import br.com.rtrancoso.notification.commons.model.Template;
import br.com.rtrancoso.notification.worker.service.NotificationService;
import br.com.rtrancoso.notification.worker.service.TemplateService;
import br.com.rtrancoso.springboot.base.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppNotificationFacade {

    private final NotificationService notificationService;
    private final TemplateService templateService;

    public void notify(String notificationId) {
        notificationService.find(notificationId).ifPresent(
            notification -> templateService.findByRealmAndKey(notification.getRealm(), notification.getTemplateKey()).ifPresent(
                template -> process(notification, template)));
    }

    private void process(Notification notification, Template template) {
        try {
            mountNotificationApp(notification, template);
            notificationService.updateApp(notification);
        } catch (BusinessException ex) {
            log.error("error on process app notify", ex);
        }
    }

    private void mountNotificationApp(Notification notification, Template template) {
        notification.setNotificationApp(NotificationApp.builder().build());
        notification.getNotificationApp().setReceiver(notification.getParams().get("APP_RECEIVER"));
        notification.getNotificationApp().setMessage(templateService.parseAppMessage(template.getTemplateApp(), notification.getParams()));
    }

}
