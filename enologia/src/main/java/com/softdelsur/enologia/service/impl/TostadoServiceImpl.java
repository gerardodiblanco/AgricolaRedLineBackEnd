package com.softdelsur.enologia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.enologia.converter.TostadoConverter;
import com.softdelsur.enologia.entity.Tostado;
import com.softdelsur.enologia.model.TostadoModel;
import com.softdelsur.enologia.repository.TostadoRepository;
import com.softdelsur.enologia.service.TostadoService;

@Service("tostadoServiceImpl")
public class TostadoServiceImpl implements TostadoService {

	@Autowired
	@Qualifier("tostadoRepository")
	TostadoRepository tostadoRepository;
	
	@Autowired
	@Qualifier("tostadoConverter")
	TostadoConverter converterTostado;
	
	@Override
	public List<TostadoModel> listAllTostado() {
		List<Tostado> tostados = tostadoRepository.findAll();
		List<TostadoModel> tostadoModel = new ArrayList<TostadoModel>();
		
		for (Tostado tostado : tostados) {
			tostadoModel.add(converterTostado.convertTostadoToTostadoModel(tostado));
			
		}
		return tostadoModel;
	}

	@Override
	public TostadoModel findByIdTostado(String id) {
		return converterTostado.convertTostadoToTostadoModel(tostadoRepository.findTostadoByidTostado(id));
	}

	@Override
	public TostadoModel addTostado(TostadoModel tModelNew) {
		Tostado tostado = converterTostado.convertTostadoModelToTostado(tModelNew);
		
		return converterTostado.convertTostadoToTostadoModel(tostadoRepository.save(tostado));
	}

	
	
}
