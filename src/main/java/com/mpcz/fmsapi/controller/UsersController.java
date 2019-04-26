package com.mpcz.fmsapi.controller;

import com.mpcz.fmsapi.services.UsersServices;
import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsapi.utility.SubstationFeederDTO;
import com.mpcz.fmsentity.bean.Substation;
import com.mpcz.fmsentity.bean.SubstationFeeder;
import com.mpcz.fmsentity.bean.Users;
import com.mpcz.fmsinterface.UserInterface;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;


@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/user")
public class UsersController {

    private static Logger logger = GlobalResources.getLogger(UsersController.class);

    @Autowired
    UsersServices usersServices;

    @RequestMapping(value = "test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> get() {
        SubstationFeederDTO substationFeederDTO = new SubstationFeederDTO();
        SubstationFeeder sb = new SubstationFeeder();
        sb.setSubstationFeederId(1);
        sb.setSubstationFeederName("Indore");
        sb.setSubstationId(22);
        SubstationFeeder sb1 = new SubstationFeeder();
        sb1.setSubstationFeederId(1);
        sb1.setSubstationFeederName("Indore");
        sb1.setSubstationId(22);
        List<SubstationFeeder> substationFeederInterface = new ArrayList<SubstationFeeder>();
        substationFeederInterface.add(sb1);
        substationFeederInterface.add(sb);
        substationFeederDTO.setSubstationFeederInterface(substationFeederInterface);
        Substation s = new Substation();
        s.setSubstationName("A");
        substationFeederDTO.setSubstationInterface(s);
        ResponseEntity responseEntity = new ResponseEntity<>(substationFeederDTO, HttpStatus.OK);
//System.out.println(responseEntity.toString());
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> postUser(@RequestBody Users users) {
        String methodName = "posdfdftUser() ";
        logger.info(methodName + "called");
        System.out.println("te ffst " + users.getUserName());
        ResponseEntity<?> response = null;
        UserInterface userInterface = null;

        if (users != null) {

            userInterface = usersServices.getUser(users.getUserName());

            if (userInterface != null) {
                if (!userInterface.getPassword().equals(users.getPassword())) {
                    response = new ResponseEntity<>("Authontication Error", HttpStatus.EXPECTATION_FAILED);
                } else {
                    response = new ResponseEntity<>(userInterface, HttpStatus.OK);
                }

            } else {
                response = new ResponseEntity<>("No Content", HttpStatus.NO_CONTENT);
            }
        }
        return response;
    }

}
