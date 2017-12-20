package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.UnidadTrabajo;
import com.softdelsur.agricola.entity.UnidadTrabajoDeposito;

public interface UnidadTrabajoDepositoService {

	List<UnidadTrabajoDeposito> findVigenteByUnidadTrabajo(UnidadTrabajo unidadTrabajo);

	UnidadTrabajoDeposito findById(String id);

	UnidadTrabajoDeposito addUnidadTrabajoDeposito(UnidadTrabajoDeposito unidadTrabajoDeposito);
}
