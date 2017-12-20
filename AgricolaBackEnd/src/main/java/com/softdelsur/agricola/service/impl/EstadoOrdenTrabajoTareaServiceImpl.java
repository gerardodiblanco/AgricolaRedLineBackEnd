package com.softdelsur.agricola.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.EstadoOrdenTrabajoTarea;
import com.softdelsur.agricola.repository.EstadoOrdenTrabajoTareaRepository;
import com.softdelsur.agricola.service.EstadoOrdenTrabajoTareaService;

@Service("estadoOrdenTrabajoTareaServiceImpl")
public class EstadoOrdenTrabajoTareaServiceImpl implements EstadoOrdenTrabajoTareaService {

	@Autowired
	@Qualifier("estadoOrdenTrabajoTareaRepository")
	EstadoOrdenTrabajoTareaRepository estadoOrdenTrabajoTareaRepository;

	@Override
	public EstadoOrdenTrabajoTarea findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return estadoOrdenTrabajoTareaRepository.findByNombre(nombre);
	}

	@Override
	public EstadoOrdenTrabajoTarea addEstadoOrdenTrabajoTarea(EstadoOrdenTrabajoTarea estadoOrdenTrabajoTarea) {
		// TODO Auto-generated method stub
		return estadoOrdenTrabajoTareaRepository.save(estadoOrdenTrabajoTarea);
	}

}
