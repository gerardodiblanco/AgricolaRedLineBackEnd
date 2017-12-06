package com.softdelsur.agricola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.agricola.model.LocalidadModel;
import com.softdelsur.agricola.service.LocalidadService;

@RestController
@RequestMapping("/localidad")
public class LocalidadController {

	@Autowired
	@Qualifier("localidadServiceImpl")
	LocalidadService localidadService;

	@CrossOrigin
	@GetMapping("/all")
	public List<LocalidadModel> buscarLocalidades() {
		return localidadService.findLocalidadesAll();

	}

}
