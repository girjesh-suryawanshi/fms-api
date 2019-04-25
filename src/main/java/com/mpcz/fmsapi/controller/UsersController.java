package com.mpcz.fmsapi.controller;

import com.mpcz.fmsapi.services.UsersServices;
import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsentity.bean.Users;
import com.mpcz.fmsinterface.UserInterface;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value ="/user")
public class UsersController {

  private static Logger logger = GlobalResources.getLogger(UsersController.class);

  @Autowired
  UsersServices usersServices;
  @RequestMapping(method = RequestMethod.POST,produces ="application/json")
  public ResponseEntity<?>postUser(@RequestBody Users users){
    String methodName ="postUser() ";
    logger.info(methodName + "called");
    ResponseEntity<?> response = null;
    UserInterface userInterface = null;

    if(users != null){

      userInterface = usersServices.getUser(users.getUserName());

      if(userInterface != null){
        response = new ResponseEntity<>(userInterface, HttpStatus.OK);
      }else{
        response = new ResponseEntity<>("No Content",HttpStatus.NO_CONTENT);
      }
    }
    return  response;
  }

}
