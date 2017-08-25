package com.softdelsur.agricola.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.converter.CampoConverter;
import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.model.CampoModel;
import com.softdelsur.agricola.repository.CampoRepository;
import com.softdelsur.agricola.service.CampoService;

@Service("campoServiceImpl")
public class CampoServiceImpl implements CampoService {
	
	@Autowired
	@Qualifier("campoConverter")
	CampoConverter campoConverter;
	
	@Autowired
	@Qualifier("campoRepository")
	CampoRepository campoRepository;

	@Override
	public List<CampoModel> findCampos() {
		List<Campo> campoList = campoRepository.findAll();
		
 		return campoConverter.convertListEntityToListModel(campoList);
	}

	@Override
	public CampoModel addCampo(CampoModel campoModel) {
		Campo campo = campoConverter.convertCampoModelToCampo(campoModel);
		return campoConverter.convertCampoToCampoModel(campoRepository.save(campo));
	}

}
