package com.softdelsur.agricola.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.PeriodoVariedad;
import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.repository.PeriodoVariedadRepository;
import com.softdelsur.agricola.service.PeriodoVariedadService;

@Service("periodoVariedadServiceImpl")
public class PeriodoVariedadServiceImpl implements PeriodoVariedadService{
	
	@Autowired
	@Qualifier("periodoVariedadRepository")
	PeriodoVariedadRepository periodoVariedadRepository;

	@Override
	public PeriodoVariedad addPeriodoVariedad(PeriodoVariedad periodoVariedad) {
		
		return periodoVariedadRepository.save(periodoVariedad);
	}

	@Override
	public PeriodoVariedad findPeriodoBariedadVigenteBySubCuartel(SubCuartel subCuartel) {
		
		return periodoVariedadRepository.findBySubCuartelAndFechaFinPeriodo(subCuartel, null);
	}

}
