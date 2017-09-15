package com.softdelsur.agricola.service.impl;

import java.util.List;

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
	public Localidad addLocalidad(Localidad localidad) {
		
		
		return localidadRepository.save(localidad);
	}

	@Override
	public Localidad findByNombreLocalidad(String nombre) {
		
		return localidadRepository.findByNombre(nombre);
	}

	@Override
	public List<LocalidadModel> findLocalidadesAll() {
		
		return localidadConverter.convertListLocalidadToListLocalidadModel(localidadRepository.findAll());
	}

}
