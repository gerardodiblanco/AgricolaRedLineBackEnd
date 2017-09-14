package com.softdelsur.agricola.controller;


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

import com.softdelsur.agricola.converter.CampoConverter2;

import com.softdelsur.agricola.model.CampoDTO;

import com.softdelsur.agricola.model.CampoModel2;

import com.softdelsur.agricola.service.CampoService;

@RestController
@RequestMapping("/campo")
public class CampoController {


	
	@Autowired
	@Qualifier("campoServiceImpl")
	CampoService campoService;
	
	@Autowired
	@Qualifier("campoConverter2")
	CampoConverter2 campoConverter2;
	
	
	
	@CrossOrigin
	@GetMapping("/all")
	public List<CampoDTO> getCamposDTO() {

		return campoService.findCamposDTO();
		
	}

	@CrossOrigin
	@PostMapping("/save")
	public void guardarCampo(@RequestBody  CampoModel2 campoModel2) { 
		
		 campoService.addCampo(campoConverter2.convertCampoModelToCampo(campoModel2));
			System.out.println("guardado");
	}
	
	@CrossOrigin
	@GetMapping("/{idCampo}")
	public CampoModel2 buscarCampo(@PathVariable("idCampo") String idCampo) {
		
		return campoService.findCampoByIdCampo2(idCampo);
		
	}
	
	


}

	
	