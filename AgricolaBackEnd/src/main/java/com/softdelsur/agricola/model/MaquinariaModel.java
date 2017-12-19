package com.softdelsur.agricola.model;

public class MaquinariaModel {
	
    private String id;
	private int codigo;
	private String descripcion;
	private boolean checkbox;
	private int cantidad;
	
	public MaquinariaModel() {
		super();
	}
	
	
	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public boolean isCheckbox() {
		return checkbox;
	}


	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}


	public String getIdMaquina() {
		return id;
	}
	public void setIdMaquina(String idMaquina) {
		this.id = idMaquina;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
