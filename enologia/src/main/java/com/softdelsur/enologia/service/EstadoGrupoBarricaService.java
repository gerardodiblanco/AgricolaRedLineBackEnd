package com.softdelsur.enologia.service;

import java.util.List;

import com.softdelsur.enologia.entity.EstadoGrupoBarrica;
import com.softdelsur.enologia.model.EstadoGrupoBarricaModel;

public interface EstadoGrupoBarricaService {

	public abstract List<EstadoGrupoBarricaModel> findAllEstadosGrupoBarrica();
	public abstract EstadoGrupoBarricaModel findByidEstadoGrupo(String id);
	public abstract EstadoGrupoBarricaModel addEstadoGrupoBarrica(EstadoGrupoBarricaModel estadoGrupoBarrica);
}
