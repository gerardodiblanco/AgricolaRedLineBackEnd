package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.softdelsur.agricola.entity.AtributoSubCuartel;
import com.softdelsur.agricola.model.AtributoModel;
import com.softdelsur.agricola.model.AtributoSubCuartelModel;
import com.softdelsur.agricola.service.AtributoOpcionService;

@Component("atributoSubCuartelConverter")
public class AtributoSubCuartelConverter {
	
	@Autowired
	@Qualifier("atributoOpcionServiceImpl")
	AtributoOpcionService atributoOpcionService;
	
	@Autowired
	@Qualifier("atributoOpcionConverter")
	AtributoOpcionConverter atributoOpcionConverter;
	
	
	public AtributoSubCuartelModel convertAtributoSubCuartelToAtributoSubCuartelModel(AtributoSubCuartel atributoSubCuartel) {
		AtributoSubCuartelModel atributoSubCuartelModel = new AtributoSubCuartelModel();
		atributoSubCuartelModel.setFechaInicioAsignacion(atributoSubCuartel.getFechaIncioVigencia());
		atributoSubCuartelModel.setIdAtributoSubCuartel(atributoSubCuartel.getId());
		
		atributoSubCuartelModel.setIdOpcion(atributoSubCuartel.getOpcion().getId());
		atributoSubCuartelModel.setNombreOpcion(atributoSubCuartel.getOpcion().getNombreOpcion());
		
		atributoSubCuartelModel.setIdAtributo(atributoSubCuartel.getOpcion().getAtributo().getId());
		atributoSubCuartelModel.setNombreAtributo(atributoSubCuartel.getOpcion().getAtributo().getNombreAtributo());
		atributoSubCuartelModel.setAtributoOpcionModelList(atributoOpcionConverter.convertListAtributoOpcionToListAtributoOpcionModel(
				atributoOpcionService.findAtributoOpcionActivos(atributoSubCuartel.getOpcion().getAtributo().getId())));
		return atributoSubCuartelModel;
	}
	
	public List<AtributoSubCuartel> convertListAtributoSubCuartelModelToListAtributoSubCuartel(List<AtributoSubCuartelModel> atributoSubCuartelModelList){
		List<AtributoSubCuartel> atributoSubCuartelList = new ArrayList<>();
		return atributoSubCuartelList;
	}
	
	public List<AtributoSubCuartelModel> convertListAtributoSubCuartelToListAtributoSubCuartelModel(List<AtributoSubCuartel> atributoSubCuartelList){
		List<AtributoSubCuartelModel> atributoSubCuartelModelList = new ArrayList<>();
		
		for(AtributoSubCuartel atributoSubCuartel: atributoSubCuartelList) {
			System.out.println("convirtiendo atributoSubCuartel ATRIBUTO -> "+atributoSubCuartel.getId());
			if(atributoSubCuartel.getFechaFinVigencia() == null) {
				System.out.println("fecha fin vigencia == null");
				atributoSubCuartelModelList.add(convertAtributoSubCuartelToAtributoSubCuartelModel(atributoSubCuartel));
			}else {System.out.println("atributo dado de baja");}
		}
		
		return atributoSubCuartelModelList;
		
	}
}
