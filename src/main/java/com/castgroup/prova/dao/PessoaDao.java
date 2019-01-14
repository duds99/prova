package com.castgroup.prova.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.castgroup.prova.model.Pessoa;

@Repository
public interface PessoaDao extends JpaRepository<Pessoa, Long>{

	List<Pessoa> findAll();

	@Query("SELECT p FROM Pessoa p WHERE p.pesNome LIKE %:nome%")
	List<Pessoa> findByPesNome(@Param("nome") String nome);
	
	Pessoa findByPesId(Integer id);
}