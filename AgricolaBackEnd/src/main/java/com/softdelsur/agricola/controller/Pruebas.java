package com.softdelsur.agricola.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.entity.Coordenada;
import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.entity.Domicilio;
import com.softdelsur.agricola.entity.EstadoCampo;
import com.softdelsur.agricola.entity.EstadoCuartel;
import com.softdelsur.agricola.entity.EstadoProveedor;
import com.softdelsur.agricola.entity.EstadoSubCuartel;
import com.softdelsur.agricola.entity.Localidad;
import com.softdelsur.agricola.entity.PeriodoVariedad;
import com.softdelsur.agricola.entity.Proveedor;
import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.entity.TipoCampo;
import com.softdelsur.agricola.entity.Variedad;
import com.softdelsur.agricola.model.CampoModel;
import com.softdelsur.agricola.model.CoordenadaModel;
import com.softdelsur.agricola.model.DomicilioModel;
import com.softdelsur.agricola.model.EstadoProveedorModel;
import com.softdelsur.agricola.model.LocalidadModel;
import com.softdelsur.agricola.model.ProveedorModelABMCampo;
import com.softdelsur.agricola.model.TipoCampoModel;
import com.softdelsur.agricola.service.CampoService;
import com.softdelsur.agricola.service.CoordenadaService;
import com.softdelsur.agricola.service.CuartelService;
import com.softdelsur.agricola.service.DomicilioService;
import com.softdelsur.agricola.service.EstadoCampoService;
import com.softdelsur.agricola.service.EstadoCuartelService;
import com.softdelsur.agricola.service.EstadoProveedorService;
import com.softdelsur.agricola.service.EstadoSubCuartelService;
import com.softdelsur.agricola.service.LocalidadService;
import com.softdelsur.agricola.service.PeriodoVariedadService;
import com.softdelsur.agricola.service.ProveedorService;
import com.softdelsur.agricola.service.SubCuartelService;
import com.softdelsur.agricola.service.TipoCampoService;
import com.softdelsur.agricola.service.VariedadService;

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
	
	@Autowired
	@Qualifier("cuartelServiceImpl")
	CuartelService cuartelService;
	
	@Autowired
	@Qualifier("estadoCuartelServiceImpl")
	EstadoCuartelService estadoCuartelService;
	
	@Autowired
	@Qualifier("subCuartelServiceImpl")
	SubCuartelService subCuartelService;
	
	@Autowired
	@Qualifier("estadoSubCuartelServiceImpl")
	EstadoSubCuartelService estadoSubCuartelService;
	
	@Autowired
	@Qualifier("periodoVariedadServiceImpl")
	PeriodoVariedadService periodoVariedadService;
	
	@Autowired
	@Qualifier("variedadServiceImpl")
	VariedadService variedadService;
	
	
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
		
		Localidad localidad3 = new Localidad();
		localidad3.setNombre("Palmira");
		localidad3 = localidadService.addLocalidad(localidad3);
		
		Localidad localidad4 = new Localidad();
		localidad4.setNombre("Pareditas");
		localidad4 = localidadService.addLocalidad(localidad4);
		
		Localidad localidad5 = new Localidad();
		localidad5.setNombre("Potrerillos");
		localidad5 = localidadService.addLocalidad(localidad5);
		
		Localidad localidad6 = new Localidad();
		localidad6.setNombre("Jocolì");
		localidad6 = localidadService.addLocalidad(localidad6);
		
		domicilio.setLocalidad(localidad);
		domicilio = domicilioService.addDomicilio(domicilio);
		
		
		
		Coordenada coordenada1 = new Coordenada(1, -32.883702587768035, -68.85610569842527);
		coordenada1 = coordenadaService.addCorrdenada(coordenada1);
		Coordenada coordenada2 = new Coordenada(2, -32.877516742753954, -68.85445630700679 );
		coordenada2 = coordenadaService.addCorrdenada(coordenada2);
		Coordenada coordenada3 = new Coordenada(3, -32.8790028414513, -68.84576419586182);
		coordenada3 = coordenadaService.addCorrdenada(coordenada3);
		Coordenada coordenada4 = new Coordenada(4, -32.884598740608155, -68.8472272434692);
		coordenada4 = coordenadaService.addCorrdenada(coordenada4);
		
		
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
		EstadoProveedor estadoProveedorActivo = new EstadoProveedor();
		estadoProveedorActivo.setNombreEstadoProveedor("Activo");
		estadoProveedorActivo = estadoProveedorService.addEstadoProveedor(estadoProveedorActivo);
		
		EstadoProveedor estadoProveedorInactivo = new EstadoProveedor();
		estadoProveedorInactivo.setNombreEstadoProveedor("Inactivo");
		estadoProveedorInactivo = estadoProveedorService.addEstadoProveedor(estadoProveedorInactivo);
		
		Proveedor proveedor = new Proveedor();
		proveedor.setEstado(estadoProveedorActivo);

		proveedor.setRazonSocial("Soft del sur");
		proveedor = proveedorService.addProveedor(proveedor);
		
		
		Proveedor proveedor2 = new Proveedor();
		proveedor2.setEstado(estadoProveedorActivo);

		proveedor2.setRazonSocial("Juan Carlos");
		proveedor2 = proveedorService.addProveedor(proveedor2);
		
		Proveedor proveedor3 = new Proveedor();
		proveedor3.setEstado(estadoProveedorActivo);

		proveedor3.setRazonSocial("La Casona");
		proveedor3 = proveedorService.addProveedor(proveedor3);
		
		campo1.setProveedor(proveedor);
		
		
		
		
		//tipo campo
		
		TipoCampo tipoCampo = new TipoCampo();
		tipoCampo.setCodigo(123);
		tipoCampo.setNombre("Frutales");
		tipoCampo = tipoCampoService.addTipoCampo(tipoCampo);
		
		TipoCampo tipoCampo2 = new TipoCampo();
		tipoCampo2.setCodigo(456);
		tipoCampo2.setNombre("Ganadero");
		tipoCampo2 = tipoCampoService.addTipoCampo(tipoCampo2);
		
		TipoCampo tipoCampo3 = new TipoCampo();
		tipoCampo3.setCodigo(789);
		tipoCampo3.setNombre("Cereal");
		tipoCampo3 = tipoCampoService.addTipoCampo(tipoCampo3);
		
		TipoCampo tipoCampo4 = new TipoCampo();
		tipoCampo4.setCodigo(012);
		tipoCampo4.setNombre("viñedo");
		tipoCampo4 = tipoCampoService.addTipoCampo(tipoCampo4);
		campo1.setTipo(tipoCampo4);
		
//estados cuarteles 
		
		EstadoCuartel estadoCuartelActivo = new EstadoCuartel("Activo");
		estadoCuartelActivo = estadoCuartelService.addEstadoCuartel(estadoCuartelActivo);
		
		EstadoCuartel estadoCuartelInactivo = new EstadoCuartel("Inactivo");
		estadoCuartelInactivo = estadoCuartelService.addEstadoCuartel(estadoCuartelInactivo);
		
		
	//set estado
		campo1.setEstadoCampo(estadoCampoActivo);
		
		campo1 = campoService.addCampo(campo1);
		
		Cuartel cuartel = new Cuartel();
		cuartel.setCampo(campo1);
		cuartel.setCodigo(2314);
		cuartel.setHectarea(12);
		cuartel.setDescripcion("cuartel 1");
		
		
				Coordenada coordenada11 = new Coordenada(1, -32.883702587768035, -68.85610569842527);
				coordenada11 = coordenadaService.addCorrdenada(coordenada11);
				Coordenada coordenada22 = new Coordenada(2, -32.880832518970294,-68.85531461389155);
				coordenada22 = coordenadaService.addCorrdenada(coordenada22);
				Coordenada coordenada33 = new Coordenada(3, -32.881381523168265, -68.85202983612061);
				coordenada33 = coordenadaService.addCorrdenada(coordenada33);
				Coordenada coordenada44 = new Coordenada(4, -32.88387796087406, -68.85276332287594);
				coordenada44 = coordenadaService.addCorrdenada(coordenada44);
		
		
		
		cuartel.getCoordenadaList().add(coordenada11);
		cuartel.getCoordenadaList().add(coordenada22);
		cuartel.getCoordenadaList().add(coordenada33);
		cuartel.getCoordenadaList().add(coordenada44);
		
		cuartel.setEstadoCuartel(estadoCuartelActivo);
		
		
		cuartel = cuartelService.addCuartel(cuartel);
		
		
		
		Cuartel cuartel2 = new Cuartel();
		cuartel2.setCampo(campo1);
		cuartel2.setCodigo(3456);
		cuartel2.setHectarea(10);
		cuartel2.setDescripcion("cuartel 2");
		
		
				Coordenada coordenada111 = new Coordenada(1, -32.880855444872765, -68.8553546799011);
				coordenada111 = coordenadaService.addCorrdenada(coordenada111);
				Coordenada coordenada222 = new Coordenada(2, -32.877516742753954,-68.85445630700679);
				coordenada222 = coordenadaService.addCorrdenada(coordenada222);
				Coordenada coordenada333 = new Coordenada(3, -32.87808378823655, -68.85121444458008);
				coordenada333 = coordenadaService.addCorrdenada(coordenada333);
				Coordenada coordenada444 = new Coordenada(4, -32.88146330605037, -68.85211959271237);
				coordenada444 = coordenadaService.addCorrdenada(coordenada444);
		
		
		
		cuartel2.getCoordenadaList().add(coordenada111);
		cuartel2.getCoordenadaList().add(coordenada222);
		cuartel2.getCoordenadaList().add(coordenada333);
		cuartel2.getCoordenadaList().add(coordenada444);
		
		
		cuartel2.setEstadoCuartel(estadoCuartelActivo);
		
		cuartel2 = cuartelService.addCuartel(cuartel2);
//variedad
		
		Variedad variedad1 = new Variedad();
		variedad1.setNombre("Merlot");
		variedad1.setColorVariedad("#BF00FF");
		variedad1 = variedadService.addVariedad(variedad1);
		

		Variedad variedad2 = new Variedad();
		variedad2.setNombre("Sauvignon");
		variedad2.setColorVariedad("#3ADF00");
		variedad2 = variedadService.addVariedad(variedad2);
		
//periodoVariedad
		
		PeriodoVariedad periodoVariedad1 = new PeriodoVariedad();
		periodoVariedad1.setFechaInicioPeriodo(Date.valueOf(LocalDate.now()));
		periodoVariedad1.setFechaFinPeriodo(null);
		periodoVariedad1.setVariedad(variedad1);
		periodoVariedad1 = periodoVariedadService.addPeriodoVariedad(periodoVariedad1);
		

		PeriodoVariedad periodoVariedad2 = new PeriodoVariedad();
		periodoVariedad2.setFechaInicioPeriodo(Date.valueOf(LocalDate.now()));
		periodoVariedad2.setFechaFinPeriodo(null);
		periodoVariedad2.setVariedad(variedad2);
		periodoVariedad2 = periodoVariedadService.addPeriodoVariedad(periodoVariedad2);
		
//estado sub Cuartel
		
		EstadoSubCuartel estadoSubCuartelActivo = new EstadoSubCuartel("Activo");
		estadoSubCuartelActivo = estadoSubCuartelService.addEstadoSubCuartel(estadoSubCuartelActivo);
		
		EstadoSubCuartel estadoSubCuartelInactivo = new EstadoSubCuartel("Inactivo");
		estadoSubCuartelInactivo = estadoSubCuartelService.addEstadoSubCuartel(estadoSubCuartelInactivo);
		
//sub Cuartel		
		
		SubCuartel subCuartel1 = new SubCuartel();
		subCuartel1.setDescripcion("subCuartel 1");
		subCuartel1.setHectarea(3);
		subCuartel1.setEstado(estadoSubCuartelActivo);
		subCuartel1.setCodigo(56);
		subCuartel1.setCuartel(cuartel2);
		subCuartel1.getPeriodosVariedad().add(periodoVariedad1);
		
		subCuartel1.setAtributosSubCuartel(null);
		subCuartel1.setCaracteristicas(null);
		
		

			Coordenada coordenadaSubCuartel1 = new Coordenada(1, -32.88085994991795, -68.85533322222898);
			coordenadaSubCuartel1 = coordenadaService.addCorrdenada(coordenadaSubCuartel1);
			Coordenada coordenadaSubCuartel2 = new Coordenada(3, -32.87998946150223,-68.85301688903809);
			coordenadaSubCuartel2 = coordenadaService.addCorrdenada(coordenadaSubCuartel2);
			Coordenada coordenadaSubCuartel3 = new Coordenada(2, -32.87962065318705, -68.85501957089991);
			coordenadaSubCuartel3 = coordenadaService.addCorrdenada(coordenadaSubCuartel3);
			Coordenada coordenadaSubCuartel4 = new Coordenada(4, -32.88122904499201, -68.85336413769528);
			coordenadaSubCuartel4 = coordenadaService.addCorrdenada(coordenadaSubCuartel4);
		
			subCuartel1.getCoordenadaList().add(coordenadaSubCuartel1);
			subCuartel1.getCoordenadaList().add(coordenadaSubCuartel2);
			subCuartel1.getCoordenadaList().add(coordenadaSubCuartel3);
			subCuartel1.getCoordenadaList().add(coordenadaSubCuartel4);
			
			subCuartel1 = subCuartelService.addSubCuartel(subCuartel1);
			
			
			
			
			SubCuartel subCuartel2 = new SubCuartel();
			subCuartel2.setDescripcion("subCuartel 2");
			subCuartel2.setHectarea(34);
			subCuartel2.setEstado(estadoSubCuartelActivo);
			subCuartel2.setCodigo(7);
			subCuartel2.setCuartel(cuartel2);
			subCuartel2.getPeriodosVariedad().add(periodoVariedad2);
			subCuartel2.setAtributosSubCuartel(null);
			subCuartel2.setCaracteristicas(null);
			
			
	
			
				Coordenada coordenadaSubCuartel11 = new Coordenada(1, -32.87852180068769, -68.85473240740964);
				coordenadaSubCuartel11 = coordenadaService.addCorrdenada(coordenadaSubCuartel11);
				Coordenada coordenadaSubCuartel22 = new Coordenada(2, -32.87752575318348,-68.85445094258876);
				coordenadaSubCuartel22 = coordenadaService.addCorrdenada(coordenadaSubCuartel22);
				Coordenada coordenadaSubCuartel33 = new Coordenada(3, -32.8778765494303, -68.85239998096466);
				coordenadaSubCuartel33 = coordenadaService.addCorrdenada(coordenadaSubCuartel33);
				Coordenada coordenadaSubCuartel44 = new Coordenada(4, -32.8789134312214, -68.85263457684323);
				coordenadaSubCuartel44 = coordenadaService.addCorrdenada(coordenadaSubCuartel44);
			
				subCuartel2.getCoordenadaList().add(coordenadaSubCuartel11);
				subCuartel2.getCoordenadaList().add(coordenadaSubCuartel22);
				subCuartel2.getCoordenadaList().add(coordenadaSubCuartel33);
				subCuartel2.getCoordenadaList().add(coordenadaSubCuartel44);
				
				subCuartel2 = subCuartelService.addSubCuartel(subCuartel2);
		
		
		return "hecho";
		
	}

}
