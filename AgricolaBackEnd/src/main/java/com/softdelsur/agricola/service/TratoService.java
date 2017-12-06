package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.Trato;

public interface TratoService {

	List<Trato> findTratosActivos();

	Trato addTrato(Trato trato);

	Trato findTratoById(String id);

	Trato removeTrato(String id);

}
