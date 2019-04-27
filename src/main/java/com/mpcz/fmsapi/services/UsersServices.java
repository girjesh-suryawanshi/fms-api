package com.mpcz.fmsapi.services;

import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsdao.dao.UsersDAO;
import com.mpcz.fmsinterface.UserInterface;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsersServices {

    private static Logger logger = GlobalResources.getLogger(UsersServices.class);

    @Autowired
    UsersDAO usersDAO;

    public UserInterface getUser(String userName) {
        String methodName = "getUser() ";
        logger.info(methodName + "called");
        UserInterface userInterface = null;
        if (userName != null) {
            userInterface = usersDAO.getUser(userName);
        }
        return userInterface;

    }


}