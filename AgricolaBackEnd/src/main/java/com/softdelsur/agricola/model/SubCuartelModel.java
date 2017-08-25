package com.softdelsur.agricola.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

import com.softdelsur.agricola.entity.AtributoSubCuartel;
import com.softdelsur.agricola.entity.Caracteristica;
import com.softdelsur.agricola.entity.EstadoSubCuartel;
import com.softdelsur.agricola.entity.PeriodoVariedad;

public class SubCuartelModel {
    private String idSubCuartel;
	private int codigo;
	private String descripcion;
	private float hectarea;
	private EstadoSubCuartelModel estado;

	public List<AtributoSubCuartelModel> atributosSubCuartel = new ArrayList<AtributoSubCuartelModel>();
	
	public List<PeriodoVariedadModel> periodosVariedad = new ArrayList<PeriodoVariedadModel>();
	
	public List<CaracteristicaModel> caracteristicas = new ArrayList<CaracteristicaModel>();
	
	public SubCuartelModel() {
		super();
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

	public EstadoSubCuartelModel getEstado() {
		return estado;
	}
	public void setEstado(EstadoSubCuartelModel estado) {
		this.estado = estado;
	}
	public List<AtributoSubCuartelModel> getAtributosSubCuartel() {
		return atributosSubCuartel;
	}
	public void setAtributosSubCuartel(List<AtributoSubCuartelModel> atributosSubCuartel) {
		this.atributosSubCuartel = atributosSubCuartel;
	}
	public List<PeriodoVariedadModel> getPeriodosVariedad() {
		return periodosVariedad;
	}
	public void setPeriodosVariedad(List<PeriodoVariedadModel> periodosVariedad) {
		this.periodosVariedad = periodosVariedad;
	}
	public List<CaracteristicaModel> getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(List<CaracteristicaModel> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}


	
}
