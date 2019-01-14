package com.castgroup.prova.dto;

import com.castgroup.prova.model.Unidade;

public class UnidadeTotalPessoasDto {

	private String uniNome;
	
	private Integer totalPessoas;
	
	public String getUniNome() {
		return uniNome;
	}

	public void setUniNome(String uniNome) {
		this.uniNome = uniNome;
	}

	public Integer getTotal() {
		return totalPessoas;
	}

	public void setTotal(Integer total) {
		this.totalPessoas = total;
	}

	public void tranformaEmDto(Unidade unidade) {
		this.uniNome = unidade.getUniNome();
		this.totalPessoas = unidade.getTotalPessoas();
	}
}
