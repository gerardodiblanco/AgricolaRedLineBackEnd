package com.softdelsur.agricola.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.Trato;
import com.softdelsur.agricola.repository.TratoRepository;
import com.softdelsur.agricola.service.TratoService;

@Service("tratoServiceImpl")
public class TratoServiceImpl implements TratoService{

	@Autowired
	@Qualifier("tratoRepository")
	TratoRepository tratoRepository;
	
	@Override
	public List<Trato> findTratosActivos() {
		// TODO Auto-generated method stub
		return tratoRepository.findTratosByFechaBaja(null);
	}

	@Override
	public Trato addTrato(Trato trato) {
		
		return tratoRepository.save(trato);
	}

	@Override
	public Trato findTratoById(String id) {
		// TODO Auto-generated method stub
		return tratoRepository.findTratoById(id);
	}

	@Override
	public Trato removeTrato(String id) {
		Trato trato = null;
		trato = tratoRepository.findTratoById(id);
		
		if(trato != null) {
		trato.setFechaBaja(Date.valueOf(LocalDate.now()));
		trato = addTrato(trato);
		}
		return trato;
	}
	
	
	

}
