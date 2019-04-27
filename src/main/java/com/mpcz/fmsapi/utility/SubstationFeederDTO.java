package com.mpcz.fmsapi.utility;

import java.util.List;

import com.mpcz.fmsentity.bean.Substation;
import com.mpcz.fmsentity.bean.SubstationFeeder;

public class SubstationFeederDTO {
	
	private Substation substationInterface;
	
	private List<SubstationFeeder> substationFeederInterface;

	

	public Substation getSubstationInterface() {
		return substationInterface;
	}

	public void setSubstationInterface(Substation substationInterface) {
		this.substationInterface = substationInterface;
	}

	public List<SubstationFeeder> getSubstationFeederInterface() {
		return substationFeederInterface;
	}

	public void setSubstationFeederInterface(List<SubstationFeeder> substationFeederInterface) {
		this.substationFeederInterface = substationFeederInterface;
	}

	
	
	
	

}
