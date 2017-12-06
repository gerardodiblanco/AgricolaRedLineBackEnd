package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.entity.UnidadTrabajo;
import com.softdelsur.agricola.entity.UnidadTrabajoSubCuartel;

public interface UnidadTrabajoSubCuartelService {

	
	UnidadTrabajoSubCuartel buscarUnidadTrabajoVigentePorSubCuartel(SubCuartel subCuartel);
	List<UnidadTrabajoSubCuartel> findVigenteByUnidadTrabajo(UnidadTrabajo unidadTrabajo);
	UnidadTrabajoSubCuartel addUnidadTrabajoSubCuartel(UnidadTrabajoSubCuartel unidadTrabajoSubCuartel);
	UnidadTrabajoSubCuartel findById(String id);
}
