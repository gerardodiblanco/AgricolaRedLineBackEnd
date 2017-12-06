package com.softdelsur.agricola.model;


public class EstadoProveedorModel {
	private String idEstadoProveedor;
	private String nombreEstadoProveedor;

	public EstadoProveedorModel() {
		super();
	}

	public EstadoProveedorModel(String nombreEstadoProveedor) {
		super();
		this.nombreEstadoProveedor = nombreEstadoProveedor;
	}

	public String getIdEstadoProveedor() {
		return idEstadoProveedor;
	}

	public void setIdEstadoProveedor(String idEstadoProveedor) {
		this.idEstadoProveedor = idEstadoProveedor;
	}

	public String getNombreEstadoProveedor() {
		return nombreEstadoProveedor;
	}

	public void setNombreEstadoProveedor(String nombreEstadoProveedor) {
		this.nombreEstadoProveedor = nombreEstadoProveedor;
	}

}
