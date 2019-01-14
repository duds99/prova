package com.castgroup.prova.service;

import java.util.List;

import com.castgroup.prova.model.Unidade;

public interface UnidadeService {

	Unidade saveUnity(Unidade unity);
	
	Unidade getUnityWithTotalPeople(Integer id);
	
	Unidade getUnityWithTotalSalary(Integer id);
	
	List<Unidade> getUnitysForRelatory();
}
