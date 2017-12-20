package com.softdelsur.agricola.model;

public class CampoDTO {

	private String idCampo;

	private String cuit;
	private float hectarea;
	private String nombre;
	private String tipo;

	public String getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(String idCampo) {
		this.idCampo = idCampo;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public float getHectarea() {
		return hectarea;
	}

	public void setHectarea(float hectarea) {
		this.hectarea = hectarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
