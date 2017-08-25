package com.softdelsur.enologia.model;

public class BosqueModel {

	private String idBosque;
	private int codigo;
	private String descripcion;
	
	public BosqueModel() {
		super();
	}

	public BosqueModel(int codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getIdBosque() {
		return idBosque;
	}

	public void setIdBosque(String idBosque) {
		this.idBosque = idBosque;
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
