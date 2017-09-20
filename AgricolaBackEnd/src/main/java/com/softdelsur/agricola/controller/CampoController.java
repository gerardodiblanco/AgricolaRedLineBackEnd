package com.softdelsur.agricola.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.agricola.converter.CampoConverter;
import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.entity.EstadoCampo;
import com.softdelsur.agricola.model.CampoDTO;

import com.softdelsur.agricola.model.CampoModel;

import com.softdelsur.agricola.service.CampoService;
import com.softdelsur.agricola.service.EstadoCampoService;

@RestController
@RequestMapping("/campo")
public class CampoController {


	
	@Autowired
	@Qualifier("campoServiceImpl")
	CampoService campoService;
	
	@Autowired
	@Qualifier("campoConverter")
	CampoConverter campoConverter;
	
	@Autowired
	@Qualifier("estadoCampoServiceImpl")
	EstadoCampoService estadoCampoService;
	
	
	
	@CrossOrigin
	@GetMapping("/allActivos")
	public List<CampoDTO> getCamposDTOActivos() {
		 List<CampoDTO> campoDTOs = campoService.findCamposDTOPorEstado("Activo");
		 System.out.println("fin buscar campos ");
		return campoDTOs;
	}

	@CrossOrigin
	@PostMapping("/save")
	public void guardarCampo(@RequestBody  CampoModel campoModel2) { 
		
		 campoService.addCampo(campoConverter.convertCampoModelToCampo(campoModel2));
			System.out.println("fin - Campo guardado");
	}
	
	@CrossOrigin
	@GetMapping("/{idCampo}")
	public CampoModel buscarCampo(@PathVariable("idCampo") String idCampo) {
		
		return campoService.findCampoByIdCampo(idCampo);
		
	}
	
	@CrossOrigin
	@DeleteMapping("/remove/{idCampo}")
	public String eliminarCampo(@PathVariable("idCampo") String idCampo) {
		String rta = campoService.eliminarCampo(idCampo);
		
		System.out.println("fin eliminar campo");
		return rta;
		
	}
	
	


}

	
	