package com.mpcz.fmsapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mpcz.fmsapi.services.CircleServices;
import com.mpcz.fmsapi.services.ZoneServices;
import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsinterface.CircleInterface;
import com.mpcz.fmsinterface.ZoneInterface;

@Controller

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value ="/location")

public class LocationController {
	private Logger logger = GlobalResources.getLogger(LocationController.class);

	@Autowired
	ZoneServices zoneServices;
	
	@Autowired
	CircleServices circleServices;
	
	@GetMapping(value = "/zone")
    public ResponseEntity<?>getAll(){
        String methodName="getAll() :";
        logger.info(methodName+" Called");
        ResponseEntity<?> responseEntity = null;
        List<?extends ZoneInterface> zoneInterfaces= null;

        zoneInterfaces = zoneServices.getAll();

        if(zoneInterfaces !=null){

            if(zoneInterfaces.size()>0){
                responseEntity = new ResponseEntity<>(zoneInterfaces, HttpStatus.OK);
            }else{
                responseEntity = new ResponseEntity<>("No Content",HttpStatus.NO_CONTENT);

            }

        }

        return  responseEntity;
    }
	
	@GetMapping(value = "/circle")
    public ResponseEntity<?>getAllCircle(){
        String methodName="getAllCircle() :";
        logger.info(methodName+" Called");
        ResponseEntity<?> responseEntity = null;
        List<?extends CircleInterface> circleInterfaces= null;

        circleInterfaces = circleServices.getAll();

        if(circleInterfaces !=null){

            if(circleInterfaces.size()>0){
                responseEntity = new ResponseEntity<>(circleInterfaces, HttpStatus.OK);
            }else{
                responseEntity = new ResponseEntity<>("No Content",HttpStatus.NO_CONTENT);

            }

        }

        return  responseEntity;
    }
	


}
