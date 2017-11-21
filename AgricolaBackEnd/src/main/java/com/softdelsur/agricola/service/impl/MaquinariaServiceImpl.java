package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.Maquinaria;
import com.softdelsur.agricola.repository.MaquinariaRespository;
import com.softdelsur.agricola.service.MaquinariaService;

@Service("maquinariaServiceImpl")
public class MaquinariaServiceImpl implements MaquinariaService {
	
	@Autowired
	@Qualifier("maquinariaRepository")
	MaquinariaRespository maquinariaRepository;

	@Override
	public Maquinaria removeMaquinaria(String id) {
		Maquinaria maquinaria = null;
		maquinaria = maquinariaRepository.findMaquinariaById(id);
		if(maquinaria != null) {
			maquinaria.setEstadoMaquinaria(false);
			maquinaria = maquinariaRepository.save(maquinaria);
		
		}
		return maquinaria;
	}

	@Override
	public Maquinaria addMaquinaria(Maquinaria maquinaria) {
		
		return maquinariaRepository.save(maquinaria);
	}

	@Override
	public List<Maquinaria> findMaquinariasActivas() {
	
		return maquinariaRepository.findMaquinariasByEstadoMaquinaria(true);
	}

	@Override
	public Maquinaria findMaquinariaById(String id) {
		Maquinaria maquinaria = null;
		maquinaria = maquinariaRepository.findMaquinariaById(id);
		
		return maquinaria;
	}

}
