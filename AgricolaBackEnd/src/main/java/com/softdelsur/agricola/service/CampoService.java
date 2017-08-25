package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.model.CampoModel;

public interface CampoService {
	
	List<CampoModel> findCampos();
	CampoModel addCampo(CampoModel campoModel);

}
