package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.UnidadTrabajo;
import com.softdelsur.agricola.entity.UnidadTrabajoPersonal;
import com.softdelsur.agricola.repository.UnidadTrabajoPersonalRepository;
import com.softdelsur.agricola.service.UnidadTrabajoPersonalService;

@Service("unidadTrabajoPersonalServiceImpl")
public class UnidadTrabajoPersonalServiceImpl implements UnidadTrabajoPersonalService {

	@Autowired
	@Qualifier("unidadTrabajoPersonalRepository")
	UnidadTrabajoPersonalRepository unidadTrabajoPersonalRepository;

	@Override
	public List<UnidadTrabajoPersonal> findActivosByUnidadTrabajo(UnidadTrabajo unidadTrabajo) {
		// TODO Auto-generated method stub
		return unidadTrabajoPersonalRepository.findUTPByUnidadTrabajoAndFechaBaja(unidadTrabajo, null);
	}

	@Override
	public UnidadTrabajoPersonal findById(String id) {
		// TODO Auto-generated method stub
		return unidadTrabajoPersonalRepository.findUTPById(id);
	}

	@Override
	public UnidadTrabajoPersonal addUnidadTrabajoPersonal(UnidadTrabajoPersonal unidadTrabajoPersonal) {
		// TODO Auto-generated method stub
		return unidadTrabajoPersonalRepository.save(unidadTrabajoPersonal);
	}

}
