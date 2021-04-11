package br.com.rtrancoso.notification.worker.integration;

import br.com.rtrancoso.notification.worker.integration.client.sendgrid.SendGridClient;
import br.com.rtrancoso.notification.worker.integration.client.sendgrid.payload.SendGridEmailPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailAdapter {

    private final SendGridClient sendGridClient;

    public void send(String toEmail, String toName, String fromEmail, String fromName, String templateId, String templateCategory,
        Map<String, String> params) {
        sendGridClient.sendMail(SendGridEmailPayload.builder()
            .toEmail(toEmail)
            .toName(toName)
            .fromEmail(fromEmail)
            .fromName(fromName)
            .templateId(templateId)
            .templateCategory(templateCategory)
            .params(params)
            .build());
    }

}
