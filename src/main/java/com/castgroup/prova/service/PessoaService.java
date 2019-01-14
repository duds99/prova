package com.castgroup.prova.service;

import java.util.List;

import com.castgroup.prova.model.Pessoa;

public interface PessoaService {

	List<Pessoa> getAllPeople();
	
	List<Pessoa> getPeopleByNome(String nome);
	
	Pessoa savePerson(Pessoa pessoa);
}
