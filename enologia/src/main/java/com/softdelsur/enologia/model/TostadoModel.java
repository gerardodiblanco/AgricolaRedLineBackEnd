package com.softdelsur.enologia.model;

public class TostadoModel {

	private String idTostado;
	private int codigo;
	private String descripcion;
	
	public TostadoModel() {
		super();
	}

	public TostadoModel(int codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getIdTostado() {
		return idTostado;
	}

	public void setIdTostado(String idTostado) {
		this.idTostado = idTostado;
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
