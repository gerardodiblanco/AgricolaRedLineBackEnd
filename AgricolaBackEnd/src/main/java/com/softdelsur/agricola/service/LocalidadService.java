package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.Localidad;
import com.softdelsur.agricola.model.LocalidadModel;

public interface LocalidadService {

	Localidad addLocalidad(Localidad localidad);

	Localidad findByNombreLocalidad(String nombre);

	List<LocalidadModel> findLocalidadesAll();

}
