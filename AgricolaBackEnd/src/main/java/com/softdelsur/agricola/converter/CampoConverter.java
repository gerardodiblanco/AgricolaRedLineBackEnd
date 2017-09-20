package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Campo;

import com.softdelsur.agricola.entity.Domicilio;
import com.softdelsur.agricola.entity.Localidad;
import com.softdelsur.agricola.entity.Proveedor;
import com.softdelsur.agricola.model.CampoModel;

import com.softdelsur.agricola.service.CampoService;
import com.softdelsur.agricola.service.CoordenadaService;
import com.softdelsur.agricola.service.DomicilioService;
import com.softdelsur.agricola.service.EstadoCampoService;
import com.softdelsur.agricola.service.LocalidadService;
import com.softdelsur.agricola.service.ProveedorService;
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

	@Autowired
	@Qualifier("proveedorServiceImpl")
	ProveedorService proveedorService;

	public CampoModel convertCampoToCampoModel(Campo campo) {
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

		 campoModel.setProveedorRazonSocial(campo.getProveedor().getRazonSocial());
		campoModel.setCoordenadaList(coordenadaConverter.convertListEntityToListModel(campo.getCoordenadaList()));
		return campoModel;
	}

	public List<CampoModel> convertListEntityToListModel(List<Campo> campoList) {
		List<CampoModel> campoModelList = new ArrayList<CampoModel>();
		for (Campo campo : campoList) {
			campoModelList.add(convertCampoToCampoModel(campo));
		}
		return campoModelList;

	}

	public Campo convertCampoModelToCampo(CampoModel campoModel) {

		Campo campo = null;
		campo = campoService.findByIdCampo(campoModel.getIdCampo());
		if (campo == null) {
			System.out.println("compo == null");
			campo = new Campo();
			campo.setEstadoCampo(estadoCampoService.buscarEstadoCampoPorNombre("Activo"));

		}
		campo.setCodigo(campoModel.getCodigo());
		campo.setCUIT(campoModel.getCUIT());
		campo.setHectarea(campoModel.getHectarea());
		campo.setNombre(campoModel.getNombre());

		System.out.println("atribtos seteados, proximo paso convertir coordenadas");

		campo.setCoordenadaList(coordenadaConverter.convertListModelToListEntity(campoModel.getCoordenadaList()));

		if (campo.getDomicilio() == null) {

			System.out.println("domicilio == null");
			Domicilio domicilio = new Domicilio();
			domicilio = domicilioService.addDomicilio(domicilio);
			campo.setDomicilio(domicilio);
			System.out.println("domicilio guardado y seteado");
		}

		campo.getDomicilio().setCalle(campoModel.getCalle());
		campo.getDomicilio().setNumero(campoModel.getNumeroDomicilio());

		System.out.println("domicilio seteado, proximo paso es buscar localidad");
		System.out.println("getLocalidad() " + campoModel.getLocalidad());
		Localidad localidad = localidadService.findByNombreLocalidad(campoModel.getLocalidad());
		System.out.println("nombre localidad = " + localidad.getNombre());
		campo.getDomicilio().setLocalidad(localidad);
		System.out.println("localidad seteada");

		System.out.println("get proveedor " + campoModel.getProveedorRazonSocial());
		Proveedor proveedor = proveedorService.getProveedorByRazonSocial(campoModel.getProveedorRazonSocial());
		campo.setProveedor(proveedor);

		campo.setTipo(tipoCampoService.findTipoCampoByNombre(campoModel.getTipo()));

		return campo;

	}

}
