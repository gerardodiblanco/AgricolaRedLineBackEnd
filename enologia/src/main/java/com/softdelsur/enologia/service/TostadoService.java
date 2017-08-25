package com.softdelsur.enologia.service;

import java.util.List;

import com.softdelsur.enologia.model.TostadoModel;

public interface TostadoService {

	public abstract List<TostadoModel> listAllTostado();
	public abstract TostadoModel findByIdTostado(String id);
	public abstract TostadoModel addTostado(TostadoModel tModel);
}
