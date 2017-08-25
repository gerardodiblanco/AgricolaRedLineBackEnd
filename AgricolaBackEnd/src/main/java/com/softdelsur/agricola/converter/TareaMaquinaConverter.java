package com.softdelsur.agricola.converter;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.TareaMaquina;
import com.softdelsur.agricola.model.TareaMaquinaModel;

@Component("tareaMaquinaConverter")
public class TareaMaquinaConverter {
	
	@Autowired
	@Qualifier("maquinaConverter")
	MaquinaConverter maquinaConverter;
	
	public TareaMaquina convertTareaMaquinaModelToTareaMaquina(TareaMaquinaModel tareaMaquinaModel){
		TareaMaquina tareaMaquina = new TareaMaquina();
		tareaMaquina.setId(tareaMaquinaModel.getId());
		tareaMaquina.setConsumo(tareaMaquinaModel.getConsumo());
		tareaMaquina.setHorasTrabajo(tareaMaquinaModel.getHorasTrabajo());
		tareaMaquina.setMaquina(maquinaConverter.convertMaquinaModelToMaquina(tareaMaquinaModel.getMaquina()));
		
		return tareaMaquina;
	}
	public TareaMaquinaModel convertTareaMaquinaToTareaMaquinaModel(TareaMaquina tareaMaquina){
		TareaMaquinaModel tareaMaquinaModel = new TareaMaquinaModel();
		tareaMaquinaModel.setId(tareaMaquina.getId());
		tareaMaquinaModel.setConsumo(tareaMaquina.getConsumo());
		tareaMaquinaModel.setHorasTrabajo(tareaMaquina.getHorasTrabajo());
		tareaMaquinaModel.setMaquina(maquinaConverter.convertMaquinaToMaquinaModel(tareaMaquina.getMaquina()));
		
		return tareaMaquinaModel;
	}
	
	public List<TareaMaquina> convertListModelToEntidad(List<TareaMaquinaModel> tareaMaquinaModelList){

	List<TareaMaquina> tareaMaquinaList = new ArrayList<TareaMaquina>();
		for(TareaMaquinaModel tareaMaquinaModel: tareaMaquinaModelList){
			tareaMaquinaList.add(convertTareaMaquinaModelToTareaMaquina(tareaMaquinaModel));
		}
	return tareaMaquinaList;
		
	}
	
	public List<TareaMaquinaModel> convertListEntidadToModel(List<TareaMaquina> tareaMaquinaList){

	List<TareaMaquinaModel> tareaMaquinaModelList = new ArrayList<TareaMaquinaModel>();
		for(TareaMaquina tareaMaquina: tareaMaquinaList){
			tareaMaquinaModelList.add(convertTareaMaquinaToTareaMaquinaModel(tareaMaquina));
		}
	return tareaMaquinaModelList;
		
	}
}
