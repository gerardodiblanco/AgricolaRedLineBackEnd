package com.softdelsur.agricola.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.EstadoCampo;
import com.softdelsur.agricola.repository.EstadoCampoRepository;
import com.softdelsur.agricola.service.EstadoCampoService;
@Service("estadoCampoServiceImpl")
public class EstadoCampoServiceImpl implements EstadoCampoService {
	
	@Autowired
	@Qualifier("estadoCampoRepository")
	EstadoCampoRepository estadoCampoRepository;

	@Override
	public EstadoCampo addEstadoCampo(EstadoCampo estado) {
		
		return estadoCampoRepository.save(estado);
	}

	@Override
	public EstadoCampo buscarEstadoCampoPorNombre(String nombre) {
		
		return estadoCampoRepository.findEstadoCampoByNombre(nombre);
	}

}
