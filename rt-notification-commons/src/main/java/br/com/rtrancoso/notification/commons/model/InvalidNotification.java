package br.com.rtrancoso.notification.commons.model;

import br.com.rtrancoso.springboot.base.exception.model.Error;
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
public class InvalidNotification {

    private String id;

    @CreatedDate
    private LocalDateTime createdAt;

    private String realmId;

    private String systemId;

    private List<Notification.Channel> channels;

    private Map<String, String> params;

    private List<Error> errors;

}
