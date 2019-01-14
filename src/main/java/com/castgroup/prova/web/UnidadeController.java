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

import com.castgroup.prova.dto.UnidadeRelatorioDto;
import com.castgroup.prova.dto.UnidadeTotalPessoasDto;
import com.castgroup.prova.dto.UnidadeTotalSalariosDto;
import com.castgroup.prova.model.Unidade;
import com.castgroup.prova.service.UnidadeService;

@RestController
@RequestMapping(value = "/unidade", produces = "application/json")
public class UnidadeController {

	@Autowired
	private UnidadeService unidadeService;
	
	@PostMapping
	public ResponseEntity<Unidade> saveUnity(@Validated @RequestBody Unidade unidade, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Unidade>(HttpStatus.BAD_REQUEST);
		}
		
		unidadeService.saveUnity(unidade);
		
		return new ResponseEntity<Unidade>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}/pessoa")
	public ResponseEntity<UnidadeTotalPessoasDto> getUnityWithTotalPeople(@PathVariable String id){
		if(id.isEmpty()) {
			return new ResponseEntity<UnidadeTotalPessoasDto>(HttpStatus.BAD_REQUEST);
		}
		
		Unidade unidade = unidadeService.getUnityWithTotalPeople(Integer.parseInt(id));
		
		if(unidade == null) {
			return new ResponseEntity<UnidadeTotalPessoasDto>(HttpStatus.NOT_FOUND);
		}
		
		UnidadeTotalPessoasDto unidadeTotalPessoasDto = new UnidadeTotalPessoasDto();
		unidadeTotalPessoasDto.tranformaEmDto(unidade);
		
		return new ResponseEntity<UnidadeTotalPessoasDto>(unidadeTotalPessoasDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}/salario")
	public ResponseEntity<UnidadeTotalSalariosDto> getUnityWithTotalSalary(@PathVariable String id){
		if(id.isEmpty()) {
			return new ResponseEntity<UnidadeTotalSalariosDto>(HttpStatus.BAD_REQUEST);
		}
		
		Unidade unidade = unidadeService.getUnityWithTotalSalary(Integer.parseInt(id));
		
		if(unidade == null) {
			return new ResponseEntity<UnidadeTotalSalariosDto>(HttpStatus.NOT_FOUND);
		}
		
		UnidadeTotalSalariosDto unidadeTotalSalariosDto = new UnidadeTotalSalariosDto();
		unidadeTotalSalariosDto.tranformaEmDto(unidade);
		
		return new ResponseEntity<UnidadeTotalSalariosDto>(unidadeTotalSalariosDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/relatorio")
	public ResponseEntity<List<UnidadeRelatorioDto>> getUnitysForRelatory(){		
		List<Unidade> unidades = unidadeService.getUnitysForRelatory();
		
		if(unidades == null || unidades.isEmpty()) {
			return new ResponseEntity<List<UnidadeRelatorioDto>>(HttpStatus.NOT_FOUND);
		}
		
		List<UnidadeRelatorioDto> unidadeRelatorioDtos = new ArrayList<UnidadeRelatorioDto>();
		
		for(Unidade unidade : unidades) {
			UnidadeRelatorioDto unidadeRelatorioDto = new UnidadeRelatorioDto();
			unidadeRelatorioDto.tranformaEmDto(unidade);
			unidadeRelatorioDtos.add(unidadeRelatorioDto);
		}
		
		return new ResponseEntity<List<UnidadeRelatorioDto>>(unidadeRelatorioDtos, HttpStatus.OK);
	}
	
}
