package com.bank.trade.application.factory;

import com.bank.trade.algo.Algo;

public class AlgoFactory {
    private AlgoFactory(){
        
    }

    public static Algo getAlgo(){
        return new Algo();
    }
}
