package com.softdelsur.agricola.model;


public class DomicilioModel {
	private String idDomicilio;
	private String calle;
	private int dto;
	private int numero;
	private String otro;
	private int piso;
	private LocalidadModel localidad;

	public DomicilioModel() {
		super();
	}

	public String getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(String idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getDto() {
		return dto;
	}

	public void setDto(int dto) {
		this.dto = dto;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getOtro() {
		return otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public LocalidadModel getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadModel localidad) {
		this.localidad = localidad;
	}

}
