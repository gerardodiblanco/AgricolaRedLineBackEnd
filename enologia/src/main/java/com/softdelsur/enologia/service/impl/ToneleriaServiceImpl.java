package com.softdelsur.enologia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.softdelsur.enologia.converter.ToneleriaConverter;
import com.softdelsur.enologia.entity.Toneleria;
import com.softdelsur.enologia.model.ToneleriaModel;
import com.softdelsur.enologia.repository.ToneleriaRepository;
import com.softdelsur.enologia.service.ToneleriaService;

public class ToneleriaServiceImpl implements ToneleriaService{

	@Autowired
	@Qualifier("toneleriaConverter")
	ToneleriaConverter converterToneleria;
	
	@Autowired
	@Qualifier("toneleriaRepository")
	ToneleriaRepository toneleriaRepository;
	
	@Override
	public List<ToneleriaModel> listAllTonelerias() {
		List<Toneleria> tonelerias = toneleriaRepository.findAll();
		List<ToneleriaModel> toneleriasModel = new ArrayList<ToneleriaModel>();
		for (Toneleria toneleria : tonelerias) {
			toneleriasModel.add(converterToneleria.convertToneleriaToToneleriaModel(toneleria));
		}
		return toneleriasModel;
	}

	@Override
	public ToneleriaModel findByIdToneleria(String id) {
		
		return converterToneleria.convertToneleriaToToneleriaModel(toneleriaRepository.findByIdToneleria(id));
	}

	@Override
	public ToneleriaModel addToneleria(ToneleriaModel tModelNew) {
		Toneleria toneleria = converterToneleria.convertToneleriaModelToToneleria(tModelNew);
		
		return converterToneleria.convertToneleriaToToneleriaModel(toneleriaRepository.save(toneleria));
	}

}
