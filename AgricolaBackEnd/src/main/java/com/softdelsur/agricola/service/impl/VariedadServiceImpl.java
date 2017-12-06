package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.Variedad;
import com.softdelsur.agricola.repository.VariedadRepository;
import com.softdelsur.agricola.service.VariedadService;

@Service("variedadServiceImpl")
public class VariedadServiceImpl implements VariedadService {

	@Autowired
	@Qualifier("variedadRepository")
	VariedadRepository variedadRepository;

	@Override
	public Variedad addVariedad(Variedad variedad) {

		return variedadRepository.save(variedad);
	}

	@Override
	public Variedad findVariedadById(String id) {

		return variedadRepository.findById(id);
	}

	@Override
	public List<Variedad> findVariedadesActivas() {

		return variedadRepository.findByEstado(true);
	}

	@Override
	public Variedad eliminarVariedad(String id) {

		Variedad variedad = variedadRepository.findById(id);
		variedad.setEstado(false);
		variedad = variedadRepository.save(variedad);
		return variedad;
	}

	@Override
	public Variedad findVariedadByNombre(String nombre) {

		return variedadRepository.findByNombreAndEstado(nombre, true);
	}

}
