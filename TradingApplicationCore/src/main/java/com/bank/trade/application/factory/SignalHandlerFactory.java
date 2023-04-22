package com.bank.trade.application.factory;

import com.bank.trade.algo.Algo;
import com.bank.trade.application.signal.Signal;
import com.bank.trade.application.signal.SignalInvalid;
import com.bank.trade.application.util.AppConstants;

import java.lang.reflect.InvocationTargetException;

public class SignalHandlerFactory {
    private Algo algo;

    public SignalHandlerFactory(Algo algo){
        this.algo = algo;
    }

    public Signal getSignal(String signal){
        try {
            String className = AppConstants.SIGNAL_CLASS_PATH + AppConstants.SIGNAL_CLASS_BASE_NAME + signal;
            return (Signal) Class.forName(className).getConstructor(Algo.class).newInstance(algo);
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            System.out.println(e.getLocalizedMessage());
            return new SignalInvalid(algo);
        }
    }
}
