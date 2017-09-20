package com.softdelsur.agricola.model;

import java.util.ArrayList;
import java.util.List;

import com.softdelsur.agricola.entity.Campo;

public class CampoModel {

    private String idCampo;
    

private int codigo;
private String CUIT;
private float hectarea;
private String nombre;

//tipoCampo
private String tipo;

//domicilio
private String calle;

private int numeroDomicilio;

//localidad

private String localidad;

//proveedor

  private String proveedorRazonSocial;




private List<CuartelModel> cuartelList = new ArrayList<CuartelModel>();
private List<CoordenadaModel> coordenadaList = new ArrayList<CoordenadaModel>();

public CampoModel() {
	super();
}

public String getIdCampo() {
	return idCampo;
}

public void setIdCampo(String idCampo) {
	this.idCampo = idCampo;
}

public int getCodigo() {
	return codigo;
}

public void setCodigo(int codigo) {
	this.codigo = codigo;
}

public String getCUIT() {
	return CUIT;
}

public void setCUIT(String cUIT) {
	CUIT = cUIT;
}

public float getHectarea() {
	return hectarea;
}

public void setHectarea(float hectarea) {
	this.hectarea = hectarea;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}


public String getCalle() {
	return calle;
}

public void setCalle(String calle) {
	this.calle = calle;
}

public int getNumeroDomicilio() {
	return numeroDomicilio;
}

public void setNumeroDomicilio(int numeroDomicilio) {
	this.numeroDomicilio = numeroDomicilio;
}

public String getLocalidad() {
	return localidad;
}

public void setLocalidad(String localidad) {
	this.localidad = localidad;
}

public List<CuartelModel> getCuartelList() {
	return cuartelList;
}

public void setCuartelList(List<CuartelModel> cuartelList) {
	this.cuartelList = cuartelList;
}

public List<CoordenadaModel> getCoordenadaList() {
	return coordenadaList;
}

public void setCoordenadaList(List<CoordenadaModel> coordenadaList) {
	this.coordenadaList = coordenadaList;
}

public String getProveedorRazonSocial() {
	return proveedorRazonSocial;
}

public void setProveedorRazonSocial(String proveedorRazonSocial) {
	this.proveedorRazonSocial = proveedorRazonSocial;
}



}


