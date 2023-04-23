package com.bank.trade.application;

import com.ban.trade.handle.SignalHandler;
import com.bank.trade.application.cache.SignalEndpoints;
import com.bank.trade.application.util.CacheConstants;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

import static java.net.URI.create;

public class Application implements SignalHandler {
    public void handleSignal(int signal) {
        String url = getEndPointUrl(signal);
        callRestService(url);
    }

    protected String getEndPointUrl(int signal){
        String signalStr = CacheConstants.SIGNAL_CLASS_BASE_NAME.toUpperCase(Locale.ROOT)+signal;
        return SignalEndpoints.getEndPointsBySignal(signalStr);
    }

    protected HttpResponse<String> callRestService(String url){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(create(url))
                .build();
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException  e) {
            System.err.println("Error calling the micro service: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Error calling the micro service: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        return httpResponse;
    }

}
