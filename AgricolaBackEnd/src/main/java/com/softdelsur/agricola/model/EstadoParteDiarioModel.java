package com.softdelsur.agricola.model;

import javax.persistence.Column;

public class EstadoParteDiarioModel {
    private String idEstadoParteDiario;
	private int codigo;
	private String nombreEstado;
	public EstadoParteDiarioModel() {
		super();
	}
	public String getIdEstadoParteDiario() {
		return idEstadoParteDiario;
	}
	public void setIdEstadoParteDiario(String idEstadoParteDiario) {
		this.idEstadoParteDiario = idEstadoParteDiario;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombreEstado() {
		return nombreEstado;
	}
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
	
}
