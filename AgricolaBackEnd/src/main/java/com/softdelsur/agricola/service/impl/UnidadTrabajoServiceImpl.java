package com.softdelsur.agricola.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.UnidadTrabajo;
import com.softdelsur.agricola.entity.UnidadTrabajoSubCuartel;
import com.softdelsur.agricola.repository.UnidadTrabajoRepository;
import com.softdelsur.agricola.service.UnidadTrabajoService;
import com.softdelsur.agricola.service.UnidadTrabajoSubCuartelService;

@Service("unidadTrabajoServiceImpl")
public class UnidadTrabajoServiceImpl implements UnidadTrabajoService{
	
	@Autowired
	@Qualifier("unidadTrabajoRepository")
	UnidadTrabajoRepository unidadTrabajoRepository;
	
	@Autowired
	@Qualifier("unidadTrabajoSubCuartelServiceImpl")
	UnidadTrabajoSubCuartelService unidadTrabajoSubCuartelService;

	@Override
	public UnidadTrabajo addUnidadTrabajo(UnidadTrabajo unidadTrabajo) {
		// TODO Auto-generated method stub
		return unidadTrabajoRepository.save(unidadTrabajo);
	}

	@Override
	public List<UnidadTrabajo> findUnidadTrabajoActivos() {
		// TODO Auto-generated method stub
		return unidadTrabajoRepository.findAllActivosByEstadoActivo(true);
	}

	@Override
	public UnidadTrabajo findUnidadTrabajoById(String id) {
		// TODO Auto-generated method stub
		return unidadTrabajoRepository.findUnidadTrabajoById(id);
	}

	@Override
	public void remove(String id) {
		UnidadTrabajo unidadTrabajo = unidadTrabajoRepository.findUnidadTrabajoById(id);
		
		unidadTrabajo.setEstadoActivo(false);
		List<UnidadTrabajoSubCuartel> unidadTrabajoSubCuartelList = unidadTrabajoSubCuartelService.findVigenteByUnidadTrabajo(unidadTrabajo);
		for (UnidadTrabajoSubCuartel unidadTrabajoSubCuartel : unidadTrabajoSubCuartelList) {
			unidadTrabajoSubCuartel.setFechaBaja(Date.valueOf(LocalDate.now()));
			unidadTrabajoSubCuartel = unidadTrabajoSubCuartelService.addUnidadTrabajoSubCuartel(unidadTrabajoSubCuartel);
		}
		unidadTrabajo = unidadTrabajoRepository.save(unidadTrabajo);
	}

}
