package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.UtilizacionRealMaquina;
import com.softdelsur.agricola.model.UtilizacionRealMaquinaModel;

@Component("utilizacionRealMaquinaConverter")
public class UtilizacionRealMaquinaConverter {
	
	@Autowired 
	@Qualifier("maquinaConverter")
	MaquinaConverter maquinaConverter;
	
	public UtilizacionRealMaquina convertModelToEntity(UtilizacionRealMaquinaModel utilizacionRealMaquinaModel){
		UtilizacionRealMaquina utilizacionRealMaquina = new UtilizacionRealMaquina();
		utilizacionRealMaquina.setId(utilizacionRealMaquinaModel.getId());
		utilizacionRealMaquina.setCantHoras(utilizacionRealMaquinaModel.getCantHoras());
		utilizacionRealMaquina.setConsumo(utilizacionRealMaquinaModel.getConsumo());
		utilizacionRealMaquina.setMaquina(maquinaConverter.convertMaquinaModelToMaquina(utilizacionRealMaquinaModel.getMaquina()));
		
		return utilizacionRealMaquina;
	}
	public UtilizacionRealMaquinaModel convertEntityToModel(UtilizacionRealMaquina utilizacionRealMaquina){
		UtilizacionRealMaquinaModel utilizacionRealMaquinaModel = new UtilizacionRealMaquinaModel();
		utilizacionRealMaquinaModel.setId(utilizacionRealMaquina.getId());
		utilizacionRealMaquinaModel.setCantHoras(utilizacionRealMaquina.getCantHoras());
		utilizacionRealMaquinaModel.setConsumo(utilizacionRealMaquina.getConsumo());
		utilizacionRealMaquinaModel.setMaquina(maquinaConverter.convertMaquinaToMaquinaModel(utilizacionRealMaquina.getMaquina()));
		
		return utilizacionRealMaquinaModel;
	}
	public List<UtilizacionRealMaquina> convertListModelToListEntity(List<UtilizacionRealMaquinaModel> utilizacionRealMaquinaModelList){
		List<UtilizacionRealMaquina> utilizacionRealMaquinaList = new ArrayList<UtilizacionRealMaquina>();
		for(UtilizacionRealMaquinaModel utilizacionRealMaquinaModel: utilizacionRealMaquinaModelList){
			utilizacionRealMaquinaList.add(convertModelToEntity(utilizacionRealMaquinaModel));
		}
		return utilizacionRealMaquinaList;
	}
	
	public List<UtilizacionRealMaquinaModel> convertListEntityToListModel(List<UtilizacionRealMaquina> utilizacionRealMaquinaList){
		List<UtilizacionRealMaquinaModel> utilizacionRealMaquinaModelList = new ArrayList<UtilizacionRealMaquinaModel>();
		for(UtilizacionRealMaquina utilizacionRealMaquina: utilizacionRealMaquinaList){
			utilizacionRealMaquinaModelList.add(convertEntityToModel(utilizacionRealMaquina));
		}
		return utilizacionRealMaquinaModelList;
	}

}
