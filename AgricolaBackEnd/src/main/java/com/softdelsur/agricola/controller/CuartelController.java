package com.softdelsur.agricola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.agricola.converter.CuartelConverter;
import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.model.CuartelModel;
import com.softdelsur.agricola.service.CampoService;
import com.softdelsur.agricola.service.CuartelService;

@RestController
@RequestMapping("/cuartel")
public class CuartelController {
	
	@Autowired
	@Qualifier("campoServiceImpl")
	CampoService campoService;
	
	@Autowired
	@Qualifier("cuartelServiceImpl")
	CuartelService cuartelService;
	
	@Autowired
	@Qualifier("cuartelConverter")
	CuartelConverter cuartelConverter;
	
	
	@CrossOrigin
	@GetMapping("/getAll/{idCampo}")
	public List<CuartelModel> getCuarteles(@PathVariable("idCampo") String idCampo){
		Campo campo = campoService.findByIdCampo(idCampo);
		return cuartelConverter.convertListCuartelToListCuartelModel(
				cuartelService.findCuartelByCampo(campo));
	}
	
	@CrossOrigin
	@GetMapping("/getCuartel/{idCuartel}")
	public CuartelModel getCuartel(@PathVariable("idCuartel") String idCuartel){
		Cuartel cuartel = cuartelService.findCuartelById(idCuartel);
		return cuartelConverter.convertCuartelToCuartelModel(cuartel);
	}

}
