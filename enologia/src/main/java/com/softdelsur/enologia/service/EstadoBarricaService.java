package com.softdelsur.enologia.service;

import java.util.List;

import com.softdelsur.enologia.model.EstadoBarricaModel;

public interface EstadoBarricaService {

	public abstract List<EstadoBarricaModel> findAllEstadosBarrica();
	public abstract EstadoBarricaModel findByidEstadoBarrica(String id);
	public abstract EstadoBarricaModel addEstadoBarrica(EstadoBarricaModel estadoBarricaModel);
}
