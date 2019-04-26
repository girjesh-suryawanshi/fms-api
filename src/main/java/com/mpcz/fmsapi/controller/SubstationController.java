package com.mpcz.fmsapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mpcz.fmsapi.services.SubstationServices;
import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsapi.utility.SubstationFeederDTO;
import com.mpcz.fmsentity.bean.Substation;
import com.mpcz.fmsinterface.SubstationFeederInterface;
import com.mpcz.fmsinterface.SubstationInterface;

@Controller

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value ="/substation")

public class SubstationController {
	private Logger logger = GlobalResources.getLogger(SubstationController.class);

	@Autowired
	SubstationServices substationServices;
	
	
	
	@GetMapping(value = "/all")
    public ResponseEntity<?>getAll(){
        String methodName="getAll() :";
        logger.info(methodName+" Called");
        ResponseEntity<?> responseEntity = null;
        List<?extends SubstationInterface> substationInterfaces= null;

        substationInterfaces = substationServices.getAll();

        if(substationInterfaces !=null){

            if(substationInterfaces.size()>0){
                responseEntity = new ResponseEntity<>(substationInterfaces, HttpStatus.OK);
            }else{
                responseEntity = new ResponseEntity<>("No Content",HttpStatus.NO_CONTENT);

            }

        }

        return  responseEntity;
    }

	@PostMapping(value = "/save")
	public ResponseEntity<?> insertSubstation(@RequestBody Substation substationInterface)
	{
		String methodName="postMaster() :";
        logger.info(methodName+" Called");
        ResponseEntity<?> response = null;
        SubstationInterface substationInterfaceDB;
        if(substationInterface != null)
        {
        	substationInterfaceDB=substationServices.insertSubstation(substationInterface);
            if(substationInterfaceDB !=null)
            {
                response = new ResponseEntity<>(substationInterfaceDB,HttpStatus.CREATED);
            }
            else
            {
                response = new ResponseEntity<>("Unable to insert",HttpStatus.EXPECTATION_FAILED);

            }
        }
        else
        {
            response = new ResponseEntity<>("substationInterfaceDB is null ",HttpStatus.EXPECTATION_FAILED);

        }
        return response;
	}
	
	
	@PostMapping(value = "/save_substation")
	public ResponseEntity<?> insertSubstationWithFeeder(@RequestBody SubstationFeederDTO substationFeederDTO)
	{
		String methodName="insertSubstationWithFeeder() :";
        logger.info(methodName+" Called");
        ResponseEntity<?> response = null;
        Substation substationInterfaceDB=null;
        if(substationFeederDTO != null)
        {
        	substationInterfaceDB=   substationServices.insertSubstation(substationFeederDTO);
            if(substationInterfaceDB !=null)
            {
                response = new ResponseEntity<>(substationInterfaceDB,HttpStatus.CREATED);
            }
            else
            {
                response = new ResponseEntity<>("Unable to insert",HttpStatus.EXPECTATION_FAILED);

            }
        }
        else
        {
            response = new ResponseEntity<>("substationInterfaceDB is null ",HttpStatus.EXPECTATION_FAILED);

        }
        return response;
	}

}
