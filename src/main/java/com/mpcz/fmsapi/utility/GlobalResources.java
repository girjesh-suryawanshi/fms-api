package com.mpcz.fmsapi.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class GlobalResources {

    public static Logger getLogger(Class className) {
        return LoggerFactory.getLogger(className);
    }


}
