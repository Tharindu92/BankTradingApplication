package com.bank.trade.application.signal;

import com.bank.trade.algo.Algo;

public class SignalTwo extends Signal{
    private Algo algo;
    public SignalTwo(Algo algo){
        this.algo = algo;
    }

    public void executeAlgorithm(){
        algo.reverse();
        algo.setAlgoParam(1,80);
        algo.submitToMarket();
        algo.doAlgo();
    }
}
