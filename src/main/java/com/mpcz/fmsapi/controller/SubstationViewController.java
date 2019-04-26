package com.mpcz.fmsapi.controller;

import com.mpcz.fmsapi.services.SubstationViewServices;
import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsinterface.SubstationInterface;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/substation")
public class SubstationViewController {

    private Logger logger = GlobalResources.getLogger(SubstationViewController.class);

    @Autowired
    SubstationViewServices substationViewServices;
    private long id;

    @RequestMapping(method = RequestMethod.GET,produces ="application/json")
    public ResponseEntity<?> getAll(){
        String methodName = "getAll() : ";
        logger.info(methodName +"called");
        ResponseEntity<?> responseEntity = null;
        List<?extends SubstationInterface> substationInterfaces = null;

        substationInterfaces = substationViewServices.getAll();

        if(substationInterfaces !=null){

            if(substationInterfaces.size()>0){
                responseEntity = new ResponseEntity<>(substationInterfaces, HttpStatus.OK);
            }else{
                responseEntity = new ResponseEntity<>("No Content",HttpStatus.NO_CONTENT);

            }

        }

        return  responseEntity;
}
}
