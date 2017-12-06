package com.softdelsur.agricola.model;

public class TipoCaracteristicaModel {

	private String idTipoCaracteristica;
	private int codigo;

	private String nombreCaracteristica;

	public TipoCaracteristicaModel() {
		super();
	}

	public String getIdTipoCaracteristica() {
		return idTipoCaracteristica;
	}

	public void setIdTipoCaracteristica(String idTipoCaracteristica) {
		this.idTipoCaracteristica = idTipoCaracteristica;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombreCaracteristica() {
		return nombreCaracteristica;
	}

	public void setNombreCaracteristica(String nombreCaracteristica) {
		this.nombreCaracteristica = nombreCaracteristica;
	}

}
