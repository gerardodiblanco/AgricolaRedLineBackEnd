package com.softdelsur.agricola.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.OrdenTrabajoUnidadTrabajoSubCuartel;
import com.softdelsur.agricola.repository.OrdenTrabajoUnidadTrabajoSubCuartelRepository;
import com.softdelsur.agricola.service.OrdenTrabajoUnidadTrabajoSubCuartelService;

@Service("ordenTrabajoUnidadTrabajoSubCuartelServiceImpl")
public class OrdenTrabajoUnidadTrabajoSubCuartelServiceImpl implements OrdenTrabajoUnidadTrabajoSubCuartelService {
	
	@Autowired
	@Qualifier("ordenTrabajoUnidadTrabajoSubCuartelRepository")
	OrdenTrabajoUnidadTrabajoSubCuartelRepository ordenTrabajoUnidadTrabajoSubCuartelRepository;

	@Override
	public OrdenTrabajoUnidadTrabajoSubCuartel addOrdenTrabajoUnidadTrabajoSubCuartelRepository(
			OrdenTrabajoUnidadTrabajoSubCuartel ordenTrabajoUnidadTrabajoSubCuartel) {
		// TODO Auto-generated method stub
		return ordenTrabajoUnidadTrabajoSubCuartelRepository.save(ordenTrabajoUnidadTrabajoSubCuartel);
	}
	

}
