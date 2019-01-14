package com.castgroup.prova.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castgroup.prova.dao.UnidadeDao;
import com.castgroup.prova.model.Pessoa;
import com.castgroup.prova.model.Unidade;

@Service
@Transactional
public class UnidadeServiceImpl implements UnidadeService {

	@Autowired
	private UnidadeDao unidadeDao;
	
	@Override
	public Unidade saveUnity(Unidade unidade) {
		if(unidade.getPessoas() != null && !unidade.getPessoas().isEmpty()) {
			unidade.setTotalPessoas(unidade.getPessoas().size());
			
			Double salarioTotal = 0.0;
			for(Pessoa pessoa : unidade.getPessoas()) {
				salarioTotal += pessoa.getSalario();
				pessoa.setUnidade(unidade);
			}
			unidade.setSalarios(salarioTotal);
		}
		
		unidade = unidadeDao.save(unidade);
		
		return unidade;
	}

	@Override
	public Unidade getUnityWithTotalPeople(Integer id) {
		return unidadeDao.findByUniId(id);
	}

	@Override
	public Unidade getUnityWithTotalSalary(Integer id) {
		return unidadeDao.findByUniId(id);
	}

	@Override
	public List<Unidade> getUnitysForRelatory() {
		return unidadeDao.findAll();
	}

}
