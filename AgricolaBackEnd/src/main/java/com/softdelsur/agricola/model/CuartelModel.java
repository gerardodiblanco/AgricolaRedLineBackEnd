package com.softdelsur.agricola.model;



import java.util.ArrayList;
import java.util.List;

import com.softdelsur.agricola.entity.SubCuartel;

public class CuartelModel {
    private String idCuartel;
private int codigo;
private String descripcion;
private float hectarea;
private List<SubCuartelModel> subcuarteles = new ArrayList<SubCuartelModel>();

public CuartelModel() {
	super();
}

public String getIdCuartel() {
	return idCuartel;
}

public void setIdCuartel(String idCuartel) {
	this.idCuartel = idCuartel;
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

public float getHectarea() {
	return hectarea;
}

public void setHectarea(float hectarea) {
	this.hectarea = hectarea;
}

public List<SubCuartelModel> getSubcuarteles() {
	return subcuarteles;
}

public void setSubcuarteles(List<SubCuartelModel> subcuarteles) {
	this.subcuarteles = subcuarteles;
}





}
