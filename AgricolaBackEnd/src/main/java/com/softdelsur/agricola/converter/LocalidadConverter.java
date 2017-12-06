package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Localidad;
import com.softdelsur.agricola.model.LocalidadModel;

@Component("localidadConverter")
public class LocalidadConverter {
	public Localidad convertLocalidadModelToLocalidad(LocalidadModel localidadModel) {
		Localidad localidad = new Localidad();
		localidad.setIdLocalidad(localidadModel.getIdLocalidad());

		localidad.setNombre(localidadModel.getNombre());
		return localidad;

	}

	public LocalidadModel convertLocalidadToLocalidadModel(Localidad localidad) {
		LocalidadModel localidadModel = new LocalidadModel();
		localidadModel.setIdLocalidad(localidad.getIdLocalidad());

		localidadModel.setNombre(localidad.getNombre());
		return localidadModel;
	}

	public List<LocalidadModel> convertListLocalidadToListLocalidadModel(List<Localidad> localidadList) {
		List<LocalidadModel> localidadModelList = new ArrayList<LocalidadModel>();

		for (Localidad localidad : localidadList) {
			localidadModelList.add(convertLocalidadToLocalidadModel(localidad));
		}

		return localidadModelList;
	}

}
