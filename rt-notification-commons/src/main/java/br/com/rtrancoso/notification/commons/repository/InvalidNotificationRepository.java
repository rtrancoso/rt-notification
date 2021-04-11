package br.com.rtrancoso.notification.commons.repository;

import br.com.rtrancoso.notification.commons.model.InvalidNotification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvalidNotificationRepository extends MongoRepository<InvalidNotification, String> {

}
