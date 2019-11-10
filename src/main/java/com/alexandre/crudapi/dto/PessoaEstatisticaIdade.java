package com.alexandre.crudapi.dto;

import java.math.BigDecimal;

import com.alexandre.crudapi.model.Pessoa;

public class PessoaEstatisticaIdade {
	
	private String idade;
	
	private long total;
	

	public PessoaEstatisticaIdade(String idade, long total) {
		this.idade = idade;
		this.total = total;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	

}
