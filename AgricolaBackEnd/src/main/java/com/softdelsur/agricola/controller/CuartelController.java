package com.softdelsur.agricola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.agricola.converter.CuartelConverter;
import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.entity.EstadoCuartel;
import com.softdelsur.agricola.model.CuartelModel;
import com.softdelsur.agricola.service.CampoService;
import com.softdelsur.agricola.service.CuartelService;
import com.softdelsur.agricola.service.EstadoCuartelService;

@RestController
@RequestMapping("/cuartel")
public class CuartelController {
	
	String nombreEstadoCuartelActivo = "Activo";
	String nombreEstadoCuatelInactivo = "Inactivo";
	
	@Autowired
	@Qualifier("campoServiceImpl")
	CampoService campoService;
	
	@Autowired
	@Qualifier("cuartelServiceImpl")
	CuartelService cuartelService;
	
	@Autowired
	@Qualifier("cuartelConverter")
	CuartelConverter cuartelConverter;
	
	@Autowired
	@Qualifier("estadoCuartelServiceImpl")
	EstadoCuartelService estadoCuartelService;
	
	
	@CrossOrigin
	@GetMapping("/getAll/{idCampo}")
	public List<CuartelModel> getCuartelesActivos(@PathVariable("idCampo") String idCampo){
		Campo campo = campoService.findByIdCampo(idCampo);
		EstadoCuartel estadoCuartel = estadoCuartelService.findEstadoCuartelByNombre(nombreEstadoCuartelActivo);
		return cuartelConverter.convertListCuartelToListCuartelModel(
				cuartelService.findCuartelesByCampoAndEstadoCuartel(campo, estadoCuartel));
	}
	
	@CrossOrigin
	@GetMapping("/getCuartel/{idCuartel}")
	public CuartelModel getCuartel(@PathVariable("idCuartel") String idCuartel){
		Cuartel cuartel = cuartelService.findCuartelById(idCuartel);
		return cuartelConverter.convertCuartelToCuartelModel(cuartel);
	}
	
	@CrossOrigin
	@DeleteMapping("/remove/{idCuartel}")
	public boolean eliminarCuartel(@PathVariable("idCuartel") String idCuartel) {
		boolean rta = false;
		
		EstadoCuartel estadoCuartel = estadoCuartelService.findEstadoCuartelByNombre(nombreEstadoCuatelInactivo);
		Cuartel cuartel = null;
		cuartel = cuartelService.findCuartelById(idCuartel);
		
		if(cuartel != null) {
		cuartel.setEstadoCuartel(estadoCuartel);
		cuartel = cuartelService.addCuartel(cuartel);
		rta = true;
		}
		
		return rta;
				
	}
	
	@CrossOrigin
	@PutMapping("/save")
	public void guardarCuartel(@RequestBody CuartelModel cuartelModel) {
		
		cuartelService.addCuartel(cuartelConverter.convertCuartelModelToCuartel(cuartelModel));
		System.out.println("fin guardar cartel");
	}
	

}
