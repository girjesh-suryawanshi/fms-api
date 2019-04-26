package com.mpcz.fmsapi.controller;

import com.mpcz.fmsapi.services.FeederServices;
import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsinterface.FeederInterface;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/feeder")
public class FeederController {

    private Logger logger = GlobalResources.getLogger(FeederController.class);
    @Autowired
    FeederServices feederServices;
    private long id;

    @RequestMapping(method = RequestMethod.GET,produces ="application/json")
    public ResponseEntity<?> getAll() {
        String methodName = "getAll() : ";
        logger.info(methodName +"called");
        ResponseEntity<?> responseEntity = null;
        List<? extends FeederInterface> feederInterfaces = null;

        feederInterfaces = feederServices.getAll();

        if(feederInterfaces != null) {
            if(feederInterfaces.size()>0){
                responseEntity = new ResponseEntity<>(feederInterfaces, HttpStatus.OK);
            }else{
                responseEntity = new ResponseEntity<>("No Content",HttpStatus.NO_CONTENT);

            }
        }
        return  responseEntity;
    }
}
