package com.softdelsur.agricola.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AtributoSubCuartelModel {

	private String idAtributoSubCuartel;
	private String idAtributo;
	private String idOpcion;
	private String idSubCuartel;
	private String nombreAtributo;
	private String nombreOpcion;
	private Timestamp fechaInicioAsignacion;
	private List<AtributoOpcionModel> atributoOpcionModelList = new ArrayList<>();

	public AtributoSubCuartelModel() {
		super();
	}

	public String getIdAtributo() {
		return idAtributo;
	}

	public void setIdAtributo(String idAtributo) {
		this.idAtributo = idAtributo;
	}

	public String getNombreAtributo() {
		return nombreAtributo;
	}

	public void setNombreAtributo(String nombreAtributo) {
		this.nombreAtributo = nombreAtributo;
	}

	public String getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(String idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getNombreOpcion() {
		return nombreOpcion;
	}

	public void setNombreOpcion(String nombreOpcion) {
		this.nombreOpcion = nombreOpcion;
	}

	public String getIdAtributoSubCuartel() {
		return idAtributoSubCuartel;
	}

	public void setIdAtributoSubCuartel(String idAtributoSubCuartel) {
		this.idAtributoSubCuartel = idAtributoSubCuartel;
	}

	public Timestamp getFechaInicioAsignacion() {
		return fechaInicioAsignacion;
	}

	public void setFechaInicioAsignacion(Timestamp fechaInicioAsignacion) {
		this.fechaInicioAsignacion = fechaInicioAsignacion;
	}

	public List<AtributoOpcionModel> getAtributoOpcionModelList() {
		return atributoOpcionModelList;
	}

	public void setAtributoOpcionModelList(List<AtributoOpcionModel> atributoOpcionModelList) {
		this.atributoOpcionModelList = atributoOpcionModelList;
	}

	public String getIdSubCuartel() {
		return idSubCuartel;
	}

	public void setIdSubCuartel(String idSubCuartel) {
		this.idSubCuartel = idSubCuartel;
	}

}
