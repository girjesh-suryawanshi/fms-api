package com.mpcz.fmsapi.services;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpcz.fmsapi.controller.LocationController;
import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsdao.dao.CircleDAO;
import com.mpcz.fmsinterface.CircleInterface;

@Service
public class CircleServices {

	@Autowired
	CircleDAO circleDAO;
	private Logger logger = GlobalResources.getLogger(CircleServices.class);

	public List<? extends CircleInterface> getAll() {
		String methodName = "getAll() :";
		logger.info(methodName + " Called");

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
