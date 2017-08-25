package com.softdelsur.agricola.model;

import javax.persistence.Column;

public class RubroModel {
    private String idRubro;
   	private String descripcion;
  	private String nombreRubro;
  	
	public RubroModel() {
		super();
	}

	public RubroModel(String descripcion, String nombreRubro) {
		super();
		this.descripcion = descripcion;
		this.nombreRubro = nombreRubro;
	}

	public String getIdRubro() {
		return idRubro;
	}

	public void setIdRubro(String idRubro) {
		this.idRubro = idRubro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreRubro() {
		return nombreRubro;
	}

	public void setNombreRubro(String nombreRubro) {
		this.nombreRubro = nombreRubro;
	}
  	
  	
}
