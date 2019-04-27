package com.mpcz.fmsapi.services;

import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsdao.dao.FeederDAO;
import com.mpcz.fmsinterface.FeederInterface;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeederServices {
    private static Logger logger = GlobalResources.getLogger(FeederServices.class);

    @Autowired
    FeederDAO feederDAO;

    public FeederInterface insert(FeederInterface feederInterface){
        String methodName = "insert() ";
        logger.info(methodName + "called");
        FeederInterface feederInterface1 = null;
        if(feederInterface != null){
            feederInterface1 = feederDAO.insertFeeder(feederInterface);
        }
        return feederInterface1;
    }
}
