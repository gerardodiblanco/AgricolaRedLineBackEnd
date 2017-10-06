package com.softdelsur.agricola.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.EstadoSubCuartel;
import com.softdelsur.agricola.repository.EstadoSubCuartelRepository;
import com.softdelsur.agricola.service.EstadoSubCuartelService;

@Service("estadoSubCuartelServiceImpl")
public class EstadoSubCuartelServiceImpl implements EstadoSubCuartelService {
	
	@Autowired
	@Qualifier("estadoSubCuartelRepository")
	EstadoSubCuartelRepository estadoSubCuartelRepository;

	@Override
	public EstadoSubCuartel addEstadoSubCuartel(EstadoSubCuartel estadoSubCuartel) {
		// TODO Auto-generated method stub
		return estadoSubCuartelRepository.save(estadoSubCuartel);
	}

}
