package com.softdelsur.agricola.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.converter.CoordenadaConverter;
import com.softdelsur.agricola.entity.Coordenada;
import com.softdelsur.agricola.model.CoordenadaModel;
import com.softdelsur.agricola.repository.CoordenadaRepository;
import com.softdelsur.agricola.service.CoordenadaService;

@Service("coordenadaServiceImpl")
public class CoordenadaServiceImpl implements CoordenadaService {

	@Autowired
	@Qualifier("coordenadaRepository")
	CoordenadaRepository coordenadaRepository;

	@Autowired
	@Qualifier("coordenadaConverter")
	CoordenadaConverter coordenadaConverter;

	@Override
	public CoordenadaModel addCorrdenadaModel(CoordenadaModel coordenadaModel) {

		return coordenadaConverter.convertCoordenadaToCoordenadaModel(
				coordenadaRepository.save(coordenadaConverter.convertCoordenadaModelToCoordenada(coordenadaModel)));
	}

	@Override
	public CoordenadaModel findCoordenadaModelById(String id) {

		return coordenadaConverter.convertCoordenadaToCoordenadaModel(coordenadaRepository.findById(id));
	}

	@Override
	public Coordenada findCoordenadaById(String id) {

		return coordenadaRepository.findById(id);
	}

	@Override
	public Coordenada addCorrdenada(Coordenada coordenada) {

		return coordenadaRepository.save(coordenada);
	}

}
