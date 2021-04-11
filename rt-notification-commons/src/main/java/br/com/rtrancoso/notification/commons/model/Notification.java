package br.com.rtrancoso.notification.commons.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Notification {

    private String id;

    @CreatedDate
    private LocalDateTime createdAt;

    private String realm;

    private String templateKey;

    private List<Channel> channels;

    private Map<String, String> params;

    private NotificationApp notificationApp;

    private NotificationEmail notificationEmail;

    private NotificationPush notificationPush;

    private NotificationSms notificationSms;

    private NotificationWhatsApp notificationWhatsApp;

    public enum Channel {
        APP,
        EMAIL,
        PUSH,
        SMS,
        WHATSAPP
    }

}
