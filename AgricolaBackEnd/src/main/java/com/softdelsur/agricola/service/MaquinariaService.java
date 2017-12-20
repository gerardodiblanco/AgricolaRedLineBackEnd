package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.Maquinaria;

public interface MaquinariaService {

	Maquinaria removeMaquinaria(String id);

	Maquinaria addMaquinaria(Maquinaria maquinaria);

	List<Maquinaria> findMaquinariasActivas();

	Maquinaria findMaquinariaById(String id);

}
