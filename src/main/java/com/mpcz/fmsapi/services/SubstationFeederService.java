package com.mpcz.fmsapi.services;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpcz.fmsdao.dao.SubstationFeederDAO;
import com.mpcz.fmsdao.repository.SubstationFeederRepository;
import com.mpcz.fmsdao.utility.GlobalResources;
import com.mpcz.fmsentity.bean.SubstationFeeder;
import com.mpcz.fmsinterface.SubstationFeederInterface;

@Service
public class SubstationFeederService {
	
	 private static Logger logger = GlobalResources.getLogger(SubstationFeederDAO.class);

	    @Autowired
	    SubstationFeederDAO substationFeederDAO;

	    
	    public SubstationFeederInterface save(SubstationFeederInterface substationFeederInterface)
	    {
	    	String methodName="save Substation Feeder() :";
	        logger.info(methodName+" Called");
	    	SubstationFeederInterface substationFeederInterfaceDB=null;
	    	if(substationFeederInterface!=null)
	    	{
	    		substationFeederInterfaceDB=substationFeederDAO.save(substationFeederInterface);
	    	}
	    	return substationFeederInterfaceDB;
	    }
	    
	    public List<? extends SubstationFeederInterface> getAll(){
	    	String methodName="In Sustation Feeder getAll() :";
	        logger.info(methodName+" Called");
	    	List<? extends SubstationFeederInterface>substationInterfaces = substationFeederDAO.getAll();

	        return substationInterfaces;
	     } 
	   
	  public List<? extends SubstationFeederInterface> getAllBySubstationId(Long substationId)
	   {
		  String methodName="In Sustation Feeder getAllBySubstationId() :";
	        logger.info(methodName+" Called");
		   List<? extends SubstationFeederInterface>substationInterfaces =substationFeederDAO.getAllBySubstationId(substationId);
	  
	   return substationInterfaces;
	   }
	  
	  public List<? extends SubstationFeederInterface>  saveAllSubstationFeeder(Iterable<SubstationFeeder> entities){
		  String methodName="In Sustation Feeder saveAllSubstationFeeder() :";
	        logger.info(methodName+" Called");
		  List<? extends SubstationFeederInterface>substationInterfaces =substationFeederDAO.saveAllSubstationFeeder(entities);
		  return substationInterfaces;
	  }


}
