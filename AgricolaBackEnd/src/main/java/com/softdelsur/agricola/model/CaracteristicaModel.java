package com.softdelsur.agricola.model;

public class CaracteristicaModel {
	private String idCaracteristica;
	private int codigo;

	private int numeroCaracteristica;

	public TipoCaracteristicaModel tipoCaracteristica;

	public CaracteristicaModel() {
		super();
	}

	public String getIdCaracteristica() {
		return idCaracteristica;
	}

	public void setIdCaracteristica(String idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumeroCaracteristica() {
		return numeroCaracteristica;
	}

	public void setNumeroCaracteristica(int numeroCaracteristica) {
		this.numeroCaracteristica = numeroCaracteristica;
	}

	public TipoCaracteristicaModel getTipoCaracteristica() {
		return tipoCaracteristica;
	}

	public void setTipoCaracteristica(TipoCaracteristicaModel tipoCaracteristica) {
		this.tipoCaracteristica = tipoCaracteristica;
	}

}
