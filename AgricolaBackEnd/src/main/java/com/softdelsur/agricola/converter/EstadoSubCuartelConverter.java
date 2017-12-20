package com.softdelsur.agricola.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.EstadoSubCuartel;
import com.softdelsur.agricola.model.EstadoSubCuartelModel;

@Component("estadoSubCuartelConverter")
public class EstadoSubCuartelConverter {

	public EstadoSubCuartel convertEstadoSubCuartelModelToEstadoSubCuartel(
			EstadoSubCuartelModel estadoSubCuartelModel) {
		EstadoSubCuartel estadoSubCuartel = new EstadoSubCuartel();
		estadoSubCuartel.setIdEstado(estadoSubCuartelModel.getIdEstado());
		estadoSubCuartel.setCodigo(estadoSubCuartelModel.getCodigo());
		estadoSubCuartel.setDescripcion(estadoSubCuartelModel.getDescripcion());
		return estadoSubCuartel;
	}

	public EstadoSubCuartelModel convertEstadoSubCuartelToEstadoSubCuartelModel(EstadoSubCuartel estadoSubCuartel) {
		EstadoSubCuartelModel estadoSubCuartelModel = new EstadoSubCuartelModel();
		estadoSubCuartelModel.setIdEstado(estadoSubCuartel.getIdEstado());
		estadoSubCuartelModel.setCodigo(estadoSubCuartel.getCodigo());
		estadoSubCuartelModel.setDescripcion(estadoSubCuartel.getDescripcion());
		return estadoSubCuartelModel;
	}
}
