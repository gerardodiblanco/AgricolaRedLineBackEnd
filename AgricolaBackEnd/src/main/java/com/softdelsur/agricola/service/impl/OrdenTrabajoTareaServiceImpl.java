package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.EstadoOrdenTrabajoTarea;
import com.softdelsur.agricola.entity.OrdenTrabajo;
import com.softdelsur.agricola.entity.OrdenTrabajoTarea;
import com.softdelsur.agricola.repository.OrdenTrabajoTareaRepository;
import com.softdelsur.agricola.service.OrdenTrabajoTareaService;

@Service("ordenTrabajoTareaServiceImpl")
public class OrdenTrabajoTareaServiceImpl implements OrdenTrabajoTareaService {

	@Autowired
	@Qualifier("ordenTrabajoTareaRepository")
	OrdenTrabajoTareaRepository ordenTrabajoTareaRepository;

	@Override
	public OrdenTrabajoTarea addOrdenTrabajoTarea(OrdenTrabajoTarea ordenTrabajoTarea) {
		// TODO Auto-generated method stub
		return ordenTrabajoTareaRepository.save(ordenTrabajoTarea);
	}

	@Override
	public List<OrdenTrabajoTarea> findOrdenTrabajoTareaByOrdenTrabajoAndEstado(OrdenTrabajo ordenTrabajo,
			EstadoOrdenTrabajoTarea estadoOrdenTrabajoTarea) {

		// TODO Auto-generated method stub
		return ordenTrabajoTareaRepository.findOrdenTrabajoTareaByOrdenTrabajoAndEstado(ordenTrabajo,
				estadoOrdenTrabajoTarea);
	}

	@Override
	public void delelteOrdenTrabajoTarea(OrdenTrabajoTarea ordenTrabajoTarea) {
		// TODO Auto-generated method stub
		ordenTrabajoTareaRepository.delete(ordenTrabajoTarea);
		;
	}

}
