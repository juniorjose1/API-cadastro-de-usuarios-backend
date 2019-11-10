package com.alexandre.crudapi.dto;

public class PessoaEstatisticaGrupo {
	
	private String grupo;
	
	private long total;

	public PessoaEstatisticaGrupo(String grupo, long total) {
		this.grupo = grupo;
		this.total = total;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	

}
