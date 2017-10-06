package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.AtributoSubCuartel;
import com.softdelsur.agricola.model.AtributoSubCuartelModel;

@Component("atributoSubCuartelConverter")
public class AtributoSubCuartelConverter {

	public List<AtributoSubCuartel> convertListAtributoSubCuartelModelToListAtributoSubCuartel(List<AtributoSubCuartelModel> atributoSubCuartelModelList){
		List<AtributoSubCuartel> atributoSubCuartelList = new ArrayList<>();
		return atributoSubCuartelList;
	}
public List<AtributoSubCuartelModel> convertListAtributoSubCuartelToListAtributoSubCuartelModel(List<AtributoSubCuartel> atributoSubCuartelList){
		List<AtributoSubCuartelModel> atributoSubCuartelModelList = new ArrayList<>();
		return atributoSubCuartelModelList;
		
	}
}
