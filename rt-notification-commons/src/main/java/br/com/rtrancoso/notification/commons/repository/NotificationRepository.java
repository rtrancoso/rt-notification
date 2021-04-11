package br.com.rtrancoso.notification.commons.repository;

import br.com.rtrancoso.notification.commons.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {

}
