package com.mpcz.fmsapi.services;

import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsinterface.SubstationInterface;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubstationViewServices {
    private static Logger logger = GlobalResources.getLogger(SubstationViewServices.class);

    @Autowired
    SubstationViewServices  substationViewDAO;

    public List<? extends SubstationInterface> getAll() {
        String methodName = "getAll()  :";
        logger.error(methodName + "Called");

        List<? extends SubstationInterface> substationInterfaces = null;

        substationInterfaces = substationViewDAO.getAll();

        if (substationInterfaces != null) {
            if (substationInterfaces.size() > 0) {
                return substationInterfaces;
            } else {
                System.out.println("Error...!");
            }
        }
        return substationInterfaces;

    }
}
