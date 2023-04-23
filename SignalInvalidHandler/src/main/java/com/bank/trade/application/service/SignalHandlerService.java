package com.bank.trade.application.service;

import com.bank.trade.application.handler.SignalHandleServiceAbstract;
import com.bank.trade.application.signal.Signal;
import com.bank.trade.application.signal.SignalInvalid;
import com.bank.trade.application.util.AppConstants;
import org.springframework.stereotype.Service;

@Service
public class SignalHandlerService extends SignalHandleServiceAbstract {

    @Override
    public String invokeTradeAlgorithm(String signalInt) {
        Signal signalObj = getSignal(signalInt);
        if(signalObj.getClass().getSimpleName().equals(SignalInvalid.class.getSimpleName())) {
            return callAlgorithm(signalObj);
        }else{
            return AppConstants.SIGNAL_MISMATCH_ERROR_MSG;
        }
    }
}
