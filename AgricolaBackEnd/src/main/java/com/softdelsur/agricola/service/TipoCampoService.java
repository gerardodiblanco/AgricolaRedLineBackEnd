package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.TipoCampo;
import com.softdelsur.agricola.model.TipoCampoModel;

public interface TipoCampoService {

	TipoCampoModel addTipoCampo(TipoCampoModel tipoCampoModel);
	List<TipoCampoModel> findAll();
	
	TipoCampo findTipoCampoByNombre(String nombre);
}
