package com.castgroup.prova.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castgroup.prova.dto.PessoaDto;
import com.castgroup.prova.model.Pessoa;
import com.castgroup.prova.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoa", produces = "application/json")
public class PessoaController{

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<PessoaDto>> getAllPeople(){
		List<Pessoa> pessoas = pessoaService.getAllPeople();
		
		if(pessoas == null || pessoas.isEmpty()) {
			return new ResponseEntity<List<PessoaDto>>(new ArrayList<PessoaDto>(), HttpStatus.NOT_FOUND);
		}
		
		List<PessoaDto> pessoasDto = new ArrayList<PessoaDto>();
		
		for(Pessoa pessoa : pessoas) {
			PessoaDto pessoaDto = new PessoaDto();
			pessoaDto.transformaEmDto(pessoa);
			pessoasDto.add(pessoaDto);
		}
		
		return new ResponseEntity<List<PessoaDto>>(pessoasDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{nome}")
	public ResponseEntity<List<PessoaDto>> getPeopleByName(@PathVariable String nome){
		if(nome.isEmpty()) {
			return new ResponseEntity<List<PessoaDto>>(new ArrayList<PessoaDto>(), HttpStatus.BAD_REQUEST);
		}
		
		List<Pessoa> pessoas = pessoaService.getPeopleByNome(nome);
		
		if(pessoas == null || pessoas.isEmpty()) {
			return new ResponseEntity<List<PessoaDto>>(new ArrayList<PessoaDto>(), HttpStatus.NOT_FOUND);
		}
		
		List<PessoaDto> pessoasDto = new ArrayList<PessoaDto>();
		
		for(Pessoa pessoa : pessoas) {
			PessoaDto pessoaDto = new PessoaDto();
			pessoaDto.transformaEmDto(pessoa);
			pessoasDto.add(pessoaDto);
		}
		
		return new ResponseEntity<List<PessoaDto>>(pessoasDto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PessoaDto> savePerson(@Validated @RequestBody Pessoa pessoa, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<PessoaDto>(HttpStatus.BAD_REQUEST);
		}
		
		pessoaService.savePerson(pessoa);
		
		return new ResponseEntity<PessoaDto>(HttpStatus.CREATED);
	}
	
}
