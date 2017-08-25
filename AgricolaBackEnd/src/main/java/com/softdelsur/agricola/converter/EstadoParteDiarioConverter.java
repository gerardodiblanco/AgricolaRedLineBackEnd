package com.softdelsur.agricola.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.EstadoParteDiario;
import com.softdelsur.agricola.model.EstadoParteDiarioModel;

@Component("estadoParteDiarioConverter")
public class EstadoParteDiarioConverter {
	public EstadoParteDiario convertEstadoParteDiarioModelToEstadoParteDiario(EstadoParteDiarioModel estadoParteDiarioModel){
		EstadoParteDiario estadoParteDiario = new EstadoParteDiario();
		estadoParteDiario.setIdEstadoParteDiario(estadoParteDiarioModel.getIdEstadoParteDiario());
		estadoParteDiario.setCodigo(estadoParteDiarioModel.getCodigo());
		estadoParteDiario.setNombreEstado(estadoParteDiarioModel.getNombreEstado());
		return estadoParteDiario;
	}
	public EstadoParteDiarioModel convertEstadoParteDiarioToEstadoParteDiarioModel(EstadoParteDiario estadoParteDiario){
		EstadoParteDiarioModel estadoParteDiarioModel = new EstadoParteDiarioModel();
		estadoParteDiarioModel.setIdEstadoParteDiario(estadoParteDiario.getIdEstadoParteDiario());
		estadoParteDiarioModel.setCodigo(estadoParteDiarioModel.getCodigo());
		estadoParteDiarioModel.setNombreEstado(estadoParteDiario.getNombreEstado());
		return estadoParteDiarioModel;
	}

}
