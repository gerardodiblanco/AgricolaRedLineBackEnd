package com.softdelsur.agricola.model;

public class TipoCampoModel {

    private String idTipo;
private int codigo;
private int descripcion;
	public TipoCampoModel(){
		
	}
	public TipoCampoModel(int codigo, int descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	public String getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}
	
}
