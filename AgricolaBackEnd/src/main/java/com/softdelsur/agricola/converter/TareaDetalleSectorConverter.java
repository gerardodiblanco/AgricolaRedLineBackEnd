package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.TareaDetalleSector;
import com.softdelsur.agricola.model.TareaDetalleSectorModel;

@Component("tareaDetalleSectorConverter")
public class TareaDetalleSectorConverter {
	
	@Autowired
	@Qualifier("tareaConverter")
	TareaConverter tareaConverter;
	
	@Autowired
	@Qualifier("consumoRealInsumoConverter")
	ConsumoRealInsumoConverter consumoRealInsumoConverter;
	
	@Autowired
	@Qualifier("estadoTareaDetalleSectorConverter")
	EstadoTareaDetalleSectorConverter estadoTareaDetalleSectorConverter;
	
	@Autowired
	@Qualifier("personalTareaConverter")
	PersonalTareaConverter personalTareaConverter;
	
	@Autowired
	@Qualifier("utilizacionRealMaquinaConverter")
	UtilizacionRealMaquinaConverter utilizacionRealMaquinaConverter;
	
	public TareaDetalleSector convertModelToEntity(TareaDetalleSectorModel tareaDetalleSectorModel){
		TareaDetalleSector tareaDetalleSector = new TareaDetalleSector();
		tareaDetalleSector.setId(tareaDetalleSectorModel.getId());
		tareaDetalleSector.setCodigo(tareaDetalleSectorModel.getCodigo());
		tareaDetalleSector.setTarea(tareaConverter.convertTareaModelToTarea(tareaDetalleSectorModel.getTarea()));
		tareaDetalleSector.setConsumoRealInsumoList(consumoRealInsumoConverter.convertListModelToListEntidad(tareaDetalleSectorModel.getConsumoRealInsumoList()));
		tareaDetalleSector.setEstado(estadoTareaDetalleSectorConverter.convertModelToEntidad(tareaDetalleSectorModel.getEstado()));
		tareaDetalleSector.setPersonalTareaList(personalTareaConverter.convertListModelToListEntity(tareaDetalleSectorModel.getPersonalTareaList()));
		tareaDetalleSector.setUtilizacionRealMaquinaList(utilizacionRealMaquinaConverter.convertListModelToListEntity(tareaDetalleSectorModel.getUtilizacionRealMaquinaList()));
		
		return tareaDetalleSector;
	}
	
	public TareaDetalleSectorModel convertEntityToModel(TareaDetalleSector tareaDetalleSector){
		TareaDetalleSectorModel tareaDetalleSectorModel = new TareaDetalleSectorModel();
		tareaDetalleSectorModel.setId(tareaDetalleSector.getId());
		tareaDetalleSectorModel.setCodigo(tareaDetalleSector.getCodigo());
		tareaDetalleSectorModel.setTarea(tareaConverter.convertTareaToTareaModel(tareaDetalleSector.getTarea()));
		tareaDetalleSectorModel.setConsumoRealInsumoList(consumoRealInsumoConverter.convertListListEntidadToModel(tareaDetalleSector.getConsumoRealInsumoList()));
		tareaDetalleSectorModel.setEstado(estadoTareaDetalleSectorConverter.convertEntidadToModel(tareaDetalleSector.getEstado()));
		tareaDetalleSectorModel.setPersonalTareaList(personalTareaConverter.convertListEntityToListModel(tareaDetalleSector.getPersonalTareaList()));
		tareaDetalleSectorModel.setUtilizacionRealMaquinaList(utilizacionRealMaquinaConverter.convertListEntityToListModel(tareaDetalleSector.getUtilizacionRealMaquinaList()));
		
		return tareaDetalleSectorModel;
	}

	public List<TareaDetalleSectorModel> convertListEntityToListModel(List<TareaDetalleSector> tareaDetalleSectorList) {
		List<TareaDetalleSectorModel> tareaDetalleSectorModelList = new ArrayList<TareaDetalleSectorModel>();
		for(TareaDetalleSector tareaDetalleSector: tareaDetalleSectorList ){
			tareaDetalleSectorModelList.add(convertEntityToModel(tareaDetalleSector));
		}
		return tareaDetalleSectorModelList;
	}

	public List<TareaDetalleSector> convertListModelToListEntity(List<TareaDetalleSectorModel> tareaDetalleSectorModelList) {
		List<TareaDetalleSector> tareaDetalleSectorList = new ArrayList<TareaDetalleSector>();
		for(TareaDetalleSectorModel tareaDetalleSectorModel: tareaDetalleSectorModelList ){
			tareaDetalleSectorList.add(convertModelToEntity(tareaDetalleSectorModel));
		}
		return tareaDetalleSectorList;
	}



}
