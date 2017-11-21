package com.softdelsur.agricola.model;

import javax.persistence.ManyToOne;

import com.softdelsur.agricola.entity.UnidadMedida;

public class InsumoModel {
    private String idInsumo;
    
	private int codigo;
	private String descripcion;
	
	public String unidadMedida;

	public InsumoModel() {
		super();
	}

	public String getIdInsumo() {
		return idInsumo;
	}

	public void setIdInsumo(String idInsumo) {
		this.idInsumo = idInsumo;
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

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	
}
