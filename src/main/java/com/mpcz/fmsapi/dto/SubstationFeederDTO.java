package com.mpcz.fmsapi.dto;

import java.io.Serializable;
import java.util.List;

import com.mpcz.fmsentity.bean.Substation;
import com.mpcz.fmsentity.bean.SubstationFeeder;

public class SubstationFeederDTO extends Substation implements Serializable{
	
	
	private List<SubstationFeeder> substationFeederInterface;

	

	
	public List<SubstationFeeder> getSubstationFeederInterface() {
		return substationFeederInterface;
	}

	public void setSubstationFeederInterface(List<SubstationFeeder> substationFeederInterface) {
		this.substationFeederInterface = substationFeederInterface;
	}

	
	
	
	

}
