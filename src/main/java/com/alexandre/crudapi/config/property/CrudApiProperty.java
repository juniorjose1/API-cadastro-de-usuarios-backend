package com.alexandre.crudapi.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("crud")
public class CrudApiProperty {
	
	private String originPermitida = "http://localhost:8000";
	
	
	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}
	
	

}