package com.castgroup.prova.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.castgroup.prova.model.Unidade;

@Repository
public interface UnidadeDao extends JpaRepository<Unidade, Long>{

	List<Unidade> findAll();
	
	Unidade findByUniId(Integer id);
}
