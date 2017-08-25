package com.softdelsur.enologia.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.enologia.entity.EstadoGrupoBarrica;
import com.softdelsur.enologia.model.EstadoGrupoBarricaModel;

@Component("estadoGrupoBarricaConverter")
public class EstadoGrupoBarricaConverter {

	public EstadoGrupoBarrica convertEstadoGrupoBarricaModelToEstadoGrupoBarrica(EstadoGrupoBarricaModel estadoModel){
		EstadoGrupoBarrica estado = new EstadoGrupoBarrica();
		estado.setIdEstadoGrupo(estadoModel.getIdEstadoGrupo());
		estado.setNombreEstadoGrupo(estadoModel.getIdEstadoGrupo());
		
		return estado;
	}
	public EstadoGrupoBarricaModel convertEstadoGrupoBarricaToEstadoGrupoBarricaModel(EstadoGrupoBarrica estado){
		EstadoGrupoBarricaModel estadoModel = new EstadoGrupoBarricaModel();
		estadoModel.setIdEstadoGrupo(estado.getIdEstadoGrupo());
		estadoModel.setNombreEstadoGrupo(estado.getNombreEstadoGrupo());
		
		return estadoModel;	
	}
}
