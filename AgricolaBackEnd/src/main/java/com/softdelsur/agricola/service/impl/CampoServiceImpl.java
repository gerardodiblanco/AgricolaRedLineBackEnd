package com.softdelsur.agricola.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.converter.CampoConverter;
import com.softdelsur.agricola.converter.CampoConverter2;
import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.model.CampoDTO;
import com.softdelsur.agricola.model.CampoModel;
import com.softdelsur.agricola.model.CampoModel2;
import com.softdelsur.agricola.repository.CampoRepository;

import com.softdelsur.agricola.service.CampoService;

@Service("campoServiceImpl")
public class CampoServiceImpl implements CampoService {
	
	@Autowired
	@Qualifier("campoConverter")
	CampoConverter campoConverter;
	
	@Autowired
	@Qualifier("campoConverter2")
	CampoConverter2 campoConverter2;
	
	
	@Autowired
	@Qualifier("campoRepository")
	CampoRepository campoRepository;

	@Override
	public List<CampoModel> findCamposModel() {
		List<Campo> campoList = campoRepository.findAll();
		
 		return campoConverter.convertListEntityToListModel(campoList);
	}

	@Override
	public CampoModel addCampoModel(CampoModel campoModel) {
		Campo campo = campoConverter.convertCampoModelToCampo(campoModel);
		return campoConverter.convertCampoToCampoModel(campoRepository.save(campo));
	}

	@Override
	public List<CampoDTO> findCamposDTO() {
		System.out.println("dentro de findCamposDTO");
		return  campoConverter.convertListCampoToListCampoDTO(campoRepository.findAll());
	}

	@Override
	public CampoModel findCampoByIdCampo(String idCampo) {
		
		return campoConverter.convertCampoToCampoModel(campoRepository.findCampoByIdCampo(idCampo));
	}

	
	//campoModel 2
	@Override
	public List<CampoModel2> findCamposModel2() {
		List<Campo> campoList = campoRepository.findAll();
		
		 return campoConverter2.convertListEntityToListModel((campoList));
	}

	@Override
	public CampoModel2 findCampoByIdCampo2(String id) {
		
		return campoConverter2.convertCampoToCampoModel(campoRepository.findCampoByIdCampo(id));
	}

	@Override
	public Campo findByIdCampo(String id) {
		
		return campoRepository.findCampoByIdCampo(id);
	}

	@Override
	public Campo addCampo(Campo campo) {
		
		return campoRepository.save(campo);
	}

}
