package com.castgroup.prova.dto;

import com.castgroup.prova.model.Unidade;

public class UnidadeRelatorioDto {

	private Integer uniId;
	
	private String uniNome;
	
	private Integer totalPessoas;
	
	private Double totalSalario;
	
	public Integer getUniId() {
		return uniId;
	}

	public void setUniId(Integer uniId) {
		this.uniId = uniId;
	}

	public Integer getTotalPessoas() {
		return totalPessoas;
	}

	public void setTotalPessoas(Integer totalPessoas) {
		this.totalPessoas = totalPessoas;
	}

	public Double getTotalSalario() {
		return totalSalario;
	}

	public void setTotalSalario(Double totalSalario) {
		this.totalSalario = totalSalario;
	}

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
		this.uniId = unidade.getUniId();
		this.totalSalario = unidade.getSalarios();
	}
}
