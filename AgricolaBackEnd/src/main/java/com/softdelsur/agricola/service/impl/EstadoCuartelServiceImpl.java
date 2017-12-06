package com.softdelsur.agricola.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.EstadoCuartel;
import com.softdelsur.agricola.repository.EstadoCuartelRepository;
import com.softdelsur.agricola.service.EstadoCuartelService;

@Service("estadoCuartelServiceImpl")
public class EstadoCuartelServiceImpl implements EstadoCuartelService {

	@Autowired
	@Qualifier("estadoCuartelRepository")
	EstadoCuartelRepository estadoCuartelRespository;

	@Override
	public EstadoCuartel findEstadoCuartelByNombre(String nombre) {

		return estadoCuartelRespository.findEstadoCuartelByNombre(nombre);
	}

	@Override
	public EstadoCuartel addEstadoCuartel(EstadoCuartel estadoCuartel) {

		return estadoCuartelRespository.save(estadoCuartel);
	}

}
