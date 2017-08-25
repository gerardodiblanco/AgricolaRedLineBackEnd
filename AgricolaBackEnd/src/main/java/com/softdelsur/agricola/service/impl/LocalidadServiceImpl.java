package com.softdelsur.agricola.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.converter.LocalidadConverter;
import com.softdelsur.agricola.entity.Localidad;
import com.softdelsur.agricola.model.LocalidadModel;
import com.softdelsur.agricola.repository.LocalidadRepository;
import com.softdelsur.agricola.service.LocalidadService;

@Service("localidadServiceImpl")
public class LocalidadServiceImpl implements LocalidadService {
	
	@Autowired
	@Qualifier("localidadRepository")
	LocalidadRepository localidadRepository;
	
	@Autowired
	@Qualifier("localidadConverter")
	LocalidadConverter localidadConverter;

	@Override
	public LocalidadModel addLocalidad(LocalidadModel localidadModel) {
		Localidad localidad = localidadConverter.convertLocalidadModelToLocalidad(localidadModel);
		
		return localidadConverter.convertLocalidadToLocalidadModel(localidadRepository.save(localidad));
	}

}
