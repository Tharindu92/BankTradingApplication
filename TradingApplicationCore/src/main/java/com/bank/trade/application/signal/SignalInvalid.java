package com.bank.trade.application.signal;

import com.bank.trade.algo.Algo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignalInvalid extends Signal {
    private Algo algo;
    public SignalInvalid(Algo algo){
        this.algo = algo;
    }

    public void executeAlgorithm(){
        log.info("Cancelling the Trade");
        algo.cancelTrades();
        algo.doAlgo();
    }
}
