package br.com.rtrancoso.notification.commons.enums;


import br.com.rtrancoso.springboot.base.exception.model.Error;
import lombok.Getter;

@Getter
public enum ExceptionCode implements Error {

    TEMPLATE_001("TEMPLATE_001", "There is already a template with the same key."),
    TEMPLATE_002("TEMPLATE_002", "There is already a template with the same name."),
    TEMPLATE_003("TEMPLATE_003", "One or more Specification are required."),
    TEMPLATE_004("TEMPLATE_004", "There is already a template with the same SpecificationApp message."),
    TEMPLATE_005("TEMPLATE_005", "There is already a template with the same SpecificationEmail templateId."),
    TEMPLATE_006("TEMPLATE_006", "There is already a template with the same SpecificationPush body."),
    TEMPLATE_007("TEMPLATE_007", "There is already a template with the same SpecificationSms message."),
    TEMPLATE_008("TEMPLATE_008", "There is already a template with the same SpecificationWhatsApp message."),

    NOTIFICATION_001("NOTIFICATION_001", "Realm is required to notify."),
    NOTIFICATION_002("NOTIFICATION_002", "At least one channel is required to notify."),

    NOTIFICATION_APP_001("NOTIFICATION_APP_001", "Receiver is required to notify by channel app."),
    NOTIFICATION_APP_002("NOTIFICATION_APP_002", "Message is required to notify by channel app."),

    NOTIFICATION_EMAIL_001("NOTIFICATION_EMAIL_001", "Sender is required to notify by channel email."),
    NOTIFICATION_EMAIL_002("NOTIFICATION_EMAIL_002", "Receiver is required to notify by channel email."),
    NOTIFICATION_EMAIL_003("NOTIFICATION_EMAIL_003", "Template is required to notify by channel email."),

    INTEGRATION_SEND_GRID("INTEGRATION_SEND_GRID", "Error when trying some information from SendGrid");

    private final String code;
    private final String description;

    ExceptionCode(final String code, final String description) {
        this.code = code;
        this.description = description;
    }
}
