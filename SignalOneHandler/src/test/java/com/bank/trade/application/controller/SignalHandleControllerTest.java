package com.bank.trade.application.controller;

import com.bank.trade.application.service.SignalHandlerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@SpringBootTest
class SignalHandleControllerTest {

    @Autowired
    SignalHandleController controller;

    @Test
    void testSignalOneController() {
        ResponseEntity<String> actualResponse = controller.executeTradeAlgorithm();
        Assertions.assertEquals(actualResponse.getStatusCode().value(),200);
    }
}