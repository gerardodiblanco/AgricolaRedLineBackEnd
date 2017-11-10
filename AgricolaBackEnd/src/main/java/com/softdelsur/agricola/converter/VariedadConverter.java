package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Variedad;
import com.softdelsur.agricola.model.VariedadModel;
import com.softdelsur.agricola.service.VariedadService;

@Component("variedadConverter")
public class VariedadConverter {
	
	@Autowired
	@Qualifier("variedadServiceImpl")
	VariedadService variedadService;
	
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
	
	public Variedad convertVariedadModelToVariedad(VariedadModel variedadModel) {
		Variedad variedad = null;
		
		if (variedadModel.getId() == null) {
			variedad = new Variedad();
			variedad.setEstado(true);
			variedad = variedadService.addVariedad(variedad);
		}else {
			variedad = variedadService.findVariedadById(variedadModel.getId());
		}
		variedad.setNombre(variedadModel.getNombre());
		variedad.setColorVariedad(variedadModel.getColorVariedad());
		
		return variedad;
	}
	
	
}
