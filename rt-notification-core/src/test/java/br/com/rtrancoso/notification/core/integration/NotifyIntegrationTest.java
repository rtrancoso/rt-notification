package br.com.rtrancoso.notification.core.integration;

import br.com.rtrancoso.notification.commons.model.Notification;
import br.com.rtrancoso.notification.core.dto.NotifyIn;
import br.com.rtrancoso.springboot.base.stream.event.producer.EventProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class NotifyIntegrationTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventProducer eventProducer;

    @Test
    void callCreate_WithTemplateKeyAndChannelsEmpty_ReturnsBadRequest() throws Exception {
        NotifyIn notifyIn = NotifyIn.builder().build();

        mockMvc.perform(post("/notifies").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(notifyIn)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("There are one or more arguments not valid for the method called"))
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(2)))
            .andExpect(jsonPath("$.errors[*].code").value(containsInAnyOrder(is("CONSTRAINT_TEMPLATEKEY"), is("CONSTRAINT_CHANNELS"))))
            .andExpect(jsonPath("$.errors[*].description").value(containsInAnyOrder(is("must not be blank"), is("must not be empty"))));
    }

    @Test
    void callCreate_WithValidNotify_ReturnsOk() throws Exception {
        NotifyIn notifyIn = NotifyIn.builder()
            .templateKey("TEMPLATE_KEY")
            .channels(List.of(Notification.Channel.APP, Notification.Channel.EMAIL))
            .build();

        mockMvc.perform(post("/notifies").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(notifyIn)))
            .andDo(print())
            .andExpect(status().isAccepted());
    }

}
