package com.softdelsur.enologia.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.softdelsur.enologia.converter.BarricaConverter;
import com.softdelsur.enologia.entity.Barrica;
import com.softdelsur.enologia.model.BarricaModel;
import com.softdelsur.enologia.repository.BarricaRepository;
import com.softdelsur.enologia.service.BarricaService;


public class BarricaServiceImpl implements BarricaService{
	
	@Autowired
	@Qualifier("barricaRepository")
	BarricaRepository barricaRepository;
	
	@Autowired 
	@Qualifier("barricaConverter")
	BarricaConverter converterBarrica;

	@Override
	public BarricaModel findBarricaById(String id) {
		
		return converterBarrica.convertBarricaToBarricaModel(barricaRepository.findBarricaByid(id));
	}

	@Override
	public BarricaModel findBarricaByCodigo(int codigo) {
		
		return converterBarrica.convertBarricaToBarricaModel(barricaRepository.findByCodigoBarrica(codigo));
	}

	@Override
	public List<BarricaModel> findAllBarricas(BarricaModel bModel) {
		List<Barrica> barricas = barricaRepository.findAll();
		List<BarricaModel> barricaModel = new ArrayList<BarricaModel>();
		for (Barrica barrica2 : barricas) {
			barricaModel.add(converterBarrica.convertBarricaToBarricaModel(barrica2));
		}
		return barricaModel;
	}

	@Override
	public BarricaModel addBarrica(BarricaModel barricaNew) {
		Barrica barrica = converterBarrica.convertBarricaModelToBarrica(barricaNew);
		BarricaModel barricaModel = converterBarrica.convertBarricaToBarricaModel(barricaRepository.save(barrica));
		return barricaModel;
	}

}
