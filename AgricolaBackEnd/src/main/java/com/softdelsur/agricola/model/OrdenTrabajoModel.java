package com.softdelsur.agricola.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrdenTrabajoModel {

	private String id;
	private String descripcion;
	private UnidadTrabajoModel unidadTrabajo;
	private Date fechaAlta;

	private List<TareaModel> tareaModelList = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UnidadTrabajoModel getUnidadTrabajo() {
		return unidadTrabajo;
	}

	public void setUnidadTrabajo(UnidadTrabajoModel unidadTrabajo) {
		this.unidadTrabajo = unidadTrabajo;
	}

	public List<TareaModel> getTareaModelList() {
		return tareaModelList;
	}

	public void setTareaModelList(List<TareaModel> tareaModelList) {
		this.tareaModelList = tareaModelList;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}
