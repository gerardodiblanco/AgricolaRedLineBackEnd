package com.softdelsur.agricola.model;

public class MaquinaModel {
    private String idMaquina;
	private int codigo;
	private String descripcion;
	public MaquinaModel() {
		super();
	}
	public String getIdMaquina() {
		return idMaquina;
	}
	public void setIdMaquina(String idMaquina) {
		this.idMaquina = idMaquina;
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
