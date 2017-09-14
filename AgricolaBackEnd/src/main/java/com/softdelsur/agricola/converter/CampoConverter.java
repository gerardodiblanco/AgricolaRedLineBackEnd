package com.softdelsur.agricola.converter;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.model.CampoDTO;
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
	@Qualifier("tipoCampoConverter")
	TipoCampoConverter tipoCampoConverter;
	
	@Autowired
	@Qualifier("coordenadaConverter")
	CoordenadaConverter coordenadaConverter;

	public Campo convertCampoModelToCampo(CampoModel campoModel){
		Campo campo = new Campo();
		campo.setIdCampo(campoModel.getIdCampo());
		
		campo.setCodigo(campoModel.getCodigo());
		campo.setCUIT(campoModel.getCUIT());
		campo.setHectarea(campoModel.getHectarea());
		
		campo.setTipo(tipoCampoConverter.convertTipoCampoModelToTipoCampo(campoModel.getTipo()));

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
		
		campoModel.setCodigo(campo.getCodigo());
		campoModel.setCUIT(campo.getCUIT());
		campoModel.setHectarea(campo.getHectarea());
		
		campoModel.setTipo(tipoCampoConverter.convertTipoCampoToTipoCampoModel(campo.getTipo()));

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
	
	
	
	
	//converter para CampoDTO
	
	public CampoDTO convertCampoToCampoDTO(Campo campo) {
		CampoDTO campoDTO = new CampoDTO();
		campoDTO.setCuit(campo.getCUIT());
		campoDTO.setHectarea(campo.getHectarea());
		campoDTO.setIdCampo(campo.getIdCampo());
		campoDTO.setNombre(campo.getNombre());
		campoDTO.setTipo(campo.getTipo().getNombre());
	
		System.out.println("convirtiendo..");
		return campoDTO;
	}
	
	public List<CampoDTO> convertListCampoToListCampoDTO(List<Campo> campoList){
		List<CampoDTO> campoDTOList = new ArrayList<CampoDTO>();
		for (Campo campo : campoList) {
			campoDTOList.add(convertCampoToCampoDTO(campo));
		}
		return campoDTOList;
	}
	
	
	
	
}
