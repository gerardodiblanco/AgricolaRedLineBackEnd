package com.softdelsur.enologia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.softdelsur.enologia.converter.EstadoGrupoBarricaConverter;
import com.softdelsur.enologia.entity.EstadoGrupoBarrica;
import com.softdelsur.enologia.model.EstadoGrupoBarricaModel;
import com.softdelsur.enologia.repository.EstadoGrupoBarricaRepository;
import com.softdelsur.enologia.service.EstadoGrupoBarricaService;

public class EstadoGrupoBarricaServiceImpl implements EstadoGrupoBarricaService{

	@Autowired 
	@Qualifier("estadoGrupoBarricaRepository")
	EstadoGrupoBarricaRepository estadoGrupoBarricaRepository;
	
	@Autowired 
	@Qualifier("converterEstadoGrupoBarrica")
	EstadoGrupoBarricaConverter converterEstadoGrupoBarrica;
	
	
	@Override
	public List<EstadoGrupoBarricaModel> findAllEstadosGrupoBarrica() {
		List<EstadoGrupoBarrica> estadosGrupoBarrica = estadoGrupoBarricaRepository.findAll();
		List<EstadoGrupoBarricaModel> estadosGrupoModel = new ArrayList<EstadoGrupoBarricaModel>();
		for (EstadoGrupoBarrica estadoGrupoBarrica : estadosGrupoBarrica) {
			estadosGrupoModel.add(converterEstadoGrupoBarrica.convertEstadoGrupoBarricaToEstadoGrupoBarricaModel(estadoGrupoBarrica));
		}
		return estadosGrupoModel;
	}

	@Override
	public EstadoGrupoBarricaModel findByidEstadoGrupo(String id) {
		
		return converterEstadoGrupoBarrica.convertEstadoGrupoBarricaToEstadoGrupoBarricaModel(estadoGrupoBarricaRepository.findByidEstadoGrupo(id));
	}

	@Override
	public EstadoGrupoBarricaModel addEstadoGrupoBarrica(EstadoGrupoBarricaModel estadoGrupoNew) {
		EstadoGrupoBarrica estadoGrupoBarrica = converterEstadoGrupoBarrica.convertEstadoGrupoBarricaModelToEstadoGrupoBarrica(estadoGrupoNew);
		
		return converterEstadoGrupoBarrica.convertEstadoGrupoBarricaToEstadoGrupoBarricaModel(estadoGrupoBarricaRepository.save(estadoGrupoBarrica));
	}

}
