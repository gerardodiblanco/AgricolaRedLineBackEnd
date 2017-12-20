package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.OrdenTrabajo;
import com.softdelsur.agricola.repository.OrdenTrabajoRepository;
import com.softdelsur.agricola.service.OrdenTrabajoService;

@Service("ordenTrabajoServiceImpl")
public class OrdenTrabajoServiceImpl implements OrdenTrabajoService {

	@Autowired
	@Qualifier("ordenTrabajoRepository")
	OrdenTrabajoRepository ordenTrabajoRepository;

	@Override
	public OrdenTrabajo findOrdenTrabajoById(String id) {
		// TODO Auto-generated method stub
		return ordenTrabajoRepository.findOrdenTrabajoById(id);
	}

	@Override
	public OrdenTrabajo addOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		// TODO Auto-generated method stub
		return ordenTrabajoRepository.save(ordenTrabajo);
	}

	@Override
	public List<OrdenTrabajo> findOrdenesTrabajosActivos() {
		// TODO Auto-generated method stub
		return ordenTrabajoRepository.findOrdenTrabajoByFechaBaja(null);
	}

}
