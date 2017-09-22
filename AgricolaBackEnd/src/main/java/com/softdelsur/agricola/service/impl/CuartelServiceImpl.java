package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.repository.CuartelRepository;
import com.softdelsur.agricola.service.CuartelService;

@Service("cuartelServiceImpl")
public class CuartelServiceImpl implements CuartelService{
	
	@Autowired
	@Qualifier("cuartelRepository")
	CuartelRepository cuartelRepository;

	@Override
	public List<Cuartel> findCuartelByCampo(Campo campo) {
		
		return cuartelRepository.findByCampo(campo);
	}

	@Override
	public Cuartel addCuartel(Cuartel cuartel) {
		
		return cuartelRepository.save(cuartel);
	}

}
