package com.softdelsur.enologia.service;

import java.util.List;

import com.softdelsur.enologia.model.OrigenModel;

public interface OrigenService {

	public abstract List<OrigenModel> findAllOrigenes();
	public abstract OrigenModel findByidOrigen(String id);
	public abstract OrigenModel addOrigen(OrigenModel oModel);
	
}
