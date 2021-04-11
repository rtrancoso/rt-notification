package br.com.rtrancoso.notification.commons.enums;

import br.com.rtrancoso.springboot.base.stream.event.EventType;
import lombok.Getter;

@Getter
public enum NotificationEventType implements EventType {

    NOTIFY("notify-output"),
    APP_NOTIFY("app-notify-output"),
    EMAIL_NOTIFY("email-notify-output"),
    PUSH_NOTIFY("push-notify-output"),
    SMS_NOTIFY("sms-notify-output"),
    WHATSAPP_NOTIFY("whatsapp-notify-output");

    private final String channel;

    NotificationEventType(final String channel) {
        this.channel = channel;
    }
}
