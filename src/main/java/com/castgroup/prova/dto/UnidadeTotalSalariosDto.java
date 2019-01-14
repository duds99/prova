package com.castgroup.prova.dto;

import com.castgroup.prova.model.Unidade;

public class UnidadeTotalSalariosDto {

	private String uniNome;
	
	private Double totalSalario;
	
	public String getUniNome() {
		return uniNome;
	}

	public void setUniNome(String uniNome) {
		this.uniNome = uniNome;
	}

	public Double getTotalSalario() {
		return totalSalario;
	}

	public void setTotalSalario(Double total) {
		this.totalSalario = total;
	}

	public void tranformaEmDto(Unidade unidade) {
		this.uniNome = unidade.getUniNome();
		this.totalSalario = unidade.getSalarios();
	}
}
