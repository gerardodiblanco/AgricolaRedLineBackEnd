package com.softdelsur.agricola.service;

import com.softdelsur.agricola.entity.Coordenada;
import com.softdelsur.agricola.model.CoordenadaModel;

public interface CoordenadaService {

	CoordenadaModel addCorrdenadaModel(CoordenadaModel coordenadaModel);
	Coordenada addCorrdenada(Coordenada coordenada);
	
	CoordenadaModel findCoordenadaModelById(String id);
	Coordenada findCoordenadaById(String id);
}
