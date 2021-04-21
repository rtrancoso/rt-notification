package br.com.rtrancoso.notification.core.unit.dto;

import br.com.rtrancoso.notification.commons.model.Notification;
import br.com.rtrancoso.notification.core.dto.NotifyIn;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotifyInTest {

    private static final String TEMPLATE_KEY = "TEMPLATE_KEY";
    private static final List<Notification.Channel> CHANNELS = List.of(Notification.Channel.APP, Notification.Channel.EMAIL);
    private static final Map<String, String> PARAMS = Map.of("PARAM1", "VALUE1", "PARAM2", "VALUE2");

    @Test
    void callNoArgsConstructor_ReturnsNotifyIn() {
        NotifyIn notifyIn = new NotifyIn();
        notifyIn.setTemplateKey(TEMPLATE_KEY);
        notifyIn.setChannels(CHANNELS);
        notifyIn.setParams(PARAMS);

        assertNotNull(notifyIn.getTemplateKey());
        assertNotNull(notifyIn.getChannels());
        assertNotNull(notifyIn.getParams());
    }

    @Test
    void callAllArgsConstructor_ReturnsNotifyIn() {
        NotifyIn notifyIn = new NotifyIn(TEMPLATE_KEY, CHANNELS, PARAMS);

        assertNotNull(notifyIn.getTemplateKey());
        assertNotNull(notifyIn.getChannels());
        assertNotNull(notifyIn.getParams());
    }

    @Test
    void callBuilder_ReturnsNotifyIn() {
        NotifyIn notifyIn = NotifyIn.builder()
            .templateKey(TEMPLATE_KEY)
            .channels(CHANNELS)
            .params(PARAMS)
            .build();

        assertNotNull(notifyIn.getTemplateKey());
        assertNotNull(notifyIn.getChannels());
        assertNotNull(notifyIn.getParams());
    }

}
