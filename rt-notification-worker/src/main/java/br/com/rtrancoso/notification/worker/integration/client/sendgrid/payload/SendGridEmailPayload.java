package br.com.rtrancoso.notification.worker.integration.client.sendgrid.payload;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class SendGridEmailPayload {

    private String toEmail;
    private String toName;
    private String fromEmail;
    private String fromName;
    private String templateId;
    private String templateCategory;
    private Map<String, String> params;
    private SendGridEmailAttachmentPayload attachmentPayload;

}
