package com.mpcz.fmsapi.utility;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {
	ENABLE("ENABLE" ), DISABLE("DISABLE");

	private final String value;
	
	
	private static final Map<String, StatusEnum> ENUM_MAP = new HashMap<>();

	private StatusEnum(String value) {
		this.value = value;
		
	}

	public String getValue() {
		return value;
	}


	static {
		for (StatusEnum instance : StatusEnum.values()) {
			ENUM_MAP.put(instance.getValue(), instance);
		}
	}
}
