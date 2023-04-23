package com.bank.trade.application.cache;

import com.bank.trade.application.util.CacheConstants;

import java.util.HashMap;
import java.util.Map;

public class SignalEndpoints {
    private SignalEndpoints(){}
    private static final Map<String, String> endPoints =  new HashMap<>();

    static {
        endPoints.put("SIGNAL1", CacheConstants.ENDPOINT_URL + ":"+ "8081" + CacheConstants.ENDPOINT_COMMON_RESOURCE +"one");
        endPoints.put("SIGNAL2", CacheConstants.ENDPOINT_URL + ":"+ "8082" + CacheConstants.ENDPOINT_COMMON_RESOURCE +"two");
        endPoints.put("SIGNAL3", CacheConstants.ENDPOINT_URL + ":"+ "8083" + CacheConstants.ENDPOINT_COMMON_RESOURCE +"three");
        endPoints.put("SIGNALINVALID",CacheConstants.ENDPOINT_URL + ":"+ "9080" + CacheConstants.ENDPOINT_COMMON_RESOURCE +"invalid" );
    }

    public static String getEndPointsBySignal(String signal){
        if(endPoints.containsKey(signal)){
            return endPoints.get(signal);
        }else {
            return endPoints.get("SIGNALINVALID");
        }
    }


}
