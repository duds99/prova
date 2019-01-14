package com.castgroup.prova.service;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.castgroup.prova.dao.PessoaDao;
import com.castgroup.prova.model.Pessoa;

@RunWith(SpringJUnit4ClassRunner.class)
public class PessoaServiceImplTest {
	
	@Mock
	private PessoaDao pessoaDao;

	private PessoaServiceImpl pessoaServiceImpl = new PessoaServiceImpl();
	
	@Test
	public void getPeopleByNome_withouNome_shouldReturnEmptyList() {
		List<Pessoa> pessoas = pessoaServiceImpl.getPeopleByNome("");
		
		org.junit.Assert.assertThat(pessoas, CoreMatchers.equalTo(new ArrayList<Pessoa>()));
	}
}
