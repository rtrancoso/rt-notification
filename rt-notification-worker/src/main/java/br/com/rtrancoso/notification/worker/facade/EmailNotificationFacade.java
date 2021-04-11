package br.com.rtrancoso.notification.worker.facade;

import br.com.rtrancoso.notification.commons.model.Notification;
import br.com.rtrancoso.notification.commons.model.NotificationEmail;
import br.com.rtrancoso.notification.commons.model.Template;
import br.com.rtrancoso.notification.worker.integration.EmailAdapter;
import br.com.rtrancoso.notification.worker.service.NotificationService;
import br.com.rtrancoso.notification.worker.service.TemplateService;
import br.com.rtrancoso.springboot.base.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailNotificationFacade {

    private final EmailAdapter emailAdapter;
    private final NotificationService notificationService;
    private final TemplateService templateService;

    public void notify(String notificationId) {
        notificationService.find(notificationId).ifPresent(
            notification -> templateService.findByRealmAndKey(notification.getRealm(), notification.getTemplateKey()).ifPresent(template -> process(notification, template)));
    }

    private void process(Notification notification, Template template) {
        try {
            mountNotificationEmail(notification, template);
            notificationService.updateEmail(notification);
            sendNotificationEmail(notification);
            notificationService.updateEmailSentAt(notification);
        } catch (BusinessException ex) {
            log.error("error on process app notify", ex);
        }
    }

    private void mountNotificationEmail(Notification notification, Template template) {
        notification.setNotificationEmail(NotificationEmail.builder().build());
        notification.getNotificationEmail().setSender(template.getTemplateEmail().getSender());
        notification.getNotificationEmail().setSenderName(template.getTemplateEmail().getSenderName());
        notification.getNotificationEmail().setReceiver(notification.getParams().get("EMAIL_RECEIVER"));
        notification.getNotificationEmail().setReceiverName(notification.getParams().get("EMAIL_RECEIVER_NAME"));
        notification.getNotificationEmail().setTemplateId(template.getTemplateEmail().getTemplateId());
        notification.getNotificationEmail().setTemplateCategory(template.getTemplateEmail().getTemplateCategory());
    }

    private void sendNotificationEmail(Notification notification) {
        emailAdapter.send(notification.getNotificationEmail().getReceiver(),
            notification.getNotificationEmail().getReceiverName(),
            notification.getNotificationEmail().getSender(),
            notification.getNotificationEmail().getSenderName(),
            notification.getNotificationEmail().getTemplateId(),
            notification.getNotificationEmail().getTemplateCategory(),
            notification.getParams());
    }

}
