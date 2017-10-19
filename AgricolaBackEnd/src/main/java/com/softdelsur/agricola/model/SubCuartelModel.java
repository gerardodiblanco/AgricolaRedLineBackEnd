package com.softdelsur.agricola.model;

import java.util.ArrayList;
import java.util.List;



public class SubCuartelModel {
	private String idSubCuartel;
	private int codigo;
	private String descripcion;
	private float hectarea;
	private String estado;
	private String nombreCampo;
	private String nombreCuartel;
	private String idCuartel;
	private List<AtributoSubCuartelModel> atributosSubCuartel = new ArrayList<AtributoSubCuartelModel>();
	private String variedad;
	private String colorVariedad;
	private String idVariedad;

	private List<CaracteristicaModel> caracteristicas = new ArrayList<CaracteristicaModel>();

	private List<CoordenadaModel> coordenadaList = new ArrayList<CoordenadaModel>();

	public SubCuartelModel() {
		super();
	}

	public List<CoordenadaModel> getCoordenadaList() {
		return coordenadaList;
	}

	public void setCoordenadaList(List<CoordenadaModel> coordenadaList) {
		this.coordenadaList = coordenadaList;
	}

	public String getIdSubCuartel() {
		return idSubCuartel;
	}

	public void setIdSubCuartel(String idSubCuartel) {
		this.idSubCuartel = idSubCuartel;
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

	public List<AtributoSubCuartelModel> getAtributosSubCuartel() {
		return atributosSubCuartel;
	}

	public void setAtributosSubCuartel(List<AtributoSubCuartelModel> atributosSubCuartel) {
		this.atributosSubCuartel = atributosSubCuartel;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

	public List<CaracteristicaModel> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<CaracteristicaModel> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getColorVariedad() {
		return colorVariedad;
	}

	public void setColorVariedad(String colorVariedad) {
		this.colorVariedad = colorVariedad;
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

	public String getIdVariedad() {
		return idVariedad;
	}

	public void setIdVariedad(String idVariedad) {
		this.idVariedad = idVariedad;
	}
	
	
	

}
