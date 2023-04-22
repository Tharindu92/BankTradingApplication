package com.bank.trade.application.signal;

import com.bank.trade.algo.Algo;

public class SignalOne extends Signal {
    private Algo algo;
    public SignalOne(Algo algo){
        this.algo = algo;
    }

    public void executeAlgorithm(){
        algo.setUp();
        algo.setAlgoParam(1,60);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
    }
}
