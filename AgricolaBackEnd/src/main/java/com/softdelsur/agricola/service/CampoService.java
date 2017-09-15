package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.model.CampoDTO;
import com.softdelsur.agricola.model.CampoModel;
import com.softdelsur.agricola.model.CampoModel;

public interface CampoService {
	
		
	
	List<CampoDTO> findCamposDTOPorEstado(String nombreEstado);
	

	Campo addCampo(Campo campo);
	
	//CampoModel findCampoByIdCampo(String id);
	
	//campoModel 2 
	List<CampoModel> findCamposModel();
	CampoModel findCampoByIdCampo(String id);
	
	Campo findByIdCampo(String id);
	
	String eliminarCampo(String id); 
	
}
