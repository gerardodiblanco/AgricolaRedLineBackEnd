package com.softdelsur.agricola.model;

public class MaquinariaModel {
    private String id;
	private int codigo;
	private String descripcion;
	public MaquinariaModel() {
		super();
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
