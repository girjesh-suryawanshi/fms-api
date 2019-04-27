package com.mpcz.fmsapi.controller;

import com.mpcz.fmsapi.services.FeederServices;
import com.mpcz.fmsdao.utility.GlobalResources;
import com.mpcz.fmsentity.bean.Feeder;
import com.mpcz.fmsinterface.FeederInterface;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/feeder")
public class FeederController {

    private Logger logger = GlobalResources.getLogger(FeederController.class);

    @Autowired
    FeederServices feederServices;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> postFeeder(@RequestBody Feeder feeder) {
        String methodName = "postFeeder() ";
        logger.info(methodName + "called");
        logger.info(methodName + feeder);
        ResponseEntity<?> response = null;
        FeederInterface feederInterface1 = null;
        if (feeder != null) {
            feederInterface1 = feederServices.insert(feeder);

            if (feederInterface1 != null) {
                response = new ResponseEntity<>(feederInterface1, HttpStatus.OK);
            } else {
                response = new ResponseEntity<>("Unable to insert feeder", HttpStatus.EXPECTATION_FAILED);
            }

        } else {
            response = new ResponseEntity<>("Feeder is null", HttpStatus.BAD_REQUEST);
        }

        return response;

    }
}
