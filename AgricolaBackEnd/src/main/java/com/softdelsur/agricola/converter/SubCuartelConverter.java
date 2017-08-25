package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.model.SubCuartelModel;

@Component("subCuartelConverter")
public class SubCuartelConverter {
	@Autowired
	@Qualifier("caracteristicaConverter")
	CaracteristicaConverter caracteristicaConverter;
	@Autowired
	@Qualifier("estadoSubCuartelConverter")
	EstadoSubCuartelConverter estadoSubCuartelConverter;
	
	@Autowired
	@Qualifier("atributoSubCuartelConverter")
	AtributoSubCuartelConverter atributoSubCuartelConverter;
	
	@Autowired
	@Qualifier("periodoVariedadConverter")
	PeriodoVariedadConverter periodoVariedadConverter;
	
	public SubCuartel convertSubCuartelModelToSubCuartel(SubCuartelModel subCuartelModel){
		SubCuartel subCuartel = new SubCuartel();
		subCuartel.setIdSubCuartel(subCuartelModel.getIdSubCuartel());
		subCuartel.setCodigo(subCuartelModel.getCodigo());
		subCuartel.setDescripcion(subCuartelModel.getDescripcion());
		subCuartel.setHectarea(subCuartelModel.getHectarea());
		subCuartel.setCaracteristicas(caracteristicaConverter.convertListCaracteristicaModelToListCaracteristica(subCuartelModel.getCaracteristicas()));
		subCuartel.setEstado(estadoSubCuartelConverter.convertEstadoSubCuartelModelToEstadoSubCuartel(subCuartelModel.getEstado()));
		subCuartel.setAtributosSubCuartel(atributoSubCuartelConverter.convertListAtributoSubCuartelModelToListAtributoSubCuartel(subCuartelModel.getAtributosSubCuartel()));
		subCuartel.setPeriodosVariedad(periodoVariedadConverter.convertListPeriodoVariedadModelToListPeriodoVariedad(subCuartelModel.getPeriodosVariedad()));
		return subCuartel;
	}
	public SubCuartelModel convertSubCuartelToSubCuartelModel(SubCuartel subCuartel){
		SubCuartelModel subCuartelModel = new SubCuartelModel();
		subCuartelModel.setIdSubCuartel(subCuartel.getIdSubCuartel());
		subCuartelModel.setCodigo(subCuartel.getCodigo());
		subCuartelModel.setDescripcion(subCuartel.getDescripcion());
		subCuartelModel.setHectarea(subCuartel.getHectarea());
		subCuartelModel.setCaracteristicas(caracteristicaConverter.convertListCaracteristicaToListCaracteristicaModel(subCuartel.getCaracteristicas()));
		subCuartelModel.setEstado(estadoSubCuartelConverter.convertEstadoSubCuartelToEstadoSubCuartelModel(subCuartel.getEstado()));
		subCuartelModel.setAtributosSubCuartel(atributoSubCuartelConverter.convertListAtributoSubCuartelToListAtributoSubCuartelModel(subCuartel.getAtributosSubCuartel()));
		subCuartelModel.setPeriodosVariedad(periodoVariedadConverter.convertListPeriodoVariedadToListPeriodoVariedadModel(subCuartel.getPeriodosVariedad()));
		return subCuartelModel;
	}
	
	public List<SubCuartel> convertListSubCuartelModelToListSubCuartel(List<SubCuartelModel> listSubCuartelModel){
		List<SubCuartel> subCuartelList = new ArrayList<SubCuartel>();
		for (SubCuartelModel subCuartelModel : listSubCuartelModel) {
			subCuartelList.add(convertSubCuartelModelToSubCuartel(subCuartelModel));
		}
		return subCuartelList;
	}
	public List<SubCuartelModel> convertListSubCuartelToListSubCuartelModel(List<SubCuartel> listSubCuartel){
		List<SubCuartelModel> subCuartelModelList = new ArrayList<SubCuartelModel>();
		for (SubCuartel subCuartel : listSubCuartel) {
			subCuartelModelList.add(convertSubCuartelToSubCuartelModel(subCuartel));
		}
		return subCuartelModelList;
	}

}
