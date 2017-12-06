package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.entity.UnidadTrabajo;
import com.softdelsur.agricola.entity.UnidadTrabajoSubCuartel;
import com.softdelsur.agricola.repository.UnidadTrabajoRepository;
import com.softdelsur.agricola.repository.UnidadTrabajoSubCuartelRepository;
import com.softdelsur.agricola.service.UnidadTrabajoSubCuartelService;

@Service("unidadTrabajoSubCuartelServiceImpl")
public class UnidadTrabajoSubCuartelServiceImpl implements UnidadTrabajoSubCuartelService {
	
	@Autowired
	@Qualifier("unidadTrabajoSubCuartelRepository")
	UnidadTrabajoSubCuartelRepository unidadTrabajoSubCuartelRepository;

	@Override
	public UnidadTrabajoSubCuartel buscarUnidadTrabajoVigentePorSubCuartel(SubCuartel subCuartel) {
		
		return unidadTrabajoSubCuartelRepository.findBySubCuartelAndFechaBaja(subCuartel, null);
	}

	@Override
	public List<UnidadTrabajoSubCuartel> findVigenteByUnidadTrabajo(UnidadTrabajo unidadTrabajo) {
		// TODO Auto-generated method stub
		return unidadTrabajoSubCuartelRepository.findByUnidadTrabajoAndFechaBaja(unidadTrabajo, null);
	}

	@Override
	public UnidadTrabajoSubCuartel addUnidadTrabajoSubCuartel(UnidadTrabajoSubCuartel unidadTrabajoSubCuartel) {
		// TODO Auto-generated method stub
		return unidadTrabajoSubCuartelRepository.save(unidadTrabajoSubCuartel);
	}

	@Override
	public UnidadTrabajoSubCuartel findById(String id) {
		// TODO Auto-generated method stub
		return unidadTrabajoSubCuartelRepository.findById(id);
	}

}
