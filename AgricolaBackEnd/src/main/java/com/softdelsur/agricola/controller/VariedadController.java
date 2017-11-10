package com.softdelsur.agricola.controller;

import java.util.List;

import javax.annotation.PostConstruct;

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

import com.softdelsur.agricola.converter.VariedadConverter;
import com.softdelsur.agricola.model.VariedadModel;
import com.softdelsur.agricola.service.VariedadService;

@RestController
@RequestMapping("/variedad")
public class VariedadController {
	
	@Autowired
	@Qualifier("variedadServiceImpl")
	VariedadService variedadService;
	
	@Autowired
	@Qualifier("variedadConverter")
	VariedadConverter variedadConverter;
	
	
	@CrossOrigin
	@GetMapping("/all")
	public List<VariedadModel> buscarVariedades(){
		
		return variedadConverter.convertListVariedadToListVariedadModel(variedadService.findVariedadesActivas());
		
		
	}
	
	@CrossOrigin
	@DeleteMapping("/remove/{idVariedad}")
	public void eliminarVariedad(@PathVariable("idVariedad") String idVariedad) {
		variedadService.eliminarVariedad(idVariedad);
		
	}
	
	@CrossOrigin
	@PostMapping("/save")
	public void guardarVariedad(@RequestBody VariedadModel variedadModel) {
		
		System.out.println(variedadModel.getNombre()+" este es el nombre");
		variedadService.addVariedad(variedadConverter.convertVariedadModelToVariedad(variedadModel));
	}

	
}
