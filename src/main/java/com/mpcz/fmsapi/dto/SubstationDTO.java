package com.mpcz.fmsapi.dto;

import com.mpcz.fmsentity.bean.Substation;
import com.mpcz.fmsentity.bean.Zone;

public class SubstationDTO {
	
	private Zone zone;
private Substation substation;
	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Substation getSubstation() {
		return substation;
	}

	public void setSubstation(Substation substation) {
		this.substation = substation;
	}
	

}
