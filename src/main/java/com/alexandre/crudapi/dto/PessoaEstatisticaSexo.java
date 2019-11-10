package com.alexandre.crudapi.dto;

import java.math.BigDecimal;

import com.alexandre.crudapi.model.Pessoa;

public class PessoaEstatisticaSexo {

	private String sexo;
	
	private long total;
	
	public PessoaEstatisticaSexo(String sexo, long total) {
		this.sexo = sexo;
		this.total = total;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	

}
