package com.bank.trade.application.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class SignalHandleControllerTest {

    @Autowired
    SignalHandleController controller;

    @Test
    void testSignalThreeController() {
        ResponseEntity<String> actualResponse = controller.executeTradeAlgorithm();
        Assertions.assertEquals(actualResponse.getStatusCode().value(),200);
    }
}