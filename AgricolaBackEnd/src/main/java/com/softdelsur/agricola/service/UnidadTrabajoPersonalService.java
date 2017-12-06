package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.UnidadTrabajo;
import com.softdelsur.agricola.entity.UnidadTrabajoPersonal;

public interface UnidadTrabajoPersonalService {

	List<UnidadTrabajoPersonal> findActivosByUnidadTrabajo(UnidadTrabajo unidadTrabajo);
	UnidadTrabajoPersonal findById(String id);
	UnidadTrabajoPersonal addUnidadTrabajoPersonal(UnidadTrabajoPersonal unidadTrabajoPersonal);
	
}
