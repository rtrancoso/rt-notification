package br.com.rtrancoso.notification.worker.service;

import br.com.rtrancoso.notification.commons.enums.ExceptionCode;
import br.com.rtrancoso.notification.commons.model.InvalidNotification;
import br.com.rtrancoso.notification.commons.model.Notification;
import br.com.rtrancoso.notification.commons.model.NotificationApp;
import br.com.rtrancoso.notification.commons.model.NotificationEmail;
import br.com.rtrancoso.notification.commons.repository.InvalidNotificationRepository;
import br.com.rtrancoso.notification.commons.repository.NotificationRepository;
import br.com.rtrancoso.springboot.base.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final InvalidNotificationRepository invalidNotificationRepository;

    public Optional<Notification> find(String id) {
        return notificationRepository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Notification create(Notification notification) throws BusinessException {
        validate(notification);
        return notificationRepository.save(notification);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateApp(Notification notification) throws BusinessException {
        validateApp(notification.getNotificationApp());
        notificationRepository.save(notification);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Notification updateAppSentAt(Notification notification) {
        notification.getNotificationApp().setSentAt(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateEmail(Notification notification) throws BusinessException {
        validateEmail(notification.getNotificationEmail());
        notificationRepository.save(notification);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateEmailSentAt(Notification notification) {
        notification.getNotificationEmail().setSentAt(LocalDateTime.now());
        notificationRepository.save(notification);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void create(InvalidNotification invalidNotification) {
        invalidNotificationRepository.save(invalidNotification);
    }

    private void validate(Notification notification) throws BusinessException {
        List<ExceptionCode> errors = new ArrayList<>();

        validateRealm(notification, errors);
        validateChannels(notification, errors);

        if (!errors.isEmpty()) {
            throw new BusinessException(errors);
        }
    }

    private void validateRealm(Notification notification, List<ExceptionCode> errors) {
        if (!StringUtils.hasText(notification.getRealm())) {
            errors.add(ExceptionCode.NOTIFICATION_001);
        }
    }

    private void validateChannels(Notification notification, List<ExceptionCode> errors) {
        if (Objects.isNull(notification.getChannels()) || notification.getChannels().isEmpty()) {
            errors.add(ExceptionCode.NOTIFICATION_002);
        }
    }

    private void validateApp(NotificationApp notificationApp) throws BusinessException {
        List<ExceptionCode> errors = new ArrayList<>();

        validateAppReceiver(notificationApp, errors);
        validateAppMessage(notificationApp, errors);

        if (!errors.isEmpty()) {
            throw new BusinessException(errors);
        }
    }

    private void validateAppReceiver(NotificationApp notificationApp, List<ExceptionCode> errors) {
        if (!StringUtils.hasText(notificationApp.getReceiver())) {
            errors.add(ExceptionCode.NOTIFICATION_APP_001);
        }
    }

    private void validateAppMessage(NotificationApp notificationApp, List<ExceptionCode> errors) {
        if (!StringUtils.hasText(notificationApp.getMessage())) {
            errors.add(ExceptionCode.NOTIFICATION_APP_002);
        }
    }

    private void validateEmail(NotificationEmail notificationEmail) throws BusinessException {
        List<ExceptionCode> errors = new ArrayList<>();

        validateEmailSender(notificationEmail, errors);
        validateEmailReceiver(notificationEmail, errors);
        validateEmailTemplate(notificationEmail, errors);

        if (!errors.isEmpty()) {
            throw new BusinessException(errors);
        }
    }

    private void validateEmailSender(NotificationEmail notificationEmail, List<ExceptionCode> errors) {
        if (!StringUtils.hasText(notificationEmail.getSender()) || !StringUtils.hasText(notificationEmail.getSenderName())) {
            errors.add(ExceptionCode.NOTIFICATION_EMAIL_001);
        }
    }

    private void validateEmailReceiver(NotificationEmail notificationEmail, List<ExceptionCode> errors) {
        if (!StringUtils.hasText(notificationEmail.getReceiver()) || !StringUtils.hasText(notificationEmail.getReceiverName())) {
            errors.add(ExceptionCode.NOTIFICATION_EMAIL_002);
        }
    }

    private void validateEmailTemplate(NotificationEmail notificationEmail, List<ExceptionCode> errors) {
        if (!StringUtils.hasText(notificationEmail.getTemplateId()) || !StringUtils.hasText(notificationEmail.getTemplateCategory())) {
            errors.add(ExceptionCode.NOTIFICATION_EMAIL_003);
        }
    }

}
