package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.TareaInsumo;
import com.softdelsur.agricola.model.TareaInsumoModel;

@Component("tareaInsumoConverter")
public class TareaInsumoConverter {
	
	@Autowired
	@Qualifier("insumoConverter")
	InsumoConverter insumoConverter;
	
	public TareaInsumo convertTareaInsumoModelToTareaInsumo(TareaInsumoModel tareaInsumoModel){
		TareaInsumo tareaInsumo =  new TareaInsumo();
		tareaInsumo.setId(tareaInsumoModel.getId());
		tareaInsumo.setCantConsumida(tareaInsumoModel.getCantConsumida());
		tareaInsumo.setInsumo(insumoConverter.convertInsumoModelToInsumo(tareaInsumoModel.getInsumo()));
		
		return tareaInsumo;
	}
	
	public TareaInsumoModel convertTareaInsumoToTareaInsumoModel(TareaInsumo tareaInsumo){
		TareaInsumoModel tareaInsumoModel =  new TareaInsumoModel();
		tareaInsumoModel.setId(tareaInsumo.getId());
		tareaInsumoModel.setCantConsumida(tareaInsumo.getCantConsumida());
		tareaInsumoModel.setInsumo(insumoConverter.convertInsumoToInsumoModel(tareaInsumo.getInsumo()));
		
		return tareaInsumoModel;
	}
	
	public List<TareaInsumo> convertListModelToEntidad(List<TareaInsumoModel> tareaInsumoModelList){
		List<TareaInsumo> tareaInsumoList = new ArrayList<TareaInsumo>();
		
		for(TareaInsumoModel tareaInsumoModel: tareaInsumoModelList){
			tareaInsumoList.add(convertTareaInsumoModelToTareaInsumo(tareaInsumoModel));	
		}
		return tareaInsumoList;
		
	}
	
	public List<TareaInsumoModel> convertLisEntidadToModel(List<TareaInsumo> tareaInsumoList){
		List<TareaInsumoModel> tareaInsumoModelList = new ArrayList<TareaInsumoModel>();
		
		for(TareaInsumo tareaInsumo: tareaInsumoList){
			tareaInsumoModelList.add(convertTareaInsumoToTareaInsumoModel(tareaInsumo));	
		}
		return tareaInsumoModelList;
		
	}

}
