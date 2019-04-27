package com.mpcz.fmsapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpcz.fmsdao.dao.ZoneDAO;
import com.mpcz.fmsinterface.ZoneInterface;

@Service
public class ZoneServices {
	@Autowired
	ZoneDAO zoneDAO;
	
	  public List<? extends ZoneInterface> getAll() {
	        System.out.println("Inside Bank master Service");

	        List<? extends ZoneInterface> zoneInterfaces = null;

	        zoneInterfaces = zoneDAO.getAll();

	        if (zoneInterfaces != null) {
	            if (zoneInterfaces.size() > 0) {
	                return zoneInterfaces;
	            } else {
	                System.out.println("Error");
	            }
	        }
	        return zoneInterfaces;

	    }
	

}
