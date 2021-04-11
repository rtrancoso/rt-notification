package br.com.rtrancoso.notification.commons.repository;

import br.com.rtrancoso.notification.commons.model.TrashTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrashTemplateRepository extends MongoRepository<TrashTemplate, String> {

}
