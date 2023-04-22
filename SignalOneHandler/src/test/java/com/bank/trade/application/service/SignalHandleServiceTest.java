package com.bank.trade.application.service;

import com.bank.trade.application.util.AppConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SignalHandleServiceTest {

    @Autowired
    SignalHandlerService signalHandlerService;

    @Test
    void testSignalHandlerServiceWithCorrectSignalClass() {
        String actualResponse = signalHandlerService.invokeTradeAlgorithm("One");
        Assertions.assertEquals(actualResponse, AppConstants.ALGO_INVOCATION_MESSAGE);
    }

    @Test
    void testSignalHandlerServiceWithInCorrectSignalClass() {
        String actualResponse = signalHandlerService.invokeTradeAlgorithm("Two");
        Assertions.assertEquals(actualResponse, AppConstants.SIGNAL_MISMATCH_ERROR_MSG);
    }
}