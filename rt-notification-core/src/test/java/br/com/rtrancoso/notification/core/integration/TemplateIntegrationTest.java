package br.com.rtrancoso.notification.core.integration;

import br.com.rtrancoso.notification.commons.enums.ExceptionCode;
import br.com.rtrancoso.notification.commons.model.Template;
import br.com.rtrancoso.notification.commons.model.TemplateApp;
import br.com.rtrancoso.notification.commons.model.TemplateEmail;
import br.com.rtrancoso.notification.commons.model.TemplatePush;
import br.com.rtrancoso.notification.commons.model.TemplateSms;
import br.com.rtrancoso.notification.commons.model.TemplateWhatsApp;
import br.com.rtrancoso.notification.commons.repository.TemplateRepository;
import br.com.rtrancoso.notification.core.dto.TemplateIn;
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

import java.util.Optional;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class TemplateIntegrationTest {

    private static final String ID = "ID";
    private static final String KEY = "KEY";
    private static final String NAME = "NAME";
    private static final String MESSAGE = "MESSAGE";
    private static final String EMAIL_TEMPLATE_ID = "EMAIL_TEMPLATE_ID";
    private static final String EMAIL_TEMPLATE_CATEGORY = "EMAIL_TEMPLATE_CATEGORY";
    private static final String EMAIL_SENDER = "EMAIL_SENDER";
    private static final String EMAIL_SENDER_NAME = "EMAIL_SENDER_NAME";
    private static final String PUSH_TITLE = "PUSH_TITLE";
    private static final String PUSH_BODY = "PUSH_BODY";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TemplateRepository templateRepository;

    @Test
    void callFindAll_ReturnsOk() throws Exception {
        mockMvc.perform(get("/templates").contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json("[]"));
    }

    @Test
    void callFindById_ReturnsOk() throws Exception {
        Template template = Template.builder()
            .id(ID)
            .build();

        when(templateRepository.findById(ID)).thenReturn(Optional.of(template));

        mockMvc.perform(get("/templates/{id}", ID).contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(ID));
    }

    @Test
    void callFindById_ReturnsNotFound() throws Exception {
        mockMvc.perform(get("/templates/{id}", ID).contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("ResourceNotFoundException"));
    }

    @Test
    void callCreate_WithKeyAndNameEmpty_ReturnsBadRequest() throws Exception {
        TemplateIn templateIn = TemplateIn.builder().build();

        mockMvc.perform(post("/templates").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(templateIn)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("There are one or more arguments not valid for the method called"))
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(2)))
            .andExpect(jsonPath("$.errors[*].code").value(containsInAnyOrder(is("CONSTRAINT_KEY"), is("CONSTRAINT_NAME"))))
            .andExpect(jsonPath("$.errors[*].description").value(everyItem(is("must not be blank"))));
    }

    @Test
    void callCreate_WithTemplateAppEmpty_ReturnsBadRequest() throws Exception {
        TemplateIn templateIn = TemplateIn.builder()
            .key(KEY)
            .name(NAME)
            .templateApp(TemplateApp.builder().build())
            .build();

        mockMvc.perform(post("/templates").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(templateIn)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("There are one or more arguments not valid for the method called"))
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(1)))
            .andExpect(jsonPath("$.errors[*].code").value(containsInAnyOrder(is("CONSTRAINT_TEMPLATEAPP.MESSAGE"))))
            .andExpect(jsonPath("$.errors[*].description").value(everyItem(is("must not be blank"))));
    }

    @Test
    void callCreate_WithTemplateEmailEmpty_ReturnsBadRequest() throws Exception {
        TemplateIn templateIn = TemplateIn.builder()
            .key(KEY)
            .name(NAME)
            .templateEmail(TemplateEmail.builder().build())
            .build();

        mockMvc.perform(post("/templates").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(templateIn)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("There are one or more arguments not valid for the method called"))
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(4)))
            .andExpect(jsonPath("$.errors[*].code").value(containsInAnyOrder(
                is("CONSTRAINT_TEMPLATEEMAIL.TEMPLATEID"),
                is("CONSTRAINT_TEMPLATEEMAIL.TEMPLATECATEGORY"),
                is("CONSTRAINT_TEMPLATEEMAIL.SENDER"),
                is("CONSTRAINT_TEMPLATEEMAIL.SENDERNAME"))))
            .andExpect(jsonPath("$.errors[*].description").value(everyItem(is("must not be blank"))));
    }

    @Test
    void callCreate_WithTemplatePushEmpty_ReturnsBadRequest() throws Exception {
        TemplateIn templateIn = TemplateIn.builder()
            .key(KEY)
            .name(NAME)
            .templatePush(TemplatePush.builder().build())
            .build();

        mockMvc.perform(post("/templates").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(templateIn)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("There are one or more arguments not valid for the method called"))
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(2)))
            .andExpect(jsonPath("$.errors[*].code").value(containsInAnyOrder(
                is("CONSTRAINT_TEMPLATEPUSH.TITLE"),
                is("CONSTRAINT_TEMPLATEPUSH.BODY"))))
            .andExpect(jsonPath("$.errors[*].description").value(everyItem(is("must not be blank"))));
    }

    @Test
    void callCreate_WithTemplateSmsEmpty_ReturnsBadRequest() throws Exception {
        TemplateIn templateIn = TemplateIn.builder()
            .key(KEY)
            .name(NAME)
            .templateSms(TemplateSms.builder().build())
            .build();

        mockMvc.perform(post("/templates").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(templateIn)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("There are one or more arguments not valid for the method called"))
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(1)))
            .andExpect(jsonPath("$.errors[*].code").value(containsInAnyOrder(is("CONSTRAINT_TEMPLATESMS.MESSAGE"))))
            .andExpect(jsonPath("$.errors[*].description").value(everyItem(is("must not be blank"))));
    }

    @Test
    void callCreate_WithTemplateWhatsAppEmpty_ReturnsBadRequest() throws Exception {
        TemplateIn templateIn = TemplateIn.builder()
            .key(KEY)
            .name(NAME)
            .templateWhatsApp(TemplateWhatsApp.builder().build())
            .build();

        mockMvc.perform(post("/templates").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(templateIn)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("There are one or more arguments not valid for the method called"))
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(1)))
            .andExpect(jsonPath("$.errors[*].code").value(containsInAnyOrder(is("CONSTRAINT_TEMPLATEWHATSAPP.MESSAGE"))))
            .andExpect(jsonPath("$.errors[*].description").value(everyItem(is("must not be blank"))));
    }

    @Test
    void callCreate_WithInitialBusinessValidation_ReturnsBadRequest() throws Exception {
        TemplateIn templateIn = TemplateIn.builder()
            .key(KEY)
            .name(NAME)
            .build();

        Template template = Template.builder()
            .id(ID)
            .name(NAME)
            .build();

        when(templateRepository.findByKey(KEY)).thenReturn(Optional.of(template));
        when(templateRepository.findByName(NAME)).thenReturn(Optional.of(template));

        mockMvc.perform(post("/templates").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(templateIn)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("Some business validations have not been met"))
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(3)))
            .andExpect(jsonPath("$.errors[*].code").value(containsInAnyOrder(
                is(ExceptionCode.TEMPLATE_001.getCode()),
                is(ExceptionCode.TEMPLATE_002.getCode()),
                is(ExceptionCode.TEMPLATE_003.getCode()))))
            .andExpect(jsonPath("$.errors[*].description").value(containsInAnyOrder(
                is(ExceptionCode.TEMPLATE_001.getDescription()),
                is(ExceptionCode.TEMPLATE_002.getDescription()),
                is(ExceptionCode.TEMPLATE_003.getDescription()))));
    }

    @Test
    void callCreate_WithNoValidTemplateApp_ReturnsBadRequest() throws Exception {
        TemplateIn templateIn = TemplateIn.builder()
            .key(KEY)
            .name(NAME)
            .templateApp(TemplateApp.builder()
                .message(MESSAGE)
                .build())
            .build();

        Template template = Template.builder()
            .id(ID)
            .name(NAME)
            .build();

        when(templateRepository.findByTemplateAppMessage(MESSAGE)).thenReturn(Optional.of(template));

        mockMvc.perform(post("/templates").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(templateIn)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("Some business validations have not been met"))
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(1)))
            .andExpect(jsonPath("$.errors[0].code").value(ExceptionCode.TEMPLATE_004.getCode()))
            .andExpect(jsonPath("$.errors[0].description").value(ExceptionCode.TEMPLATE_004.getDescription()));
    }

    @Test
    void callCreate_WithNoValidTemplateEmail_ReturnsBadRequest() throws Exception {
        TemplateIn templateIn = TemplateIn.builder()
            .key(KEY)
            .name(NAME)
            .templateEmail(TemplateEmail.builder()
                .templateId(EMAIL_TEMPLATE_ID)
                .templateCategory(EMAIL_TEMPLATE_CATEGORY)
                .sender(EMAIL_SENDER)
                .senderName(EMAIL_SENDER_NAME)
                .build())
            .build();

        Template template = Template.builder()
            .id(ID)
            .name(NAME)
            .build();

        when(templateRepository.findByTemplateEmailTemplateId(EMAIL_TEMPLATE_ID)).thenReturn(Optional.of(template));

        mockMvc.perform(post("/templates").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(templateIn)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("Some business validations have not been met"))
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(1)))
            .andExpect(jsonPath("$.errors[0].code").value(ExceptionCode.TEMPLATE_005.getCode()))
            .andExpect(jsonPath("$.errors[0].description").value(ExceptionCode.TEMPLATE_005.getDescription()));
    }

    @Test
    void callCreate_WithNoValidTemplatePush_ReturnsBadRequest() throws Exception {
        TemplateIn templateIn = TemplateIn.builder()
            .key(KEY)
            .name(NAME)
            .templatePush(TemplatePush.builder()
                .title(PUSH_TITLE)
                .body(PUSH_BODY)
                .build())
            .build();

        Template template = Template.builder()
            .id(ID)
            .name(NAME)
            .build();

        when(templateRepository.findByTemplatePushBody(PUSH_BODY)).thenReturn(Optional.of(template));

        mockMvc.perform(post("/templates").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(templateIn)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("Some business validations have not been met"))
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(1)))
            .andExpect(jsonPath("$.errors[0].code").value(ExceptionCode.TEMPLATE_006.getCode()))
            .andExpect(jsonPath("$.errors[0].description").value(ExceptionCode.TEMPLATE_006.getDescription()));
    }

    @Test
    void callCreate_WithNoValidTemplateSms_ReturnsBadRequest() throws Exception {
        TemplateIn templateIn = TemplateIn.builder()
            .key(KEY)
            .name(NAME)
            .templateSms(TemplateSms.builder()
                .message(MESSAGE)
                .build())
            .build();

        Template template = Template.builder()
            .id(ID)
            .name(NAME)
            .build();

        when(templateRepository.findByTemplateSmsMessage(MESSAGE)).thenReturn(Optional.of(template));

        mockMvc.perform(post("/templates").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(templateIn)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("Some business validations have not been met"))
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(1)))
            .andExpect(jsonPath("$.errors[0].code").value(ExceptionCode.TEMPLATE_007.getCode()))
            .andExpect(jsonPath("$.errors[0].description").value(ExceptionCode.TEMPLATE_007.getDescription()));
    }

    @Test
    void callCreate_WithNoValidTemplateWhatsApp_ReturnsBadRequest() throws Exception {
        TemplateIn templateIn = TemplateIn.builder()
            .key(KEY)
            .name(NAME)
            .templateWhatsApp(TemplateWhatsApp.builder()
                .message(MESSAGE)
                .build())
            .build();

        Template template = Template.builder()
            .id(ID)
            .name(NAME)
            .build();

        when(templateRepository.findByTemplateWhatsAppMessage(MESSAGE)).thenReturn(Optional.of(template));

        mockMvc.perform(post("/templates").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(templateIn)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("Some business validations have not been met"))
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(1)))
            .andExpect(jsonPath("$.errors[0].code").value(ExceptionCode.TEMPLATE_008.getCode()))
            .andExpect(jsonPath("$.errors[0].description").value(ExceptionCode.TEMPLATE_008.getDescription()));
    }

}
