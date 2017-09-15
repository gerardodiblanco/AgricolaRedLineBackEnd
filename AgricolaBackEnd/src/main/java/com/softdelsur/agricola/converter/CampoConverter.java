package com.softdelsur.agricola.converter;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Campo;

import com.softdelsur.agricola.entity.Domicilio;
import com.softdelsur.agricola.entity.Localidad;


import com.softdelsur.agricola.model.CampoModel;

import com.softdelsur.agricola.service.CampoService;
import com.softdelsur.agricola.service.CoordenadaService;
import com.softdelsur.agricola.service.DomicilioService;
import com.softdelsur.agricola.service.EstadoCampoService;
import com.softdelsur.agricola.service.LocalidadService;
import com.softdelsur.agricola.service.TipoCampoService;
@Component("campoConverter")
public class CampoConverter {

	@Autowired
	@Qualifier("cuartelConverter")
	CuartelConverter cuartelConverter;
	@Autowired
	@Qualifier("domicilioConverter")
	DomicilioConverter domicilioConverter;
	@Autowired
	@Qualifier("proveedorConverter")
	ProveedorConverter proveedorConverter;
	
	@Autowired
	@Qualifier("tipoCampoConverter")
	TipoCampoConverter tipoCampoConverter;
	
	@Autowired
	@Qualifier("coordenadaConverter")
	CoordenadaConverter coordenadaConverter;
	
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
	@Qualifier("coordenadaServiceImpl")
	CoordenadaService coordenadaService;
	
	@Autowired
	@Qualifier("tipoCampoServiceImpl")
	TipoCampoService tipoCampoService;
	
	@Autowired
	@Qualifier("estadoCampoServiceImpl")
	EstadoCampoService estadoCampoService;

public CampoModel convertCampoToCampoModel(Campo campo){
	CampoModel campoModel = new CampoModel();
	campoModel.setIdCampo(campo.getIdCampo());
	campoModel.setNombre(campo.getNombre());
	campoModel.setCodigo(campo.getCodigo());
	campoModel.setCUIT(campo.getCUIT());
	campoModel.setHectarea(campo.getHectarea());
	
	campoModel.setTipo(campo.getTipo().getNombre());

	
	campoModel.setCuartelList(cuartelConverter.convertListCuartelToListCuartelModel(campo.getCuartelList()));
	
	campoModel.setCalle(campo.getDomicilio().getCalle());
	campoModel.setLocalidad(campo.getDomicilio().getLocalidad().getNombre());
	campoModel.setNumeroDomicilio(campo.getDomicilio().getNumero());
	

	
	//campoModel.setProveedor(proveedorConverter.convertProveedorToProveedorModel(campo.getProveedor()));
	campoModel.setCoordenadaList(coordenadaConverter.convertListEntityToListModel(campo.getCoordenadaList()));
return campoModel;
}

public List<CampoModel> convertListEntityToListModel(List<Campo> campoList){
	List<CampoModel> campoModelList = new ArrayList<CampoModel>();
	for (Campo campo : campoList) {
		campoModelList.add(convertCampoToCampoModel(campo));
	}
	return campoModelList;
	
}

public Campo convertCampoModelToCampo(CampoModel campoModel2) {
	
	Campo campo = null;
	campo = campoService.findByIdCampo(campoModel2.getIdCampo());
	if(campo == null) {
		System.out.println("compo == null");	
		campo = new Campo();
		campo.setEstadoCampo(estadoCampoService.buscarEstadoCampoPorNombre("Activo"));
		
		
	}
	campo.setCodigo(campoModel2.getCodigo());
	campo.setCUIT(campoModel2.getCUIT());
	campo.setHectarea(campoModel2.getHectarea());
	campo.setNombre(campoModel2.getNombre());
	
	System.out.println("atribtos seteados, proximo paso convertir coordenadas");
	
	
	campo.setCoordenadaList(coordenadaConverter.convertListModelToListEntity(campoModel2.getCoordenadaList()));
	
	
	
	if(campo.getDomicilio() == null) {
		
		System.out.println("domicilio == null");
		Domicilio domicilio = new Domicilio();
		domicilio = domicilioService.addDomicilio(domicilio);
		campo.setDomicilio(domicilio);
		System.out.println("domicilio guardado y seteado");
	}
	
	campo.getDomicilio().setCalle(campoModel2.getCalle());
	campo.getDomicilio().setNumero(campoModel2.getNumeroDomicilio());
	
	System.out.println("domicilio seteado, proximo paso es buscar localidad");
	System.out.println("getLocalidad() "+campoModel2.getLocalidad());
		Localidad localidad = localidadService.findByNombreLocalidad(campoModel2.getLocalidad());
		System.out.println("nombre localidad = "+localidad.getNombre());
	campo.getDomicilio().setLocalidad(localidad);
	System.out.println("localidad seteada");
	
	
	campo.setTipo(tipoCampoService.findTipoCampoByNombre(campoModel2.getTipo()));

	
	
	return campo;
	
}


}
