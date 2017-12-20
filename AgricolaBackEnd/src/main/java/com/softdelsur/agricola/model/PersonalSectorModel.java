package com.softdelsur.agricola.model;

import java.util.Date;

public class PersonalSectorModel {
	private String id;

	private Date fechaAsignacion;
	private Date fechaDesAsignacion;
	private PersonalModel personal;

	public PersonalSectorModel() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Date getFechaDesAsignacion() {
		return fechaDesAsignacion;
	}

	public void setFechaDesAsignacion(Date fechaDesAsignacion) {
		this.fechaDesAsignacion = fechaDesAsignacion;
	}

	public PersonalModel getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalModel personal) {
		this.personal = personal;
	}

}
