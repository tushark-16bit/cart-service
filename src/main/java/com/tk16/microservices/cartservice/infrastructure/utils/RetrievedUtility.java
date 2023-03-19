package com.tk16.microservices.cartservice.infrastructure.utils;

public class RetrievedUtility {

    public static void checkAndRaiseExceptionIfNull(Object obj,
                                                       String objName)
            throws Exception {
        if (obj==null) throw new Exception("Value "+objName+" not fund");
    }
}
