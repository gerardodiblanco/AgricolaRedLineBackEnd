package com.softdelsur.agricola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.agricola.converter.ProveedorConverter;
import com.softdelsur.agricola.entity.EstadoProveedor;
import com.softdelsur.agricola.entity.Proveedor;
import com.softdelsur.agricola.model.ProveedorModelABMCampo;
import com.softdelsur.agricola.service.EstadoProveedorService;
import com.softdelsur.agricola.service.ProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@Autowired
	@Qualifier("proveedorServiceImpl")
	ProveedorService proveedorService;
	
	@Autowired
	@Qualifier("estadoProveedorServiceImpl")
	EstadoProveedorService estadoProveedorService;
	
	@Autowired
	@Qualifier("proveedorConverter")
	ProveedorConverter proveedorConverter;
	
	
	

	@CrossOrigin
	@GetMapping("/all")
	public List<ProveedorModelABMCampo> buscarProveedores(){
		List<Proveedor> proveedores =  proveedorService.buscarProveedoresPorEstado(
				estadoProveedorService.findEstadoByNombre("Activo"));
		
		return proveedorConverter.convertListProveedorToListProveedorModelABMCampo(proveedores);
	}
}
