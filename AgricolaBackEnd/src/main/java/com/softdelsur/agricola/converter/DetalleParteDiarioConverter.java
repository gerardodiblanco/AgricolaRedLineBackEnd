package com.softdelsur.agricola.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.DetalleParteDiario;
import com.softdelsur.agricola.model.DetalleParteDiarioModel;

@Component("detalleParteDiarioConverter")
public class DetalleParteDiarioConverter {
	
	@Autowired
	@Qualifier("personalTareaConverter")
	PersonalTareaConverter personalTareaConverter;
	
	public DetalleParteDiario convertModelToEntity(DetalleParteDiarioModel detalleParteDiarioModel){
		DetalleParteDiario detalleParteDiario = new DetalleParteDiario();
		detalleParteDiario.setId(detalleParteDiarioModel.getId());
		detalleParteDiario.setCantidad(detalleParteDiarioModel.getCantidad());
		detalleParteDiario.setPersonalTarea(personalTareaConverter.convertModelToEntity(detalleParteDiarioModel.getPersonalTarea()));
		
		return detalleParteDiario;
	}
	
	public DetalleParteDiarioModel convertEntityToModel(DetalleParteDiario detalleParteDiario){
		DetalleParteDiarioModel detalleParteDiarioModel = new DetalleParteDiarioModel();
		detalleParteDiarioModel.setId(detalleParteDiario.getId());
		detalleParteDiarioModel.setCantidad(detalleParteDiario.getCantidad());
		detalleParteDiarioModel.setPersonalTarea(personalTareaConverter.convertEntityToModel(detalleParteDiario.getPersonalTarea()));
		
		return detalleParteDiarioModel;
	}

}
