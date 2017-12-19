package com.softdelsur.agricola.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.agricola.converter.OrdenTrabajoConverter;
import com.softdelsur.agricola.entity.OrdenTrabajo;
import com.softdelsur.agricola.model.OrdenTrabajoModel;
import com.softdelsur.agricola.service.OrdenTrabajoService;

@RestController
@RequestMapping("/ordenTrabajo")
public class OrdenTrabajoController {
	
	@Autowired
	@Qualifier("ordenTrabajoServiceImpl")
	OrdenTrabajoService ordenTrabajoService;
	
	@Autowired
	@Qualifier("ordenTrabajoConverter")
	OrdenTrabajoConverter ordenTrabajoConverter;

	
	@CrossOrigin
	@PostMapping("/save")
	public void guardarOrdenTrabajo(@RequestBody OrdenTrabajoModel ordenTrabajoModel) {

		OrdenTrabajo ordenTrabajo = ordenTrabajoConverter.convertOrdenTrabajoModelToOrdenTrabajo(ordenTrabajoModel);
	//	ordenTrabajo = ordenTrabajoService.addOrdenTrabajo(ordenTrabajo);
	
	}

	@CrossOrigin
	@GetMapping("/all")
	public List<OrdenTrabajoModel> buscarOrdenesTrabajo() {
		return ordenTrabajoConverter.convertListOrdenTrabajoToListOrdenTrabajoModel(ordenTrabajoService.findOrdenesTrabajosActivos());
	}
	
	@CrossOrigin
	@GetMapping("/findOrdenTrabajo/{idOrdenTrabajo}")
	public OrdenTrabajoModel buscarOrdenTrabajo(@PathVariable("idOrdenTrabajo") String idOrdenTrabajo) {
		OrdenTrabajo ordenTrabajo = ordenTrabajoService.findOrdenTrabajoById(idOrdenTrabajo);
		return ordenTrabajoConverter.convertOrdenTrabajoModelToOrdenTrabajo(ordenTrabajo);
	}
}
