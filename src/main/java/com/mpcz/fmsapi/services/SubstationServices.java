package com.mpcz.fmsapi.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpcz.fmsapi.dto.SubstationDTO;
import com.mpcz.fmsapi.dto.SubstationFeederDTO;
import com.mpcz.fmsapi.utility.GlobalResources;
import com.mpcz.fmsapi.utility.StatusEnum;
import com.mpcz.fmsdao.dao.SubstationDAO;
import com.mpcz.fmsentity.bean.Substation;
import com.mpcz.fmsentity.bean.SubstationFeeder;
import com.mpcz.fmsinterface.SubstationFeederInterface;
import com.mpcz.fmsinterface.SubstationInterface;

@Service
public class SubstationServices {
	@Autowired
	SubstationDAO substationDAO;
	@Autowired
	SubstationFeederService substationFeederService;
	@Autowired ZoneServices zoneServices;
	
	private Logger logger = GlobalResources.getLogger(SubstationServices.class);
	
	public SubstationInterface getSubstation(Long id)
	{
String methodName=	" Substation Service getSubstation() :"	;
logger.info("Called :"+methodName);
		SubstationInterface substation=null;
		if(id!=null)
		{
			substation = substationDAO.getSubstation(id);
		}
		return substation;
	}
	  public List<SubstationDTO> getAll() {
		  String methodName=	" Substation Service getAll() :"	;
		  logger.info("Called :"+methodName);
	        System.out.println("Inside SubstationServicesr Service");

	        List<? extends SubstationInterface> substationInterfaces = null;
	        List<SubstationDTO> substationDTOs=new ArrayList();
	        substationInterfaces = substationDAO.getAll(StatusEnum.ENABLE.getValue());

	        if (substationInterfaces != null) {
	            if (substationInterfaces.size() > 0) {
	            	
	            	for (SubstationInterface sub : substationInterfaces)
	      		  {
	            		SubstationDTO sd = new SubstationDTO();
	            		sd.setSubstation((Substation) sub);
	            		sd.setZone(zoneServices.getZone(sub.getZoneId()));
	            		substationDTOs.add(sd);
	      		  }
	                return substationDTOs;
	            } else {
	                System.out.println("Error");
	            }
	        }
	        return substationDTOs;

	    }
	  public SubstationInterface insertSubstation(Substation substationInterface)
	  {
		  String methodName=	" Substation Service insertSubstation() :"	;
		  logger.info("Called :"+methodName);
		  SubstationInterface substationInterfaceDB=null;
		  substationInterface.setStatus(StatusEnum.ENABLE.getValue());
		  substationInterfaceDB= substationDAO.save(substationInterface); 
		  
		  return substationInterfaceDB;
	  }

	  
	  public Substation insertSubstation(SubstationFeederDTO substationFeederDTO)
	  {
		  String methodName=	" Substation Service insertSubstation() :"	;
		  logger.info("Called :"+methodName);
		  Substation substationInterfaceDB=null;
		  Substation substation=new Substation();
		  substation.setCreatedBy(substationFeederDTO.getCreatedBy());
		  substation.setCreatedOn(substationFeederDTO.getCreatedOn());
		  substation.setIncomingLines(substationFeederDTO.getIncomingLines());
		  substation.setPowerTransformer(substationFeederDTO.getPowerTransformer());
		  substation.setStatus(StatusEnum.ENABLE.getValue());
		  substation.setZoneId(substationFeederDTO.getZoneId());
		  substation.setSubstationName(substationFeederDTO.getSubstationName());
		  substation.setUpdatedBy(substationFeederDTO.getUpdatedBy());
		  substation.setUpdatedOn(substationFeederDTO.getUpdatedOn());
		  substationInterfaceDB= (Substation) substationDAO.save(substation); 
		  Iterable<SubstationFeeder> subs=substationFeederDTO.getSubstationFeederInterface();
		 
		  for (SubstationFeederInterface sub : subs)
		  {
			  sub.setSubstationId(substationInterfaceDB.getId());
		  }
			   
		  substationFeederService.saveAllSubstationFeeder(subs);
		  return substationInterfaceDB;
	  }
	public SubstationInterface deleteSubstation(Substation substationInterface) {
		SubstationInterface substationInterfaceDB=null;
		SubstationInterface substationDB = getSubstation(substationInterface.getId());
    	substationDB.setStatus(StatusEnum.DISABLE.getValue());

    	substationInterfaceDB=substationDAO.save((Substation) substationDB);
		
		return substationInterfaceDB;
	}
	public SubstationInterface updateSubstation(Substation substationInterface) {
		SubstationInterface substationInterfaceDB=null;
	
		Substation substationDB = (Substation) substationDAO.getSubstation(substationInterface.getId());
    	if(substationDB!=null)
    	{
    		logger.info("Data Found from id "+substationInterface.getId());
    	substationDB.setStatus(StatusEnum.ENABLE.getValue());
    	if(substationInterface.getCreatedBy()!=null)
    	substationDB.setCreatedBy(substationInterface.getCreatedBy());
    	
    	if(substationInterface.getUpdatedBy()!=null)
    	substationDB.setUpdatedBy(substationInterface.getUpdatedBy());
    	
    	if(substationInterface.getSubstationName()!=null)
    	substationDB.setSubstationName(substationInterface.getSubstationName());
    	
    	if(substationInterface.getSubstationCode()!=null)
    	substationDB.setSubstationCode(substationInterface.getSubstationCode());
    	
    	
    	substationInterfaceDB=substationDAO.save(substationDB);
    	}
    	else
    	{
    		logger.info("Data Not Found from id "+substationInterface.getId());
    	}
		return substationInterfaceDB;
	}

}
