package com.bank.trade.application.service;

import com.bank.trade.application.util.AppConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SignalHandleServiceTest {

    @Autowired
    SignalHandlerService signalHandlerService;

    @Test
    void testSignalHandlerServiceWithCorrectSignalClass() {
        String actualResponse = signalHandlerService.invokeTradeAlgorithm("One");
        Assertions.assertEquals(AppConstants.ALGO_INVOCATION_MESSAGE, actualResponse);
    }

    @Test
    void testSignalHandlerServiceWithInCorrectSignalClass() {
        String actualResponse = signalHandlerService.invokeTradeAlgorithm("Two");
        Assertions.assertEquals(AppConstants.SIGNAL_MISMATCH_ERROR_MSG, actualResponse);
    }
}
