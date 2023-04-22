package com.bank.trade.application.handler;

import com.bank.trade.algo.Algo;
import com.bank.trade.application.factory.SignalHandlerFactory;
import com.bank.trade.application.signal.Signal;
import com.bank.trade.application.util.AppConstants;

public abstract class SignalHandleServiceAbstract {
    private Algo algo = new Algo();
    private SignalHandlerFactory signalHandlerFactory = new SignalHandlerFactory(algo);

    public abstract String invokeTradeAlgorithm(String signalInt);

    protected String callAlgorithm(Signal signalObj) {
        signalObj.executeAlgorithm();
        return AppConstants.ALGO_INVOCATION_MESSAGE;
    }

    protected Signal getSignal(String signalInt) {
        return signalHandlerFactory.getSignal(signalInt);
    }

}
