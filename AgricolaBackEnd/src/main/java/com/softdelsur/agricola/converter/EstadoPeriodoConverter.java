package com.softdelsur.agricola.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.EstadoPeriodo;
import com.softdelsur.agricola.model.EstadoPeriodoModel;

@Component("estadoPeriodoConverter")
public class EstadoPeriodoConverter {
	
	public EstadoPeriodo convertEstadoPeriodoModelToEstadoPeriodo(EstadoPeriodoModel estadoModel){
		EstadoPeriodo estado = new EstadoPeriodo();
		estado.setIdEstadoPeriodo(estadoModel.getIdEStado());
		estado.setNombreEstadoPeriodo(estadoModel.getNombreEstadoPeriodo());
		return estado;
	}
	public EstadoPeriodoModel convertEstadoPeriodoToEstadoPeriodo(EstadoPeriodo estado){
		EstadoPeriodoModel estadoModel = new EstadoPeriodoModel();
		estadoModel.setIdEStado(estado.getIdEstadoPeriodo());
		estadoModel.setNombreEstadoPeriodo(estado.getNombreEstadoPeriodo());
		return estadoModel;
	}

}
