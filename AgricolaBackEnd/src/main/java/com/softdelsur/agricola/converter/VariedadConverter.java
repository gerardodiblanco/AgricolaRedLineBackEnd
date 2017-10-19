package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Variedad;
import com.softdelsur.agricola.model.VariedadModel;

@Component("variedadConverter")
public class VariedadConverter {
	
	public VariedadModel convertVariedadToVariedadModel(Variedad variedad){
		
		VariedadModel variedadModel = new VariedadModel();
		variedadModel.setId(variedad.getId());
		variedadModel.setNombre(variedad.getNombre());
		variedadModel.setColorVariedad(variedad.getColorVariedad());
		
		return variedadModel;
		
	}
	
	
	public List<VariedadModel> convertListVariedadToListVariedadModel(List<Variedad> variedadList){
		List<VariedadModel> variedadModelList = new ArrayList<VariedadModel>();
		
		for(Variedad variedad:variedadList) {
			variedadModelList.add(convertVariedadToVariedadModel(variedad));
		}
		
		return variedadModelList;

}
}
