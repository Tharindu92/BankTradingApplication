package com.bank.trade.application.signal;

import com.bank.trade.algo.Algo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignalTwo implements Signal{
    private Algo algo;
    public SignalTwo(Algo algo){
        this.algo = algo;
    }

    public void executeAlgorithm(){
        log.info("Executing Signal 1 trading algorithm");
        algo.reverse();
        algo.setAlgoParam(1,80);
        algo.submitToMarket();
        algo.doAlgo();
    }
}
