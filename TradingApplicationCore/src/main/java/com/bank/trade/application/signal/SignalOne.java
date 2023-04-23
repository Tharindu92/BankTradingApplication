package com.bank.trade.application.signal;

import com.bank.trade.algo.Algo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignalOne extends Signal {
    private Algo algo;
    public SignalOne(Algo algo){
        this.algo = algo;
    }

    public void executeAlgorithm(){
        log.info("Executing Signal 1 trading algorithm");
        algo.setUp();
        algo.setAlgoParam(1,60);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
    }
}
