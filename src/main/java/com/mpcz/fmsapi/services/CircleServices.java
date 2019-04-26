package com.mpcz.fmsapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpcz.fmsdao.dao.CircleDAO;
import com.mpcz.fmsinterface.CircleInterface;

@Service
public class CircleServices {
	
	@Autowired
	CircleDAO circleDAO;
	
	  public List<? extends CircleInterface> getAll() {
	        System.out.println("Inside Bank master Service");

	        List<? extends CircleInterface> circleInterfaces = null;

	        circleInterfaces = circleDAO.getAll();

	        if (circleInterfaces != null) {
	            if (circleInterfaces.size() > 0) {
	                return circleInterfaces;
	            } else {
	                System.out.println("Error");
	            }
	        }
	        return circleInterfaces;

	    }

}
