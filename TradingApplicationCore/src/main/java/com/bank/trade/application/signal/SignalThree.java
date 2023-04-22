package com.bank.trade.application.signal;

import com.bank.trade.algo.Algo;

public class SignalThree extends Signal {
    private Algo algo;
    public SignalThree(Algo algo){
        this.algo = algo;
    }

    public void executeAlgorithm(){
        algo.setAlgoParam(1,90);
        algo.setAlgoParam(2,15);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
    }
}
