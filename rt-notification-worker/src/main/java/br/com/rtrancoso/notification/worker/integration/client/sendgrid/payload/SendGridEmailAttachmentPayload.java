package br.com.rtrancoso.notification.worker.integration.client.sendgrid.payload;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SendGridEmailAttachmentPayload {

    private final String fileName;
    private final byte[] fileAttachment;

}
