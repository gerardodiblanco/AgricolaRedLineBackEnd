package com.softdelsur.enologia.model;

public class ToneleriaModel {

	
	private String idToneleria;
	private int codigo;
	private String descripcion;
	
	public ToneleriaModel() {
		super();
	}

	public ToneleriaModel(int codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getIdToneleria() {
		return idToneleria;
	}

	public void setIdToneleria(String idToneleria) {
		this.idToneleria = idToneleria;
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
