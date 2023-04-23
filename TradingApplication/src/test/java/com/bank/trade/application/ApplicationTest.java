package com.bank.trade.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

class ApplicationTest {

    Application application = null;

    @BeforeEach
    void setUp() {
       this.application  = new Application();
    }

    @Test
    void testHandleSignalWithValidEndpointUrl() {

        String actualUrl = application.getEndPointUrl(1);
        Assertions.assertEquals("http://localhost:8081/trade/signals/one",actualUrl);
    }

    @Test
    void testHandleSignalWithInvalidEndpointUrl() {
        String actualUrl = application.getEndPointUrl(7);
        Assertions.assertEquals("http://localhost:9080/trade/signals/invalid",actualUrl);
    }

    @Test
    void testCallRestServiceWithValidUrl() {
        String actualUrl = application.getEndPointUrl(1);
        HttpResponse actualResponse = application.callRestService(actualUrl);
        Assertions.assertEquals(200, actualResponse.statusCode());
    }

    @Test
    void testCallRestServiceWithInValidUrl() {
        String actualUrl = application.getEndPointUrl(5);
        HttpResponse actualResponse = application.callRestService(actualUrl);
        Assertions.assertEquals(200, actualResponse.statusCode());
    }

}