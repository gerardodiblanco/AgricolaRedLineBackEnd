package com.softdelsur.agricola.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.agricola.converter.AtributoConverter;
import com.softdelsur.agricola.model.AtributoModel;
import com.softdelsur.agricola.service.AtributoService;


@RestController
@RequestMapping("/atributo")
public class AtributoController {
	
	@Autowired
	@Qualifier("atributoServiceImpl")
	AtributoService atributoService;
	
	@Autowired
	@Qualifier("atributoConverter")
	AtributoConverter atributoConverter;
	
	
	@CrossOrigin
	@GetMapping("/allActivos")
	public List<AtributoModel> buscarAtributos(){
		return atributoConverter.convertListAtributoToListAtributoModel(atributoService.findAtributosActivos());
	}
	
	@CrossOrigin
	@PostMapping("/save")
	public AtributoModel addAtributo(@RequestBody AtributoModel atributoModel) {
		System.out.println(atributoModel.getNombreAtributo());
		
		return atributoConverter.convertAtributoToAtributoModel(
				atributoService.addAtributo(atributoConverter.convertAtributoMiodelToAtributo(atributoModel)));
		
	}
	
	@CrossOrigin
	@DeleteMapping("/remove/{idAtributo}")
	public AtributoModel eliminarAtributo(@PathVariable("idAtributo") String idAtributo ) {
		return atributoConverter.convertAtributoToAtributoModel(
				atributoService.eliminarAtributo(idAtributo));
	}

	
	

}
