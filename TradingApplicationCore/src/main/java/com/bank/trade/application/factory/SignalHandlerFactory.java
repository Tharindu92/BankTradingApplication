package com.bank.trade.application.factory;

import com.bank.trade.algo.Algo;
import com.bank.trade.application.signal.Signal;
import com.bank.trade.application.signal.SignalInvalid;
import com.bank.trade.application.util.AppConstants;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;

@Slf4j
public class SignalHandlerFactory {
    private SignalHandlerFactory(){

    }

    public static Signal getSignal(String signal, Algo algo){
        try {
            String className = AppConstants.SIGNAL_CLASS_PATH + AppConstants.SIGNAL_CLASS_BASE_NAME + signal;
            return (Signal) Class.forName(className).getConstructor(Algo.class).newInstance(algo);
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            log.error("Error in getting signal from given signal " + e.getMessage());
            return new SignalInvalid(algo);
        }
    }
}
