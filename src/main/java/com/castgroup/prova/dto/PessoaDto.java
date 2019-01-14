package com.castgroup.prova.dto;

import com.castgroup.prova.model.Pessoa;

public class PessoaDto {

	private Integer pesId;

	private String pesNome;
	
	private Double salario;
	
	public Integer getPesId() {
		return pesId;
	}

	public void setPesId(Integer pesId) {
		this.pesId = pesId;
	}

	public String getpesNome() {
		return pesNome;
	}

	public void setpesNome(String pesNome) {
		this.pesNome = pesNome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public void transformaEmDto(Pessoa pessoa) {
		this.pesId = pessoa.getPesId();
		this.pesNome = pessoa.getpesNome();
		this.salario = pessoa.getSalario();
	}
}
