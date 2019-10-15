package com.alexandre.crudapi.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("crud")
public class CrudApiProperty {
	
	private String originPermitida = "https://cadastro-de-usuarios-angular.herokuapp.com/";
	
	
	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}
	
	

}