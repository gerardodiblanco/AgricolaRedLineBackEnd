package com.softdelsur.enologia.service;

import java.util.List;

import com.softdelsur.enologia.model.BarricaModel;

public interface BarricaService {
	
	public abstract BarricaModel findBarricaById(String id);
	public abstract BarricaModel findBarricaByCodigo(int codigo);
	public abstract List<BarricaModel> findAllBarricas(BarricaModel bModel);
	public abstract BarricaModel addBarrica(BarricaModel bModel);
}
