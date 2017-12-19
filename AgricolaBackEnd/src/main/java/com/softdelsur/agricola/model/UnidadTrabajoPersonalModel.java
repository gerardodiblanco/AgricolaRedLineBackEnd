package com.softdelsur.agricola.model;

public class UnidadTrabajoPersonalModel {

	private String id;
	private String idPersonal;
	private String nombre;
	private String dni;
	private boolean checkbox;
	
	
	
	public UnidadTrabajoPersonalModel() {
		super();
	}


	public boolean isCheckbox() {
		return checkbox;
	}


	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getIdPersonal() {
		return idPersonal;
	}


	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	 
}
