package com.softdelsur.enologia.model;


public class EstadoBarricaModel {
	
	private String idEstadoBarrica;;
	private String nombreEstadoBarrica;
	
	
	public EstadoBarricaModel() {
		super();
	}
	public EstadoBarricaModel(String idEstadoBarrica, String nombreEstadoBarrica) {
		super();
		this.idEstadoBarrica = idEstadoBarrica;
		this.nombreEstadoBarrica = nombreEstadoBarrica;
	}
	
	public String getIdEstadoBarrica() {
		return idEstadoBarrica;
	}
	public void setIdEstadoBarrica(String idEstadoBarrica) {
		this.idEstadoBarrica = idEstadoBarrica;
	}
	public String getNombreEstadoBarrica() {
		return nombreEstadoBarrica;
	}
	public void setNombreEstadoBarrica(String nombreEstadoBarrica) {
		this.nombreEstadoBarrica = nombreEstadoBarrica;
	}
	

	
}
