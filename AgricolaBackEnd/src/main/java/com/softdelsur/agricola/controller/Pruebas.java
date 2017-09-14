package com.softdelsur.agricola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.entity.Coordenada;
import com.softdelsur.agricola.entity.Domicilio;
import com.softdelsur.agricola.entity.EstadoProveedor;
import com.softdelsur.agricola.entity.Proveedor;
import com.softdelsur.agricola.entity.TipoCampo;
import com.softdelsur.agricola.model.CampoModel;
import com.softdelsur.agricola.model.CoordenadaModel;
import com.softdelsur.agricola.model.DomicilioModel;
import com.softdelsur.agricola.model.EstadoProveedorModel;
import com.softdelsur.agricola.model.LocalidadModel;
import com.softdelsur.agricola.model.ProveedorModel;
import com.softdelsur.agricola.model.TipoCampoModel;
import com.softdelsur.agricola.service.CampoService;
import com.softdelsur.agricola.service.CoordenadaService;
import com.softdelsur.agricola.service.DomicilioService;
import com.softdelsur.agricola.service.EstadoProveedorService;
import com.softdelsur.agricola.service.LocalidadService;
import com.softdelsur.agricola.service.ProveedorService;
import com.softdelsur.agricola.service.TipoCampoService;

@RestController
@RequestMapping("/crearInstancias")
public class Pruebas {
	
	@Autowired
	@Qualifier("campoServiceImpl")
	CampoService campoService;
	
	@Autowired
	@Qualifier("localidadServiceImpl")
	LocalidadService localidadService;
	
	@Autowired
	@Qualifier("domicilioServiceImpl")
	DomicilioService domicilioService;
	
	@Autowired
	@Qualifier("estadoProveedorServiceImpl")
	EstadoProveedorService estadoProveedorService;
	
	@Autowired
	@Qualifier("proveedorServiceImpl")
	ProveedorService proveedorService;
	
	@Autowired
	@Qualifier("coordenadaServiceImpl")
	CoordenadaService coordenadaService;
	
	@Autowired
	@Qualifier("tipoCampoServiceImpl")
	TipoCampoService tipoCampoService;
	
	@RequestMapping("/campo")
	public String crear() {
	
		DomicilioModel domicilio = new DomicilioModel();
		LocalidadModel localidad = new LocalidadModel();
		localidad.setNombre("Agrelo");
		localidad = localidadService.addLocalidad(localidad);
		
		LocalidadModel localidad2 = new LocalidadModel();
		localidad2.setNombre("La Consulta");
		localidad2 = localidadService.addLocalidad(localidad2);
		
		domicilio.setLocalidad(localidad);
		domicilio = domicilioService.addDomicilioModel(domicilio);
		
		
		
		CoordenadaModel coordenada1 = new CoordenadaModel(1, -32.880459, -68.854432);
		coordenada1 = coordenadaService.addCorrdenadaModel(coordenada1);
		CoordenadaModel coordenada2 = new CoordenadaModel(2, -32.875174, -68.837376 );
		coordenada2 = coordenadaService.addCorrdenadaModel(coordenada2);
		CoordenadaModel coordenada3 = new CoordenadaModel(3, -32.880913, -68.833190);
		coordenada3 = coordenadaService.addCorrdenadaModel(coordenada3);
		CoordenadaModel coordenada4 = new CoordenadaModel(4, -32.883914, -68.836198);
		coordenada4 = coordenadaService.addCorrdenadaModel(coordenada4);
		CoordenadaModel coordenada5 = new CoordenadaModel(5, -32.881914, -68.835192);
		coordenada5 = coordenadaService.addCorrdenadaModel(coordenada5);
		
		CampoModel campo1 = new CampoModel();
		campo1.setCodigo(123);
		campo1.setHectarea(24);
		campo1.setNombre("campo1");
		campo1.setCUIT("2-654654165-46");
		
		campo1.getCoordenadaList().add(coordenada1);
		campo1.getCoordenadaList().add(coordenada2);
		campo1.getCoordenadaList().add(coordenada3);
		campo1.getCoordenadaList().add(coordenada4);
		
		campo1.setDomicilio(domicilio);
		EstadoProveedorModel estadoProveedorModel = new EstadoProveedorModel();
		estadoProveedorModel = estadoProveedorService.addEstadoProveedor(estadoProveedorModel);
		
		ProveedorModel proveedorModel = new ProveedorModel();
		proveedorModel.setEstado(estadoProveedorModel);

		proveedorModel = proveedorService.addProveedor(proveedorModel);
		
		
		campo1.setProveedor(proveedorModel);
		
		
		//tipo campo
		
		TipoCampoModel tipoCampoModel2 = new TipoCampoModel();
		tipoCampoModel2.setCodigo(456);
		tipoCampoModel2.setNombre("papa");
		tipoCampoModel2 = tipoCampoService.addTipoCampo(tipoCampoModel2);
		
		TipoCampoModel tipoCampoModel = new TipoCampoModel();
		tipoCampoModel.setCodigo(123);
		tipoCampoModel.setNombre("viñedo");
		tipoCampoModel = tipoCampoService.addTipoCampo(tipoCampoModel);
		campo1.setTipo(tipoCampoModel);
		
		campo1 = campoService.addCampoModel(campo1);
		
		return "hecho";
		
	}

}
