package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Tarea;
import com.softdelsur.agricola.entity.TareaDetalleSector;
import com.softdelsur.agricola.model.TareaDetalleSectorModel;
import com.softdelsur.agricola.model.TareaModel;

@Component("tareaConverter")
public class TareaConverter {
	
	
	public Tarea convertTareaModelToTarea(TareaModel tareaModel){
		Tarea tarea = new Tarea();
		tarea.setId(tareaModel.getId());
		tarea.setCodigo(tareaModel.getCodigo());
		tarea.setDescripcion(tareaModel.getDescripcion());
		
		return tarea;
	}
	public TareaModel convertTareaToTareaModel(Tarea tarea){
		TareaModel tareaModel = new TareaModel();
		tareaModel.setId(tarea.getId());
		tareaModel.setCodigo(tarea.getCodigo());
		tareaModel.setDescripcion(tarea.getDescripcion());
		
		return tareaModel;
	}
	public List<Tarea> convertListTareaModelToListTarea(List<TareaModel> tareaModelList) {
		 List<Tarea> tareaList = new ArrayList<Tarea>();
		 
		 for(TareaModel tareaModel:tareaModelList){
			 tareaList.add(convertTareaModelToTarea(tareaModel));
		 }
		return tareaList;
	}


	public List<TareaModel> convertListTareaToTareaListModel(List<Tarea> tareaList) {
		 List<TareaModel> tareaModelList = new ArrayList<TareaModel>();
		 
		 for(Tarea tarea:tareaList){
			 tareaModelList.add(convertTareaToTareaModel(tarea));
		 }
		return tareaModelList;
	}

}
