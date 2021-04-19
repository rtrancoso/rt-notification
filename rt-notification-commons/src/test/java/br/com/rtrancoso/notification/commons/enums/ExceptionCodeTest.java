package br.com.rtrancoso.notification.commons.enums;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExceptionCodeTest {

    private static final Map<String, ExceptionCode> EXCEPTION_CODE_MAP = new HashMap<>();

    @BeforeAll
    static void setup() {
        for (ExceptionCode exceptionCode : ExceptionCode.values()) {
            EXCEPTION_CODE_MAP.put(exceptionCode.name(), exceptionCode);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "TEMPLATE_001",
        "TEMPLATE_002",
        "TEMPLATE_003",
        "TEMPLATE_004",
        "TEMPLATE_005",
        "TEMPLATE_006",
        "TEMPLATE_007",
        "TEMPLATE_008",
        "NOTIFICATION_001",
        "NOTIFICATION_002",
        "NOTIFICATION_APP_001",
        "NOTIFICATION_APP_002",
        "NOTIFICATION_EMAIL_001",
        "NOTIFICATION_EMAIL_002",
        "NOTIFICATION_EMAIL_003",
        "INTEGRATION_SEND_GRID"
    })
    void existsExceptionCode_ReturnsTrue(String notificationEventTypeName) {
        assertNotNull(EXCEPTION_CODE_MAP.get(notificationEventTypeName));
    }

    @ParameterizedTest
    @CsvSource({
        "TEMPLATE_001,TEMPLATE_001,There is already a template with the same key.",
        "TEMPLATE_002,TEMPLATE_002,There is already a template with the same name.",
        "TEMPLATE_003,TEMPLATE_003,One or more Specification are required.",
        "TEMPLATE_004,TEMPLATE_004,There is already a template with the same SpecificationApp message.",
        "TEMPLATE_005,TEMPLATE_005,There is already a template with the same SpecificationEmail templateId.",
        "TEMPLATE_006,TEMPLATE_006,There is already a template with the same SpecificationPush body.",
        "TEMPLATE_007,TEMPLATE_007,There is already a template with the same SpecificationSms message.",
        "TEMPLATE_008,TEMPLATE_008,There is already a template with the same SpecificationWhatsApp message.",
        "NOTIFICATION_001,NOTIFICATION_001,Realm is required to notify.",
        "NOTIFICATION_002,NOTIFICATION_002,At least one channel is required to notify.",
        "NOTIFICATION_APP_001,NOTIFICATION_APP_001,Receiver is required to notify by channel app.",
        "NOTIFICATION_APP_002,NOTIFICATION_APP_002,Message is required to notify by channel app.",
        "NOTIFICATION_EMAIL_001,NOTIFICATION_EMAIL_001,Sender is required to notify by channel email.",
        "NOTIFICATION_EMAIL_002,NOTIFICATION_EMAIL_002,Receiver is required to notify by channel email.",
        "NOTIFICATION_EMAIL_003,NOTIFICATION_EMAIL_003,Template is required to notify by channel email.",
        "INTEGRATION_SEND_GRID,INTEGRATION_SEND_GRID,Error when trying some information from SendGrid",
    })
    void verifyCodeDescriptionExceptionCode_ReturnsTrue(String exceptionCodeName, String exceptionCodeCode, String exceptionCodeDescription) {
        final ExceptionCode exceptionCode = EXCEPTION_CODE_MAP.get(exceptionCodeName);
        assertEquals(exceptionCodeCode, exceptionCode.getCode());
        assertEquals(exceptionCodeDescription, exceptionCode.getDescription());
    }

}
