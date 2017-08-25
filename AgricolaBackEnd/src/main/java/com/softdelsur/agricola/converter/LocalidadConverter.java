package com.softdelsur.agricola.converter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.RequestToViewNameTranslator;

import com.softdelsur.agricola.entity.Localidad;
import com.softdelsur.agricola.model.LocalidadModel;

@Component("localidadConverter")
public class LocalidadConverter {
	public Localidad convertLocalidadModelToLocalidad(LocalidadModel localidadModel){
		Localidad localidad = new Localidad();
		localidad.setIdLocalidad(localidadModel.getIdLocalidad());
		localidad.setCodPostal(localidadModel.getCodPostal());
		localidad.setNombreLocalidad(localidadModel.getIdLocalidad());
		return localidad;
		
	}
	public LocalidadModel convertLocalidadToLocalidadModel(Localidad localidad){
		LocalidadModel localidadModel = new LocalidadModel();
		localidadModel.setIdLocalidad(localidad.getIdLocalidad());
		localidadModel.setCodPostal(localidad.getCodPostal());
		localidadModel.setNombreLocalidad(localidad.getNombreLocalidad());
		return localidadModel;
	}

}
