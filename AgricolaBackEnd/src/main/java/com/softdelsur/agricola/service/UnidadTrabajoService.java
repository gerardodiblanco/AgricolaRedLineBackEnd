package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.UnidadTrabajo;

public interface UnidadTrabajoService {

	UnidadTrabajo addUnidadTrabajo(UnidadTrabajo unidadTrabajo);

	List<UnidadTrabajo> findUnidadTrabajoActivos();

	UnidadTrabajo findUnidadTrabajoById(String id);

	void remove(String id);

}
