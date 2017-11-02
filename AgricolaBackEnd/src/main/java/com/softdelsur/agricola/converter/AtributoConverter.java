package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.boot.model.source.spi.AttributeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Atributo;
import com.softdelsur.agricola.entity.AtributoOpcion;
import com.softdelsur.agricola.model.AtributoConOpcionesModel;
import com.softdelsur.agricola.model.AtributoModel;
import com.softdelsur.agricola.model.AtributoOpcionModel;
import com.softdelsur.agricola.service.AtributoOpcionService;

import net.bytebuddy.asm.Advice.Return;

@Component("atributoConverter")
public class AtributoConverter {
	
	@Autowired
	@Qualifier("atributoOpcionServiceImpl")
	AtributoOpcionService atributoOpcionService;
	
	@Autowired
	@Qualifier("atributoOpcionConverter")
	AtributoOpcionConverter atributoOpcionConverter;
	
	public AtributoModel convertAtributoToAtributoModel(Atributo atributo) {
		AtributoModel atributoModel = new AtributoModel();
		atributoModel.setId(atributo.getId());
		atributoModel.setNombreAtributo(atributo.getNombreAtributo());
		
		return atributoModel;
	}
	
	
	public Atributo convertAtributoMiodelToAtributo(AtributoModel atributoModel) {
		Atributo atributo = new Atributo();
		atributo.setId(atributoModel.getId());
		atributo.setNombreAtributo(atributoModel.getNombreAtributo());
		atributo.setEstado(true);
		
		return atributo;
	}
	
	public List<AtributoModel> convertListAtributoToListAtributoModel(List<Atributo> atributoList){
		List<AtributoModel> atributoModelList = new ArrayList<AtributoModel>();
		
		for(Atributo atributo:atributoList) {
			atributoModelList.add(convertAtributoToAtributoModel(atributo));
		}
		
		return atributoModelList;
	}
	
	public AtributoConOpcionesModel convertAtributoToAtributoConOpcionesModel(Atributo atributo) {
		AtributoConOpcionesModel atributoConOpcionesModel = new AtributoConOpcionesModel();
		
		atributoConOpcionesModel.setId(atributo.getId());
		atributoConOpcionesModel.setNombreAtributo(atributo.getNombreAtributo());
		List<AtributoOpcion> opciones = null;
		opciones = atributoOpcionService.findAtributoOpcionActivos(atributo.getId()); 
		
		if(opciones != null) {
			atributoConOpcionesModel.setOpciones(atributoOpcionConverter.convertListAtributoOpcionToListAtributoOpcionModel(opciones));
		}
	
		return atributoConOpcionesModel;
			
	}
	
	public List<AtributoConOpcionesModel> convertListAtributoToListAtributoConOpcionesModel(List<Atributo> atributoList){
		List<AtributoConOpcionesModel> atributoConOpcionesModelList = new ArrayList<>();
		
		for (Atributo atributo:atributoList) {
			atributoConOpcionesModelList.add(convertAtributoToAtributoConOpcionesModel(atributo));
		}
		return atributoConOpcionesModelList;
	}



}
