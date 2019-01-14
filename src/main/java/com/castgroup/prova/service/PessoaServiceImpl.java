package com.castgroup.prova.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castgroup.prova.dao.PessoaDao;
import com.castgroup.prova.dao.UnidadeDao;
import com.castgroup.prova.model.Pessoa;
import com.castgroup.prova.model.Unidade;

@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaDao pessoaDao;
	
	@Autowired
	private UnidadeDao unidadeDao;
	
	@Override
	public List<Pessoa> getAllPeople() {
		return pessoaDao.findAll();
	}

	@Override
	public List<Pessoa> getPeopleByNome(String nome) {
		if(nome.isEmpty()) {
			return new ArrayList<>();
		}
		
		return pessoaDao.findByPesNome(nome);
	}

	@Override
	public Pessoa savePerson(Pessoa pessoa) {
		if(pessoa.getUnidade() != null) {
			Unidade unidade = unidadeDao.findByUniId(pessoa.getUnidade().getUniId());
			
			if(unidade.getPessoas() == null || unidade.getSalarios() == null) {
				unidade.setTotalPessoas(1);
				unidade.setSalarios(pessoa.getSalario());
			} else {
				unidade.setSalarios(unidade.getSalarios() + pessoa.getSalario());
				unidade.setTotalPessoas(unidade.getTotalPessoas() + 1);
			}
			unidadeDao.save(unidade);
		}
		
		pessoaDao.save(pessoa);
		return pessoa;
	}

}
