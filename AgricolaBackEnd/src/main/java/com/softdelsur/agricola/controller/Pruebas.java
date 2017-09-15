package com.softdelsur.agricola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.entity.Coordenada;
import com.softdelsur.agricola.entity.Domicilio;
import com.softdelsur.agricola.entity.EstadoCampo;
import com.softdelsur.agricola.entity.EstadoProveedor;
import com.softdelsur.agricola.entity.Localidad;
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
import com.softdelsur.agricola.service.EstadoCampoService;
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
	
	@Autowired
	@Qualifier("estadoCampoServiceImpl")
	EstadoCampoService estadoCampoService;
	
	@RequestMapping("/campo")
	public String crear() {
		
		EstadoCampo estadoCampoEliminado = new EstadoCampo("Eliminado");
		estadoCampoEliminado = estadoCampoService.addEstadoCampo(estadoCampoEliminado);
		
		EstadoCampo estadoCampoActivo = new EstadoCampo("Activo");
		estadoCampoActivo = estadoCampoService.addEstadoCampo(estadoCampoActivo);
		
	
		Domicilio domicilio = new Domicilio();
		Localidad localidad = new Localidad();
		localidad.setNombre("Agrelo");
		localidad = localidadService.addLocalidad(localidad);
		
		Localidad localidad2 = new Localidad();
		localidad2.setNombre("La Consulta");
		localidad2 = localidadService.addLocalidad(localidad2);
		
		domicilio.setLocalidad(localidad);
		domicilio = domicilioService.addDomicilio(domicilio);
		
		
		
		Coordenada coordenada1 = new Coordenada(1, -32.880459, -68.854432);
		coordenada1 = coordenadaService.addCorrdenada(coordenada1);
		Coordenada coordenada2 = new Coordenada(2, -32.875174, -68.837376 );
		coordenada2 = coordenadaService.addCorrdenada(coordenada2);
		Coordenada coordenada3 = new Coordenada(3, -32.880913, -68.833190);
		coordenada3 = coordenadaService.addCorrdenada(coordenada3);
		Coordenada coordenada4 = new Coordenada(4, -32.883914, -68.836198);
		coordenada4 = coordenadaService.addCorrdenada(coordenada4);
		Coordenada coordenada5 = new Coordenada(5, -32.881914, -68.835192);
		coordenada5 = coordenadaService.addCorrdenada(coordenada5);
		
		Campo campo1 = new Campo();
		campo1.setCodigo(123);
		campo1.setHectarea(24);
		campo1.setNombre("campo1");
		campo1.setCUIT("2-654654165-46");
		
		campo1.getCoordenadaList().add(coordenada1);
		campo1.getCoordenadaList().add(coordenada2);
		campo1.getCoordenadaList().add(coordenada3);
		campo1.getCoordenadaList().add(coordenada4);
		
		campo1.setDomicilio(domicilio);
		EstadoProveedor estadoProveedor = new EstadoProveedor();
		estadoProveedor = estadoProveedorService.addEstadoProveedor(estadoProveedor);
		
		Proveedor proveedor = new Proveedor();
		proveedor.setEstado(estadoProveedor);

		proveedor = proveedorService.addProveedor(proveedor);
		
		
		campo1.setProveedor(proveedor);
		
		
		
		
		//tipo campo
		
		TipoCampo tipoCampo2 = new TipoCampo();
		tipoCampo2.setCodigo(456);
		tipoCampo2.setNombre("papa");
		tipoCampo2 = tipoCampoService.addTipoCampo(tipoCampo2);
		
		TipoCampo tipoCampo = new TipoCampo();
		tipoCampo.setCodigo(123);
		tipoCampo.setNombre("viñedo");
		tipoCampo = tipoCampoService.addTipoCampo(tipoCampo);
		campo1.setTipo(tipoCampo);
		
	//set estado
		campo1.setEstadoCampo(estadoCampoActivo);
		
		campo1 = campoService.addCampo(campo1);
		
		
		return "hecho";
		
	}

}
