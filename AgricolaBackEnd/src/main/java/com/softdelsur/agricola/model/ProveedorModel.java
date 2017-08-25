package com.softdelsur.agricola.model;

public class ProveedorModel {
	private int codigo;
	private String descripcion;
	private String idProveedor;
	private String razonSocial;
	private EstadoProveedorModel estado;
	public ProveedorModel(){
		
	}
	public ProveedorModel(int codigo, String descripcion, String razonSocial, EstadoProveedorModel estado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.razonSocial = razonSocial;
		this.estado = estado;
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
	public String getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public EstadoProveedorModel getEstado() {
		return estado;
	}
	public void setEstado(EstadoProveedorModel estado) {
		this.estado = estado;
	}
	
	
}
