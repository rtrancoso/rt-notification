package br.com.rtrancoso.notification.worker.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsNotificationFacade {

    public void notify(String notificationId) {
        throw new UnsupportedOperationException("Not supported yet");
    }

}
