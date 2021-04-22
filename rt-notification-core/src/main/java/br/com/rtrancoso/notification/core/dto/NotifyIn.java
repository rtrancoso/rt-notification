package br.com.rtrancoso.notification.core.dto;

import br.com.rtrancoso.notification.commons.model.Notification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotifyIn {

    @NotBlank
    private String templateKey;

    @NotEmpty
    private List<Notification.Channel> channels;

    private Map<String, String> params;

}
