package br.com.rtrancoso.notification.worker.config;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendGridConfig {

    @Value("${rtrancoso.sendgrid.apiKey}")
    private String apiKey;

    @Bean
    public SendGrid sendGridBean() {
        return new SendGrid(apiKey);
    }

}
