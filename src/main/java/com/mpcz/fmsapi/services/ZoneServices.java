package com.mpcz.fmsapi.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsdao.dao.ZoneDAO;
import com.mpcz.fmsentity.bean.Zone;
import com.mpcz.fmsinterface.ZoneInterface;

@Service
public class ZoneServices {
	@Autowired
	ZoneDAO zoneDAO;
	private Logger logger = GlobalResources.getLogger(ZoneServices.class);

	public List<? extends ZoneInterface> getAll() {
		System.out.println("Inside Bank master Service");
		String methodName = " Zone Service getAll() :";
		logger.info("Called :" + methodName);
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

	public Zone getZone(long id) {
		String methodName = " Zone Service getZone() :";
		logger.info("Called :" + methodName);
		Zone zone = null;
		zone = zoneDAO.getZone(id);
		return zone;
	}

}
