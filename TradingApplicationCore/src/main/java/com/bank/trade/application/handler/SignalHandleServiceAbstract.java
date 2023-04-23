package com.bank.trade.application.handler;

import com.bank.trade.application.factory.AlgoFactory;
import com.bank.trade.application.factory.SignalHandlerFactory;
import com.bank.trade.application.signal.Signal;
import com.bank.trade.application.util.AppConstants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class SignalHandleServiceAbstract {

    public abstract String invokeTradeAlgorithm(String signalInt);

    protected String callAlgorithm(Signal signalObj) {
        log.info("Calling Trading Algorithm based on Signal "+signalObj.getClass().getSimpleName());
        signalObj.executeAlgorithm();
        return AppConstants.ALGO_INVOCATION_MESSAGE;
    }

    protected Signal getSignal(String signalInt) {
        log.info("Getting the Signal " + signalInt);
        return SignalHandlerFactory.getSignal(signalInt, AlgoFactory.getAlgo());
    }

}
