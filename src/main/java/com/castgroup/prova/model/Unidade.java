package com.castgroup.prova.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Unidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uniId;
	
	@NotNull
	private String uniNome;
	
	@ManyToMany(mappedBy = "unidade", targetEntity = Pessoa.class, cascade = CascadeType.ALL)
	private List<Pessoa> pessoas;
	
	private Integer totalPessoas;
	
	private Double salarios;

	public Integer getUniId() {
		return uniId;
	}
	
	public String getUniNome() {
		return uniNome;
	}

	public void setUniNome(String uniNome) {
		this.uniNome = uniNome;
	}

	public void setSalarios(Double salarios) {
		this.salarios = salarios;
	}
	
	public Double getSalarios() {
		return salarios;
	}

	public void setUniId(Integer uniId) {
		this.uniId = uniId;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Integer getTotalPessoas() {
		return totalPessoas;
	}

	public void setTotalPessoas(Integer totalPessoas) {
		this.totalPessoas = totalPessoas;
	}
	
}
