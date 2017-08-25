package com.softdelsur.enologia.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.enologia.entity.EstadoBarrica;
import com.softdelsur.enologia.model.EstadoBarricaModel;

@Component("estadoBarricaConverter")
public class EstadoBarricaConverter {

	
	public EstadoBarrica convertEstadoBarricaModelToEstadoBarrica(EstadoBarricaModel estadoModel){
		EstadoBarrica estado = new EstadoBarrica();
		
		estado.setIdEstadoBarrica(estadoModel.getIdEstadoBarrica());
		estado.setNombreEstadoBarrica(estadoModel.getNombreEstadoBarrica());
		
		return estado;
	}
	
	public EstadoBarricaModel convertEstadoBarricaToEstadoBarricaModel(EstadoBarrica estado){
		EstadoBarricaModel estadoModel = new EstadoBarricaModel();
		
		estadoModel.setIdEstadoBarrica(estado.getIdEstadoBarrica());
		estadoModel.setNombreEstadoBarrica(estado.getNombreEstadoBarrica());
		
		return estadoModel;
	}
}
