package com.bank.trade.application.signal;

import com.bank.trade.algo.Algo;

public class SignalInvalid extends Signal {
    private Algo algo;
    public SignalInvalid(Algo algo){
        this.algo = algo;
    }

    public void executeAlgorithm(){
        algo.cancelTrades();
        algo.doAlgo();
    }
}
