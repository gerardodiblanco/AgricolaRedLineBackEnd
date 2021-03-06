package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.Atributo;
import com.softdelsur.agricola.model.AtributoConOpcionesModel;

public interface AtributoService {

	Atributo findAtributoById(String id);

	Atributo addAtributo(Atributo atributo);

	List<Atributo> findAtributosActivos();

	Atributo eliminarAtributo(String id);

	List<AtributoConOpcionesModel> findAtributosActivosConOpciones();
}
