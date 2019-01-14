package com.castgroup.prova.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pesId;

	@NotNull
	private String pesNome;
	
	@NotNull
	private Double salario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Unidade unidade;
	
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

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

}
