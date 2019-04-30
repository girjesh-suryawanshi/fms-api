package com.mpcz.fmsapi.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpcz.fmsapi.dto.FeederDTO;
import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsapi.utility.StatusEnum;
import com.mpcz.fmsdao.dao.FeederDAO;
import com.mpcz.fmsentity.bean.Feeder;
import com.mpcz.fmsentity.bean.Substation;
import com.mpcz.fmsinterface.FeederInterface;

@Service
public class FeederServices {
	private Logger logger = GlobalResources.getLogger(FeederService.class);

	@Autowired
	FeederDAO feederDAO;
	@Autowired
	SubstationServices substationServices;	
	public FeederInterface saveFeeder(Feeder feederInterface)
	{
		
		 String methodName="getAll() :";
	        logger.info(methodName+" Called");
		FeederInterface feederInterfaceDB = null;
		if(feederInterface != null)
		{
			feederInterfaceDB = feederDAO.save(feederInterface);
		}
		return feederInterfaceDB;
	}

	public Feeder getFeeder(Long id) {

		 String methodName="getFeeder() :";
	        logger.info(methodName+" Called");
		FeederInterface feederInterfaceDB = null;
		if(id != null)
		{
			feederInterfaceDB = feederDAO.getFeeder("ENABLE", id);
			if(feederInterfaceDB != null)
			{
				return (Feeder) feederInterfaceDB;
			}
		}
		return null;
	}

	public List<FeederDTO> getAll() {
		String methodName="getAll() :";
        logger.info(methodName+" Called");

	        List<? extends FeederInterface> feederInterfaces = null;
	        List<FeederDTO> FeederDTOs=new ArrayList();
	        feederInterfaces = feederDAO.getAll(StatusEnum.ENABLE.getValue());

	        if (feederInterfaces != null) {
	            if (feederInterfaces.size() > 0) {
	            	
	            	for (FeederInterface fdr : feederInterfaces)
	      		  {
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

}
