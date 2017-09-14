package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.model.CampoDTO;
import com.softdelsur.agricola.model.CampoModel;
import com.softdelsur.agricola.model.CampoModel2;

public interface CampoService {
	
	List<CampoModel> findCamposModel();
	
	
	List<CampoDTO> findCamposDTO();
	
	CampoModel addCampoModel(CampoModel campoModel);
	Campo addCampo(Campo campo);
	
	CampoModel findCampoByIdCampo(String id);
	
	//campoModel 2 
	List<CampoModel2> findCamposModel2();
	CampoModel2 findCampoByIdCampo2(String id);
	
	Campo findByIdCampo(String id);
	
}
