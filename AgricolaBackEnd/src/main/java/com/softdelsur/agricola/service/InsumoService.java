package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.Insumo;

public interface InsumoService {

	List<Insumo> findInsumosActivos();

	Insumo addInsumo(Insumo trato);
	Insumo findInsumoById(String id);
	Insumo removeInsumo(String id);


}
