package br.com.rtrancoso.notification.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableAutoConfiguration
public class RTNotificationWorkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RTNotificationWorkerApplication.class, args);
    }

}
