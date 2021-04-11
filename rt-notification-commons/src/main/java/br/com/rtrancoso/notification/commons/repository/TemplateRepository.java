package br.com.rtrancoso.notification.commons.repository;

import br.com.rtrancoso.notification.commons.model.Template;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemplateRepository extends MongoRepository<Template, String> {

    Optional<Template> findByRealmAndKey(String realm, String key);

    Optional<Template> findByRealmAndKeyAndIdNot(String realm, String key, String id);

    Optional<Template> findByRealmAndName(String realm, String name);

    Optional<Template> findByRealmAndNameAndIdNot(String realm, String name, String id);

    Optional<Template> findByRealmAndTemplateAppMessage(String realm, String message);

    Optional<Template> findByRealmAndTemplateAppMessageAndIdNot(String realm, String message, String id);

    Optional<Template> findByRealmAndTemplateEmailTemplateId(String realm, String templateId);

    Optional<Template> findByRealmAndTemplateEmailTemplateIdAndIdNot(String realm, String templateId, String id);

    Optional<Template> findByRealmAndTemplatePushBody(String realm, String body);

    Optional<Template> findByRealmAndTemplatePushBodyAndIdNot(String realm, String body, String id);

    Optional<Template> findByRealmAndTemplateSmsMessage(String realm, String message);

    Optional<Template> findByRealmAndTemplateSmsMessageAndIdNot(String realm, String message, String id);

    Optional<Template> findByRealmAndTemplateWhatsAppMessage(String realm, String message);

    Optional<Template> findByRealmAndTemplateWhatsAppMessageAndIdNot(String realm, String message, String id);

}
