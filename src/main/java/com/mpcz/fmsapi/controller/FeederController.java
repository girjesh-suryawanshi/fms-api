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

import com.mpcz.fmsapi.dto.FeederDTO;
import com.mpcz.fmsapi.services.FeederService;
import com.mpcz.fmsapi.services.SubstationServices;
import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsentity.bean.Feeder;
import com.mpcz.fmsinterface.FeederInterface;

/**
 * @author Vikas Singh Nalwaya
 *
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/feeder")
public class FeederController {

	@Autowired
	FeederService feederService;

	private Logger logger = GlobalResources.getLogger(FeederController.class);

	@GetMapping(value = "/all")
	public ResponseEntity<?> getAll() {
		String methodName = "getAll() :";
		logger.info(methodName + " Called");
		ResponseEntity<?> responseEntity = null;
		List<FeederDTO> FeederDTOs = null;

		FeederDTOs = feederService.getAll();

		if (FeederDTOs != null) {

			if (FeederDTOs.size() > 0) {
				responseEntity = new ResponseEntity<>(FeederDTOs, HttpStatus.OK);
			} else {
				responseEntity = new ResponseEntity<>("No Content", HttpStatus.NO_CONTENT);

			}

		}

		return responseEntity;
	}

	@PostMapping(value = "/save")
	public ResponseEntity<?> saveFeeder(@RequestBody Feeder feeder) {

		String methodName = "saveFeeder() :";
		logger.info(methodName + " Called");
		ResponseEntity<?> response = null;
		FeederInterface feederInterface;
		if (feeder != null) {
			feederInterface = feederService.saveFeeder(feeder);
			if (feederInterface != null) {
				response = new ResponseEntity<>(feederInterface, HttpStatus.CREATED);
				return response;
			}
		}
		response = new ResponseEntity<>("Unable to insert", HttpStatus.EXPECTATION_FAILED);
		return response;
	}

	@PostMapping(value = "/update")
	public ResponseEntity<?> updateFeeder(@RequestBody Feeder feederInterface) {
		String methodName = "updateFeeder() :";
		logger.info(methodName + " Called");
		ResponseEntity<?> response = null;
		FeederInterface feederInterfaceDB;
		if (feederInterface != null) {
			try {

				feederInterfaceDB = feederService.updateFeeder(feederInterface);
				if (feederInterfaceDB != null) {
					response = new ResponseEntity<>(feederInterfaceDB, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>("Unable to update", HttpStatus.EXPECTATION_FAILED);

				}
			} catch (Exception e) {
				response = new ResponseEntity<>("Unable to update " + e.getMessage(), HttpStatus.EXPECTATION_FAILED);
				return response;
			}
		} else {
			response = new ResponseEntity<>("Unable to update ", HttpStatus.EXPECTATION_FAILED);

		}

		return response;

	}

	@PostMapping(value = "/delete")
	public ResponseEntity<?> deleteFeeder(@RequestBody Feeder feederInterface) {
		String methodName = "deleteFeeder() :";
		logger.info(methodName + " Called");
		ResponseEntity<?> response = null;
		FeederInterface feederInterfaceDB;
		if (feederInterface != null) {
			try {

				feederInterfaceDB = feederService.deleteFeeder(feederInterface);
				if (feederInterfaceDB != null) {
					response = new ResponseEntity<>(feederInterfaceDB, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>("Unable to update", HttpStatus.EXPECTATION_FAILED);

				}
			} catch (Exception e) {
				response = new ResponseEntity<>("Unable to update " + e.getMessage(), HttpStatus.EXPECTATION_FAILED);
				return response;
			}
		} else {
			response = new ResponseEntity<>("Unable to update ", HttpStatus.EXPECTATION_FAILED);

		}

		return response;

	}

}
