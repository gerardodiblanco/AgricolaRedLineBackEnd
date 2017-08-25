package com.softdelsur.enologia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.softdelsur.enologia.converter.EstadoBarricaConverter;
import com.softdelsur.enologia.entity.EstadoBarrica;
import com.softdelsur.enologia.model.EstadoBarricaModel;
import com.softdelsur.enologia.repository.EstadoBarricaRepository;
import com.softdelsur.enologia.service.EstadoBarricaService;

public class EstadoBarricaServiceImpl implements EstadoBarricaService{

	@Autowired
	@Qualifier("estadoBarricaConverter")
	EstadoBarricaConverter converterEstadoBarrica;
	
	@Autowired
	@Qualifier("estadoBarricaRepository")
	EstadoBarricaRepository estadoBarricaRepository;
	
	@Override
	public List<EstadoBarricaModel> findAllEstadosBarrica() {
		List<EstadoBarrica> estados = estadoBarricaRepository.findAll();
		List<EstadoBarricaModel> estadosModel = new ArrayList<EstadoBarricaModel>();
		
		for (EstadoBarrica estadoBarrica : estados) {
			estadosModel.add(converterEstadoBarrica.convertEstadoBarricaToEstadoBarricaModel(estadoBarrica));
		}
		return estadosModel;
	}

	@Override
	public EstadoBarricaModel findByidEstadoBarrica(String id) {
		
		return converterEstadoBarrica.convertEstadoBarricaToEstadoBarricaModel(estadoBarricaRepository.findByidEstadoBarrica(id));
	}

	@Override
	public EstadoBarricaModel addEstadoBarrica(EstadoBarricaModel estadoModelNew) {
	EstadoBarrica estadoBarrica = converterEstadoBarrica.convertEstadoBarricaModelToEstadoBarrica(estadoModelNew);
	
		return converterEstadoBarrica.convertEstadoBarricaToEstadoBarricaModel(estadoBarricaRepository.save(estadoBarrica));
	}

}
