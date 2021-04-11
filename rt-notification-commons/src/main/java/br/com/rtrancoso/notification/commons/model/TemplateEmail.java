package br.com.rtrancoso.notification.commons.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TemplateEmail {

    @NotBlank
    private String templateId;

    @NotBlank
    private String templateCategory;

    @NotBlank
    private String sender;

    @NotBlank
    private String senderName;

}
