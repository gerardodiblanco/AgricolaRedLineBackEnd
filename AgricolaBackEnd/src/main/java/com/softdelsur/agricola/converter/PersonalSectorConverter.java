package com.softdelsur.agricola.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.PersonalSector;
import com.softdelsur.agricola.model.PersonalSectorModel;

@Component("personalSectorConverter")
public class PersonalSectorConverter {
	@Autowired
	@Qualifier("personalConverter")
	PersonalConverter personalConverter;

	public PersonalSector convertModelToEntity(PersonalSectorModel personalSectorModel) {
		PersonalSector personalSector = new PersonalSector();
		personalSector.setId(personalSectorModel.getId());
		personalSector.setFechaAsignacion(personalSectorModel.getFechaAsignacion());
		personalSector.setFechaDesAsignacion(personalSectorModel.getFechaDesAsignacion());

		personalSector.setPersonal(personalConverter.convertModelToEntity(personalSectorModel.getPersonal()));

		return personalSector;
	}

	public PersonalSectorModel convertEntityToModel(PersonalSector personalSector) {
		PersonalSectorModel personalSectorModel = new PersonalSectorModel();
		personalSectorModel.setId(personalSector.getId());
		personalSectorModel.setFechaAsignacion(personalSector.getFechaAsignacion());
		personalSectorModel.setFechaDesAsignacion(personalSector.getFechaDesAsignacion());

		personalSectorModel.setPersonal(personalConverter.convertEntityToModel(personalSector.getPersonal()));

		return personalSectorModel;
	}

}
