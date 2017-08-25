package com.softdelsur.enologia.service;

import java.util.List;

import com.softdelsur.enologia.model.ToneleriaModel;

public interface ToneleriaService {

	public abstract List<ToneleriaModel> listAllTonelerias();
	public abstract ToneleriaModel findByIdToneleria(String id);
	public abstract ToneleriaModel addToneleria(ToneleriaModel tModel);
}
