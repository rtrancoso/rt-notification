package br.com.rtrancoso.notification.commons.repository;

import br.com.rtrancoso.notification.commons.model.Template;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemplateRepository extends MongoRepository<Template, String> {

    Optional<Template> findByKey(String key);

    Optional<Template> findByKeyAndIdNot(String key, String id);

    Optional<Template> findByName(String name);

    Optional<Template> findByNameAndIdNot(String name, String id);

    Optional<Template> findByTemplateAppMessage(String message);

    Optional<Template> findByTemplateAppMessageAndIdNot(String message, String id);

    Optional<Template> findByTemplateEmailTemplateId(String templateId);

    Optional<Template> findByTemplateEmailTemplateIdAndIdNot(String templateId, String id);

    Optional<Template> findByTemplatePushBody(String body);

    Optional<Template> findByTemplatePushBodyAndIdNot(String body, String id);

    Optional<Template> findByTemplateSmsMessage(String message);

    Optional<Template> findByTemplateSmsMessageAndIdNot(String message, String id);

    Optional<Template> findByTemplateWhatsAppMessage(String message);

    Optional<Template> findByTemplateWhatsAppMessageAndIdNot(String message, String id);

}
