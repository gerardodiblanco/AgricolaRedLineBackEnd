package com.softdelsur.enologia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.softdelsur.enologia.converter.OrigenConverter;
import com.softdelsur.enologia.entity.Origen;
import com.softdelsur.enologia.model.OrigenModel;
import com.softdelsur.enologia.repository.OrigenRepository;
import com.softdelsur.enologia.service.OrigenService;

public class OrigenServiceImpl implements OrigenService{

	@Autowired
	@Qualifier("origenConverter")
	OrigenConverter converterOrigen;
	
	@Autowired
	@Qualifier("origenRepository")
	OrigenRepository origenRepository;
	
	
	
	@Override
	public List<OrigenModel> findAllOrigenes() {
		
		List<Origen> origenes = origenRepository.findAll();
		List<OrigenModel> origenesModel = new ArrayList<OrigenModel>();
		
		for (Origen origen : origenes) {
			origenesModel.add(converterOrigen.convertOrigenToOrigenModel(origen));
		}
		return origenesModel;
	}

	@Override
	public OrigenModel findByidOrigen(String id) {
	
		return converterOrigen.convertOrigenToOrigenModel(origenRepository.findByidOrigen(id));
	}

	@Override
	public OrigenModel addOrigen(OrigenModel oModelNew) {
		Origen origen = converterOrigen.convertOrigenModelToOrigen(oModelNew);
		
		return converterOrigen.convertOrigenToOrigenModel(origenRepository.save(origen));
	}

}
