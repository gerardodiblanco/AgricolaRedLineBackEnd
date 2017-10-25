package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.boot.model.source.spi.AttributeRole;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Atributo;
import com.softdelsur.agricola.model.AtributoModel;

@Component("atributoConverter")
public class AtributoConverter {
	
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
	

}
