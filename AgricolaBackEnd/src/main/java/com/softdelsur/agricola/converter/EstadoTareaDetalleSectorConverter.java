package com.softdelsur.agricola.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.EstadoTareaDetalleSector;
import com.softdelsur.agricola.model.EstadoTareaDetalleSectorModel;

@Component("estadoTareaDetalleSectorConverter")
public class EstadoTareaDetalleSectorConverter {
	public EstadoTareaDetalleSector convertModelToEntidad(EstadoTareaDetalleSectorModel estadoTareaDetalleSectorModel){
		EstadoTareaDetalleSector estadoTareaDetalleSector = new EstadoTareaDetalleSector();
		estadoTareaDetalleSector.setId(estadoTareaDetalleSectorModel.getId());
		estadoTareaDetalleSector.setCodigo(estadoTareaDetalleSectorModel.getCodigo());
		estadoTareaDetalleSector.setDescripcion(estadoTareaDetalleSectorModel.getDescripcion());
		
		return estadoTareaDetalleSector;
	}
	
	public EstadoTareaDetalleSectorModel convertEntidadToModel(EstadoTareaDetalleSector estadoTareaDetalleSector){
		EstadoTareaDetalleSectorModel estadoTareaDetalleSectorModel = new EstadoTareaDetalleSectorModel();
		estadoTareaDetalleSectorModel.setId(estadoTareaDetalleSector.getId());
		estadoTareaDetalleSectorModel.setCodigo(estadoTareaDetalleSector.getCodigo());
		estadoTareaDetalleSectorModel.setDescripcion(estadoTareaDetalleSector.getDescripcion());
		
		return estadoTareaDetalleSectorModel;
	}

}
