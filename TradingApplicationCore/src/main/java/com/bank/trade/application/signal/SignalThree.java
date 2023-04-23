package com.bank.trade.application.signal;

import com.bank.trade.algo.Algo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignalThree implements Signal {
    private Algo algo;
    public SignalThree(Algo algo){
        this.algo = algo;
    }

    public void executeAlgorithm(){
        log.info("Executing Signal 1 trading algorithm");
        algo.setAlgoParam(1,90);
        algo.setAlgoParam(2,15);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
    }
}
