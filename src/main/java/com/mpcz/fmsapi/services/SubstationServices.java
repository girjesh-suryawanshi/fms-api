package com.mpcz.fmsapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpcz.fmsapi.utility.SubstationFeederDTO;
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
	
	  public List<? extends SubstationInterface> getAll() {
	        System.out.println("Inside SubstationServicesr Service");

	        List<? extends SubstationInterface> substationInterfaces = null;

	        substationInterfaces = substationDAO.getAll();

	        if (substationInterfaces != null) {
	            if (substationInterfaces.size() > 0) {
	                return substationInterfaces;
	            } else {
	                System.out.println("Error");
	            }
	        }
	        return substationInterfaces;

	    }
	  public SubstationInterface insertSubstation(Substation substationInterface)
	  {
		  SubstationInterface substationInterfaceDB=null;
		  substationInterfaceDB= substationDAO.save(substationInterface); 
		  
		  return substationInterfaceDB;
	  }

	  
	  public Substation insertSubstation(SubstationFeederDTO substationFeederDTO)
	  {
		  Substation substationInterfaceDB=null;
		  substationInterfaceDB= (Substation) substationDAO.save(substationFeederDTO.getSubstationInterface()); 
		  Iterable<SubstationFeeder> subs=substationFeederDTO.getSubstationFeederInterface();
//		  subs.forEach(name -> item);
		 
		  for (SubstationFeederInterface sub : subs)
		  {
			  sub.setSubstationId(substationInterfaceDB.getId());
		  }
			   
		  substationFeederService.saveAllSubstationFeeder(subs);
		  return substationInterfaceDB;
	  }

	  //

	public List<? extends SubstationInterface> getAllSub() {
		String methodName = "findAll()  :";
		//logger.error(methodName + "Called");

		List<? extends SubstationInterface> substationInterfaces = null;

		substationInterfaces = substationDAO.getAll();

		if (substationInterfaces != null) {
			if (substationInterfaces.size() > 0) {
				return substationInterfaces;
			} else {
				System.out.println("Error...!");
			}
		}
		return substationInterfaces;

	}

	public void deleteById(Long Id) {
		String methodName = "deleteById()";
		//logger.info(methodName + "called");
		substationDAO.deleteByID(Id);
	}

}
