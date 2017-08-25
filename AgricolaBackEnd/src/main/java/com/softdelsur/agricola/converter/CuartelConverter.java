package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.model.CuartelModel;
@Component("cuartelConverter")
public class CuartelConverter {
	@Autowired
	@Qualifier("subCuartelConverter")
	SubCuartelConverter subCuartelConverter;
	
	public Cuartel convertCuartelModelToCuartel(CuartelModel cuartelModel){
		Cuartel cuartel = new Cuartel();
		cuartel.setIdCuartel(cuartelModel.getIdCuartel());
		cuartel.setCodigo(cuartelModel.getCodigo());
		cuartel.setDescripcion(cuartelModel.getDescripcion());
		cuartel.setHectarea(cuartelModel.getHectarea());
		cuartel.setSubcuarteles(subCuartelConverter.convertListSubCuartelModelToListSubCuartel(cuartelModel.getSubcuarteles()));
		return cuartel;
	}
	public CuartelModel convertCuartelToCuartelModel(Cuartel cuartel){
		CuartelModel cuartelModel = new CuartelModel();
		cuartelModel.setIdCuartel(cuartel.getIdCuartel());
		cuartelModel.setCodigo(cuartel.getCodigo());
		cuartelModel.setDescripcion(cuartel.getDescripcion());
		cuartelModel.setHectarea(cuartel.getHectarea());
		cuartelModel.setSubcuarteles(subCuartelConverter.convertListSubCuartelToListSubCuartelModel(cuartel.getSubcuarteles()));
		return cuartelModel;
	}

	
	public List<CuartelModel> convertListCuartelToListCuartelModel(List<Cuartel> listCuartel){
		List<CuartelModel> cuartelModelList = new ArrayList<CuartelModel>();
		for (Cuartel cuartel : listCuartel) {
			cuartelModelList.add(convertCuartelToCuartelModel(cuartel));
			
		}
		return cuartelModelList;
	}
public List<Cuartel> convertListCuartelModelToListCuartel(List<CuartelModel> listCuartelModel){
		List<Cuartel> cuartelList = new ArrayList<Cuartel>();
		for (CuartelModel cuartelModel : listCuartelModel) {
			cuartelList.add(convertCuartelModelToCuartel(cuartelModel));
			
		}
		return cuartelList;
	}
}
