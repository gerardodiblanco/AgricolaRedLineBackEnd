package com.softdelsur.agricola.model;

import java.util.ArrayList;
import java.util.List;

public class UnidadTrabajoSubCuartelModel {

	
	private String idUnidadTrabajoSubCuartel;
	
	private String id;
	private int codigoSubCuartel;
	private String descripcion;
	private float hectarea;
	private String estado;
	private String nombreCampo;
	private String nombreCuartel;
	private String idCuartel;
	private String variedad;
	
	public UnidadTrabajoSubCuartelModel() {
		super();
	}

	public String getIdUnidadTrabajoSubCuartel() {
		return idUnidadTrabajoSubCuartel;
	}

	public void setIdUnidadTrabajoSubCuartel(String idUnidadTrabajoSubCuartel) {
		this.idUnidadTrabajoSubCuartel = idUnidadTrabajoSubCuartel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCodigoSubCuartel() {
		return codigoSubCuartel;
	}

	public void setCodigoSubCuartel(int codigoSubCuartel) {
		this.codigoSubCuartel = codigoSubCuartel;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreCampo() {
		return nombreCampo;
	}

	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

	public String getNombreCuartel() {
		return nombreCuartel;
	}

	public void setNombreCuartel(String nombreCuartel) {
		this.nombreCuartel = nombreCuartel;
	}

	public String getIdCuartel() {
		return idCuartel;
	}

	public void setIdCuartel(String idCuartel) {
		this.idCuartel = idCuartel;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

	


}
