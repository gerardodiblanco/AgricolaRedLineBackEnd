package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.converter.TipoCampoConverter;
import com.softdelsur.agricola.entity.TipoCampo;
import com.softdelsur.agricola.model.TipoCampoModel;
import com.softdelsur.agricola.repository.TipoCampoRepository;
import com.softdelsur.agricola.service.TipoCampoService;
@Service("tipoCampoServiceImpl")
public class TipoCampoServiceImpl implements TipoCampoService {

	@Autowired
	@Qualifier("tipoCampoRepository")
	TipoCampoRepository tipoCampoRepository;
	
	@Autowired
	@Qualifier("tipoCampoConverter")
	TipoCampoConverter tipoCampoConverter;
	
	@Override
	public TipoCampoModel addTipoCampo(TipoCampoModel tipoCampoModel) {
		
		return tipoCampoConverter.convertTipoCampoToTipoCampoModel(tipoCampoRepository.save(tipoCampoConverter.convertTipoCampoModelToTipoCampo(tipoCampoModel)));
	}

	@Override
	public List<TipoCampoModel> findAll() {
		
		return tipoCampoConverter.convertListTipoCampoToTipoCampoModel(tipoCampoRepository.findAll());
	}

	@Override
	public TipoCampo findTipoCampoByNombre(String nombre) {
		
		return tipoCampoRepository.findByNombre(nombre);
	}

}
