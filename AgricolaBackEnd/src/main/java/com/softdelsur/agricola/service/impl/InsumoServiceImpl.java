package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.mockito.exceptions.misusing.UnfinishedStubbingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.Insumo;
import com.softdelsur.agricola.repository.InsumoRepository;
import com.softdelsur.agricola.service.InsumoService;

@Service("insumoServiceImpl")
public class InsumoServiceImpl implements InsumoService{

	
	@Autowired
	@Qualifier("insumoRepository")
	InsumoRepository insumoRepository;
	
	@Override
	public List<Insumo> findInsumosActivos() {
		
		return insumoRepository.findInsumosByEstado(true);
	}

	@Override
	public Insumo addInsumo(Insumo insumo) {
		
		return insumoRepository.save(insumo);
	}

	@Override
	public Insumo findInsumoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Insumo removeInsumo(String id) {
		Insumo insumo = null;
		insumo = insumoRepository.findInsumoByIdInsumo(id);
		if(insumo != null) {
			insumo.setEstado(false);
			insumo = addInsumo(insumo);
		}
		return insumo;
	}

	
}
