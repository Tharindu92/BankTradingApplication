package com.bank.trade.application.service;

import com.bank.trade.application.handler.SignalHandleServiceAbstract;
import com.bank.trade.application.signal.Signal;
import com.bank.trade.application.signal.SignalTwo;
import com.bank.trade.application.util.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SignalHandlerService extends SignalHandleServiceAbstract {
    @Override
    public String invokeTradeAlgorithm(String signalInt) {
        Signal signalObj = getSignal(signalInt);
        if(signalObj instanceof SignalTwo) {
            log.info("Signal Class Match and invoking the Signal 2 algorithm");
            return callAlgorithm(signalObj);
        }else{
            log.info(AppConstants.SIGNAL_MISMATCH_ERROR_MSG);
            return AppConstants.SIGNAL_MISMATCH_ERROR_MSG;
        }
    }
}
