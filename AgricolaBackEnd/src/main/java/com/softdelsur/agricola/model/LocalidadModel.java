package com.softdelsur.agricola.model;

import javax.persistence.Column;

public class LocalidadModel {
    private String idLocalidad;
   
private int codPostal;
   
private String nombreLocalidad;

public LocalidadModel() {
	super();
}

public LocalidadModel(int codPostal, String nombreLocalidad) {
	super();
	this.codPostal = codPostal;
	this.nombreLocalidad = nombreLocalidad;
}

public String getIdLocalidad() {
	return idLocalidad;
}

public void setIdLocalidad(String idLocalidad) {
	this.idLocalidad = idLocalidad;
}

public int getCodPostal() {
	return codPostal;
}

public void setCodPostal(int codPostal) {
	this.codPostal = codPostal;
}

public String getNombreLocalidad() {
	return nombreLocalidad;
}

public void setNombreLocalidad(String nombreLocalidad) {
	this.nombreLocalidad = nombreLocalidad;
}

}
