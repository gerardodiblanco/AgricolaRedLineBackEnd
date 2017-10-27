package com.softdelsur.agricola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.agricola.converter.AtributoOpcionConverter;
import com.softdelsur.agricola.model.AtributoModel;
import com.softdelsur.agricola.model.AtributoOpcionModel;
import com.softdelsur.agricola.service.AtributoOpcionService;

@RestController
@RequestMapping("/opcion")
public class AtributoOpcionController {
	
	@Autowired
	@Qualifier("atributoOpcionServiceImpl")
	AtributoOpcionService atributoOpcionService;
	
	@Autowired
	@Qualifier("atributoOpcionConverter")
	AtributoOpcionConverter atributoOpcionConverter;

	
	

	@CrossOrigin
	@GetMapping("/allActivos/{idAtributo}")
	public List<AtributoOpcionModel> buscarAtributoOpcion(@PathVariable("idAtributo") String idAtributo){
		System.out.println(idAtributo);
		return atributoOpcionConverter.convertListAtributoOpcionToListAtributoOpcionModel(
				atributoOpcionService.findAtributoOpcionActivos(idAtributo));
	}
	
	@CrossOrigin
	@PostMapping("/save")
	public AtributoOpcionModel addAtributoOpcion(@RequestBody AtributoOpcionModel atributoOpcionModel) {
		System.out.println(atributoOpcionModel.getNombreAtributo());
		
		return atributoOpcionConverter.convertAtributoOpcionToAtributoOpcionModel(
				atributoOpcionService.addAtributoOpcion(atributoOpcionConverter.convertAtributoOpcionModelToAtributoOpcion(atributoOpcionModel)));
		
	}
	
	@CrossOrigin
	@DeleteMapping("/remove/{idAtributoOpcion}")
	public AtributoOpcionModel eliminarAtributoOpcion(@PathVariable("idAtributoOpcion") String idAtributoOpcion ) {
		return atributoOpcionConverter.convertAtributoOpcionToAtributoOpcionModel(
				atributoOpcionService.eliminarAtributoOpcion(idAtributoOpcion));
	}
}
