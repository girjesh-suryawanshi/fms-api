package com.mpcz.fmsapi.services;

import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsdao.dao.FeederDAO;
import com.mpcz.fmsinterface.FeederInterface;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<? extends FeederInterface> getAll() {
        String methodName = "findAll()  :";
        logger.error(methodName + "Called");

        List<? extends FeederInterface> feederInterfaces = null;
        //feederInterfaces = feederDAO.findAll();
        //feederDAO = (FeederDAO) feederDAO.findAll();

        feederInterfaces = feederDAO.getAll();

        if (feederInterfaces != null) {
            if (feederInterfaces.size() > 0) {
                return feederInterfaces;
            } else {
                System.out.println("Error...!");
            }
        }
        return feederInterfaces;

    }

    public void deleteById(Long Id) {
        String methodName = "deleteById()";
        logger.info(methodName + "called");
        feederDAO.deleteByID(Id);
    }
}
