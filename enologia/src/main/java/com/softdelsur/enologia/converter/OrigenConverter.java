package com.softdelsur.enologia.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.enologia.entity.Origen;
import com.softdelsur.enologia.model.OrigenModel;

@Component("origenConverter")
public class OrigenConverter {
	public Origen convertOrigenModelToOrigen(OrigenModel oModel){
		Origen origen = new Origen();
		origen.setIdOrigen(oModel.getIdOrigen());
		origen.setCodigo(oModel.getCodigo());
		origen.setDescripcion(oModel.getDescripcion());
		
		return origen;
	}
	
	public OrigenModel convertOrigenToOrigenModel(Origen origen){
		OrigenModel oModel = new OrigenModel();
		oModel.setIdOrigen(origen.getIdOrigen());
		oModel.setCodigo(origen.getCodigo());
		oModel.setDescripcion(origen.getDescripcion());
		
		return oModel;
	}
	
}
