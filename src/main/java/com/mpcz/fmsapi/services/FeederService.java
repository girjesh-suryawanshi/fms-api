package com.mpcz.fmsapi.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpcz.fmsapi.controller.LocationController;
import com.mpcz.fmsapi.dto.FeederDTO;
import com.mpcz.fmsapi.dto.SubstationDTO;
import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsapi.utility.StatusEnum;
import com.mpcz.fmsdao.dao.FeederDAO;
import com.mpcz.fmsentity.bean.Feeder;
import com.mpcz.fmsentity.bean.Substation;
import com.mpcz.fmsinterface.FeederInterface;
import com.mpcz.fmsinterface.SubstationInterface;

@Service
public class FeederService {
	private Logger logger = GlobalResources.getLogger(FeederService.class);

	@Autowired
	FeederDAO feederDAO;
	@Autowired
	SubstationServices substationServices;

	public FeederInterface saveFeeder(Feeder feederInterface) {

		String methodName = "getAll() :";
		logger.info(methodName + " Called");
		FeederInterface feederInterfaceDB = null;
		if (feederInterface != null) {
			feederInterface.setStatus(StatusEnum.ENABLE.getValue());
			feederInterfaceDB = feederDAO.save(feederInterface);
		}
		return feederInterfaceDB;
	}

	public Feeder getFeeder(Long id) {

		String methodName = "getFeeder() :";
		logger.info(methodName + " Called");
		FeederInterface feederInterfaceDB = null;
		if (id != null) {
			feederInterfaceDB = feederDAO.getFeeder("ENABLE", id);
			if (feederInterfaceDB != null) {
				return (Feeder) feederInterfaceDB;
			}
		}
		return null;
	}

	public List<FeederDTO> getAll() {
		String methodName = "getAll() :";
		logger.info(methodName + " Called");

		List<? extends FeederInterface> feederInterfaces = null;
		List<FeederDTO> FeederDTOs = new ArrayList();
		feederInterfaces = feederDAO.getAll(StatusEnum.ENABLE.getValue());

		if (feederInterfaces != null) {
			if (feederInterfaces.size() > 0) {

				for (FeederInterface fdr : feederInterfaces) {
					FeederDTO fd = new FeederDTO();
					fd.setSubstation((Substation) substationServices.getSubstation(fdr.getSubstationId()));
					fd.setCreatedBy(fdr.getCreatedBy());
					fd.setCreatedOn(fdr.getCreatedOn());
					fd.setFeederName(fdr.getFeederName());
					fd.setFeederType(fdr.getFeederType());
					fd.setStatus(fdr.getStatus());
					fd.setUpdatedBy(fdr.getUpdatedBy());
					fd.setUpdatedOn(fdr.getUpdatedOn());
					fd.setSubstationId(fdr.getSubstationId());
					fd.setId(fdr.getId());

					FeederDTOs.add(fd);
				}
				return FeederDTOs;
			} else {
				System.out.println("Error");
			}
		}
		return FeederDTOs;

	}

	public FeederInterface updateFeeder(Feeder feederInterface) {
		String methodName = "updateFeeder() :";
		logger.info(methodName + " Called");
		FeederInterface feederInterfaceDB = null;
		Feeder feederDB = (Feeder) getFeeder(feederInterface.getId());
		if (feederDB != null) {

			logger.info("Feeder Found to update form id " + feederInterface.getId());
			feederDB.setStatus(StatusEnum.ENABLE.getValue());
			if (feederInterface.getCreatedBy() != null)
				feederDB.setCreatedBy(feederInterface.getCreatedBy());

			if (feederInterface.getUpdatedBy() != null)
				feederDB.setUpdatedBy(feederInterface.getUpdatedBy());

			if (feederInterface.getFeederName() != null)
				feederDB.setFeederName(feederInterface.getFeederName());

			if (feederInterface.getFeederType() != null)
				feederDB.setFeederType(feederInterface.getFeederType());

			if (feederInterface.getCreatedOn() != null)
				feederDB.setCreatedOn(feederInterface.getCreatedOn());

			feederInterfaceDB = feederDAO.save(feederDB);
		} else {
			logger.info("Feeder Not Found to update form id " + feederInterface.getId());
		}
		return feederInterfaceDB;
	}

	public FeederInterface deleteFeeder(Feeder feederInterface) {
		String methodName = "deleteFeeder() :";
		logger.info(methodName + " Called");

		FeederInterface feederInterfaceDB = null;
		Feeder feederDB = (Feeder) getFeeder(feederInterface.getId());
		if (feederDB != null) {
			logger.info("Feeder  Found to delete form id " + feederInterface.getId());
			feederDB.setStatus("DISABLE");
			feederInterfaceDB = feederDAO.save(feederDB);
		} else {
			logger.info("Feeder Not Found to delete form id " + feederInterface.getId());
		}
		return feederInterfaceDB;
	}

}
