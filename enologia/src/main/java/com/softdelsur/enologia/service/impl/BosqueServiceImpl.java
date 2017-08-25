package com.softdelsur.enologia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.softdelsur.enologia.converter.BosqueConverter;
import com.softdelsur.enologia.entity.Bosque;
import com.softdelsur.enologia.model.BosqueModel;
import com.softdelsur.enologia.repository.BosqueRepository;
import com.softdelsur.enologia.service.BosqueService;

public class BosqueServiceImpl implements BosqueService{

	@Autowired
	@Qualifier("bosqueRepository")
	BosqueRepository bosqueRepository;
	
	@Autowired
	@Qualifier("bosqueConverter")
	BosqueConverter converterBosque;
	
	@Override
	public List<BosqueModel> listAllBosque() {
		List<BosqueModel> bosqueModel = new ArrayList<BosqueModel>();
		List<Bosque> bosque = bosqueRepository.findAll();
		
		for (Bosque bosque2 : bosque) {
			bosqueModel.add(converterBosque.convertBosqueToBosqueModel(bosque2));
		}
		return bosqueModel;
	}

	@Override
	public BosqueModel addBoque(BosqueModel bosqueNew) {
		Bosque bosque = converterBosque.convertBosqueModelToBosque(bosqueNew);
		BosqueModel bosqueModel = converterBosque.convertBosqueToBosqueModel(bosqueRepository.save(bosque));
		return bosqueModel;
	}

}
