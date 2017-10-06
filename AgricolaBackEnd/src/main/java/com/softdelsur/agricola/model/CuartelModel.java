package com.softdelsur.agricola.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.softdelsur.agricola.entity.Coordenada;
import com.softdelsur.agricola.entity.Domicilio;
import com.softdelsur.agricola.entity.EstadoCampo;
import com.softdelsur.agricola.entity.Proveedor;
import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.entity.TipoCampo;

public class CuartelModel {
	private String idCuartel;
	private int codigo;
	private String descripcion;
	private float hectarea;
	private int codigoCampo;
	private String cuitCampo;
	private float hectareaCampo;
	private String nombreCampo;
	private String tipoCampo;
	private String domicilioCampo;
	private String proveedorCampo;
	private List<CoordenadaModel> coordenadaList = new ArrayList<CoordenadaModel>();
	private String estadoCampo;
	
	private String idCampo;

	public CuartelModel() {

	}
	

	public String getIdCampo() {
		return idCampo;
	}


	public void setIdCampo(String idCampo) {
		this.idCampo = idCampo;
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

	public int getCodigoCampo() {
		return codigoCampo;
	}

	public void setCodigoCampo(int codigoCampo) {
		this.codigoCampo = codigoCampo;
	}

	public String getCuitCampo() {
		return cuitCampo;
	}

	public void setCuitCampo(String cuitCampo) {
		this.cuitCampo = cuitCampo;
	}

	public float getHectareaCampo() {
		return hectareaCampo;
	}

	public void setHectareaCampo(float hectareaCampo) {
		this.hectareaCampo = hectareaCampo;
	}

	public String getNombreCampo() {
		return nombreCampo;
	}

	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

	public String getTipoCampo() {
		return tipoCampo;
	}

	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	public String getDomicilioCampo() {
		return domicilioCampo;
	}

	public void setDomicilioCampo(String domicilioCampo) {
		this.domicilioCampo = domicilioCampo;
	}

	public String getProveedorCampo() {
		return proveedorCampo;
	}

	public void setProveedorCampo(String proveedorCampo) {
		this.proveedorCampo = proveedorCampo;
	}

	public List<CoordenadaModel> getCoordenadaList() {
		return coordenadaList;
	}

	public void setCoordenadaList(List<CoordenadaModel> coordenadaList) {
		this.coordenadaList = coordenadaList;
	}

	public String getEstadoCampo() {
		return estadoCampo;
	}

	public void setEstadoCampo(String estadoCampo) {
		this.estadoCampo = estadoCampo;
	}


}
