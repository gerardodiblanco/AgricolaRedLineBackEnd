package com.softdelsur.agricola.model;

import javax.persistence.ManyToOne;

import com.softdelsur.agricola.entity.Insumo;

public class ConsumoRealInsumoModel {

    private String id;
	
private int cantidad;

private InsumoModel insumo;
public ConsumoRealInsumoModel() {
	super();
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public InsumoModel getInsumo() {
	return insumo;
}
public void setInsumo(InsumoModel insumo) {
	this.insumo = insumo;
}


}
