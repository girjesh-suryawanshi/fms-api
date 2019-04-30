package com.mpcz.fmsapi.dto;

import com.mpcz.fmsentity.bean.Feeder;
import com.mpcz.fmsentity.bean.Substation;

public class FeederDTO extends Feeder{

	private Substation substation;

	public Substation getSubstation() {
		return substation;
	}

	public void setSubstation(Substation substation) {
		this.substation = substation;
	}
	
	

	
	
}
