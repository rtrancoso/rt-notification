package br.com.rtrancoso.notification.commons.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationPush {

    @NotNull
    private LocalDateTime sentAt;

    @NotBlank
    private String receiver;

    @NotBlank
    private String title;

    @NotBlank
    private String body;

}
