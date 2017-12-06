package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.converter.AtributoOpcionConverter;
import com.softdelsur.agricola.entity.Atributo;
import com.softdelsur.agricola.entity.AtributoOpcion;
import com.softdelsur.agricola.repository.AtributoOpcionRepository;
import com.softdelsur.agricola.service.AtributoOpcionService;
import com.softdelsur.agricola.service.AtributoService;

@Service("atributoOpcionServiceImpl")
public class AtributoOpcionServiceImpl implements AtributoOpcionService {

	@Autowired
	@Qualifier("atributoOpcionRepository")
	AtributoOpcionRepository atributoOpcionRepository;

	@Autowired
	@Qualifier("atributoOpcionConverter")
	AtributoOpcionConverter atributoOpcionConverter;

	@Autowired
	@Qualifier("atributoServiceImpl")
	AtributoService atributoService;

	@Override
	public AtributoOpcion findAtributoOpcionById(String id) {
		// TODO Auto-generated method stub
		return atributoOpcionRepository.findAtributoOpcionById(id);
	}

	@Override
	public AtributoOpcion addAtributoOpcion(AtributoOpcion atributoOpcion) {
		// TODO Auto-generated method stub
		return atributoOpcionRepository.save(atributoOpcion);
	}

	@Override
	public AtributoOpcion eliminarAtributoOpcion(String id) {
		AtributoOpcion atributoOpcion = null;
		atributoOpcion = atributoOpcionRepository.findAtributoOpcionById(id);
		if (atributoOpcion != null) {
			atributoOpcion.setEstado(false);
			atributoOpcion = addAtributoOpcion(atributoOpcion);
		}
		return atributoOpcion;
	}

	@Override
	public List<AtributoOpcion> findAtributoOpcionActivos(String idAtributo) {
		Atributo atributo = atributoService.findAtributoById(idAtributo);
		return atributoOpcionRepository.findAtributosByEstadoAndAtributo(true, atributo);
	}

}
