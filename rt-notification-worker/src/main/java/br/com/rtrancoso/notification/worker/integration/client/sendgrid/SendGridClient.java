package br.com.rtrancoso.notification.worker.integration.client.sendgrid;

import br.com.rtrancoso.notification.commons.enums.ExceptionCode;
import br.com.rtrancoso.notification.worker.integration.client.sendgrid.payload.SendGridEmailPayload;
import br.com.rtrancoso.springboot.base.exception.IntegrationException;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class SendGridClient {

    private final SendGrid sendGrid;

    public void sendMail(SendGridEmailPayload sendGridEmailPayload) {
        Mail mail = createMail(sendGridEmailPayload, createPersonalization(sendGridEmailPayload));
        createAttachments(mail, sendGridEmailPayload);
        sendMail(mail);
    }

    private void sendMail(Mail mail) {
        try {
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            log.info("sendgrid api response status {} headers {} body {}", response.getStatusCode(), response.getHeaders(), response.getBody());
        } catch (IOException ex) {
            throw new IntegrationException(ExceptionCode.INTEGRATION_SEND_GRID, HttpStatus.BAD_REQUEST.value(), "mail/send");
        }
    }

    private Mail createMail(SendGridEmailPayload sendGridEmailPayload, Personalization personalization) {
        Mail mail = new Mail();
        mail.setFrom(new Email(sendGridEmailPayload.getFromEmail(), sendGridEmailPayload.getFromName()));
        mail.setTemplateId(sendGridEmailPayload.getTemplateId());
        mail.addCategory(sendGridEmailPayload.getTemplateCategory());
        mail.addPersonalization(personalization);
        return mail;
    }

    private Personalization createPersonalization(SendGridEmailPayload sendGridEmailPayload) {
        Email to = new Email(sendGridEmailPayload.getToEmail(), sendGridEmailPayload.getToName());
        Personalization personalization = new Personalization();
        personalization.addTo(to);

        sendGridEmailPayload.getParams().forEach((k, v) -> personalization.addDynamicTemplateData("{{{" + k + "}}}", v));

        return personalization;
    }

    private void createAttachments(Mail mail, SendGridEmailPayload sendGridEmailPayload) {
        if (Objects.nonNull(sendGridEmailPayload.getAttachmentPayload())) {
            String fileName = sendGridEmailPayload.getAttachmentPayload().getFileName() + "_" + DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(
                LocalDateTime.now());
            Attachments attachments = new Attachments.Builder(fileName,
                new ByteArrayInputStream(sendGridEmailPayload.getAttachmentPayload().getFileAttachment())).build();
            mail.addAttachments(attachments);
        }
    }

}
