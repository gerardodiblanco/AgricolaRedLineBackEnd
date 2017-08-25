package com.softdelsur.agricola.converter;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.model.CampoModel;

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
	@Qualifier("coordenadaConverter")
	CoordenadaConverter coordenadaConverter;

	public Campo convertCampoModelToCampo(CampoModel campoModel){
		Campo campo = new Campo();
		campo.setIdCampo(campoModel.getIdCampo());
		campo.setAltitud(campoModel.getAltitud());
		campo.setCodigo(campoModel.getCodigo());
		campo.setCUIT(campoModel.getCUIT());
		campo.setHectarea(campoModel.getHectarea());

		campo.setNombre(campoModel.getNombre());
		campo.setCuartelList(cuartelConverter.convertListCuartelModelToListCuartel(campoModel.getCuartelList()));
		campo.setDomicilio(domicilioConverter.convertDomicilioModelToDomicilio(campoModel.getDomicilio()));
		campo.setProveedor(proveedorConverter.convertProveedorModelToProveedor(campoModel.getProveedor()));
		campo.setCoordenadaList(coordenadaConverter.convertListModelToListEntity(campoModel.getCoordenadaList()));
		return campo;
	}
	public CampoModel convertCampoToCampoModel(Campo campo){
		CampoModel campoModel = new CampoModel();
		campoModel.setIdCampo(campo.getIdCampo());
		campoModel.setAltitud(campo.getAltitud());
		campoModel.setCodigo(campo.getCodigo());
		campoModel.setCUIT(campo.getCUIT());
		campoModel.setHectarea(campo.getHectarea());

		campoModel.setNombre(campo.getNombre());
		campoModel.setCuartelList(cuartelConverter.convertListCuartelToListCuartelModel(campo.getCuartelList()));
		campoModel.setDomicilio(domicilioConverter.convertDomicilioToDomicilioModel(campo.getDomicilio()));
		campoModel.setProveedor(proveedorConverter.convertProveedorToProveedorModel(campo.getProveedor()));
		campoModel.setCoordenadaList(coordenadaConverter.convertListEntityToListModel(campo.getCoordenadaList()));
	return campoModel;
	}
	
	public List<Campo> convertListModelToListEntity(List<CampoModel> campoModelList){
		List<Campo> campoList = new ArrayList<Campo>();
		for (CampoModel campoModel : campoModelList) {
			campoList.add(convertCampoModelToCampo(campoModel));
		}
		return campoList;
		
	}
	public List<CampoModel> convertListEntityToListModel(List<Campo> campoList){
		List<CampoModel> campoModelList = new ArrayList<CampoModel>();
		for (Campo campo : campoList) {
			campoModelList.add(convertCampoToCampoModel(campo));
		}
		return campoModelList;
		
	}
}
