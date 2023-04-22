package com.bank.trade.application.controller;

import com.bank.trade.application.service.SignalHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/trade/signals")
public class SignalHandleController {

    @Autowired
    private SignalHandlerService signalHandlerService;

    @GetMapping(value = "/invalid")
    public ResponseEntity<String> executeTradeAlgorithm(){
        signalHandlerService.invokeTradeAlgorithm("Invalid");
        return new ResponseEntity<>(HttpStatus.Series.SUCCESSFUL.name(), HttpStatus.OK);
    }
}
