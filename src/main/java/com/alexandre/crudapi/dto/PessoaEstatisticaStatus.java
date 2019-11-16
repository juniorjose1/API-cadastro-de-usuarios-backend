package com.alexandre.crudapi.dto;

public class PessoaEstatisticaStatus {
	
	private String status;
	
	private long total;
	
	public PessoaEstatisticaStatus(String status, long total) {
		this.status = status;
		this.total = total;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getTotal() {
		return total;
	}
	
	public void setTotal(long total) {
		this.total = total;
	}

}
