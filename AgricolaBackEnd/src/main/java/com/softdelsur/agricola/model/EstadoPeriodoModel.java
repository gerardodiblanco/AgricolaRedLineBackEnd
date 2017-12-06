package com.softdelsur.agricola.model;

public class EstadoPeriodoModel {
	private String idEStado;

	private String nombreEstadoPeriodo;

	public EstadoPeriodoModel() {
		super();
	}

	public EstadoPeriodoModel(String nombreEstadoPeriodo) {
		super();
		this.nombreEstadoPeriodo = nombreEstadoPeriodo;
	}

	public String getIdEStado() {
		return idEStado;
	}

	public void setIdEStado(String idEStado) {
		this.idEStado = idEStado;
	}

	public String getNombreEstadoPeriodo() {
		return nombreEstadoPeriodo;
	}

	public void setNombreEstadoPeriodo(String nombreEstadoPeriodo) {
		this.nombreEstadoPeriodo = nombreEstadoPeriodo;
	}

}
