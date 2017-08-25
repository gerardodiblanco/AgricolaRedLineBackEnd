package com.softdelsur.agricola.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Domicilio;
import com.softdelsur.agricola.model.DomicilioModel;

@Component("domicilioConverter")
public class DomicilioConverter {
	@Autowired
	@Qualifier("localidadConverter")
	LocalidadConverter localidadConverter;
	public Domicilio convertDomicilioModelToDomicilio(DomicilioModel domicilioModel){
	Domicilio domicilio = new Domicilio();
	domicilio.setIdDomicilio(domicilioModel.getIdDomicilio());
	domicilio.setCalle(domicilioModel.getCalle());
	domicilio.setDto(domicilioModel.getDto());
	domicilio.setNumero(domicilioModel.getNumero());
	domicilio.setOtro(domicilioModel.getOtro());
	domicilio.setPiso(domicilioModel.getPiso());
	domicilio.setLocalidad(localidadConverter.convertLocalidadModelToLocalidad(domicilioModel.getLocalidad()));
	return domicilio;
	}
	public DomicilioModel convertDomicilioToDomicilioModel(Domicilio domicilio){
		DomicilioModel domicilioModel = new DomicilioModel();
		domicilioModel.setIdDomicilio(domicilio.getIdDomicilio());
		domicilioModel.setCalle(domicilio.getCalle());
		domicilioModel.setDto(domicilio.getDto());
		domicilioModel.setNumero(domicilio.getNumero());
		domicilioModel.setOtro(domicilio.getOtro());
		domicilioModel.setPiso(domicilio.getPiso());
		domicilioModel.setLocalidad(localidadConverter.convertLocalidadToLocalidadModel(domicilio.getLocalidad()));
		return domicilioModel;
	}

}
