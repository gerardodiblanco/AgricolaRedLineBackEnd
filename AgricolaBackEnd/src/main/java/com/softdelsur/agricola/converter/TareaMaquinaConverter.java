package com.softdelsur.agricola.converter;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.TareaMaquinaria;
import com.softdelsur.agricola.model.TareaMaquinaModel;

@Component("tareaMaquinaConverter")
public class TareaMaquinaConverter {
	
	@Autowired
	@Qualifier("maquinariaConverter")
	MaquinariaConverter maquinaConverter;
	
	public TareaMaquinaria convertTareaMaquinaModelToTareaMaquina(TareaMaquinaModel tareaMaquinaModel){
		TareaMaquinaria tareaMaquina = new TareaMaquinaria();
		tareaMaquina.setId(tareaMaquinaModel.getId());
		tareaMaquina.setConsumo(tareaMaquinaModel.getConsumo());
		tareaMaquina.setHorasTrabajo(tareaMaquinaModel.getHorasTrabajo());
		tareaMaquina.setMaquina(maquinaConverter.convertMaquinaModelToMaquina(tareaMaquinaModel.getMaquina()));
		
		return tareaMaquina;
	}
	public TareaMaquinaModel convertTareaMaquinaToTareaMaquinaModel(TareaMaquinaria tareaMaquina){
		TareaMaquinaModel tareaMaquinaModel = new TareaMaquinaModel();
		tareaMaquinaModel.setId(tareaMaquina.getId());
		tareaMaquinaModel.setConsumo(tareaMaquina.getConsumo());
		tareaMaquinaModel.setHorasTrabajo(tareaMaquina.getHorasTrabajo());
		tareaMaquinaModel.setMaquina(maquinaConverter.convertMaquinaToMaquinaModel(tareaMaquina.getMaquina()));
		
		return tareaMaquinaModel;
	}
	
	public List<TareaMaquinaria> convertListModelToEntidad(List<TareaMaquinaModel> tareaMaquinaModelList){

	List<TareaMaquinaria> tareaMaquinaList = new ArrayList<TareaMaquinaria>();
		for(TareaMaquinaModel tareaMaquinaModel: tareaMaquinaModelList){
			tareaMaquinaList.add(convertTareaMaquinaModelToTareaMaquina(tareaMaquinaModel));
		}
	return tareaMaquinaList;
		
	}
	
	public List<TareaMaquinaModel> convertListEntidadToModel(List<TareaMaquinaria> tareaMaquinaList){

	List<TareaMaquinaModel> tareaMaquinaModelList = new ArrayList<TareaMaquinaModel>();
		for(TareaMaquinaria tareaMaquina: tareaMaquinaList){
			tareaMaquinaModelList.add(convertTareaMaquinaToTareaMaquinaModel(tareaMaquina));
		}
	return tareaMaquinaModelList;
		
	}
}
