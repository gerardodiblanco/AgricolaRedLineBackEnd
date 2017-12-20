package com.softdelsur.agricola.model;

import java.util.ArrayList;
import java.util.List;

public class SectorModel {
	private String id;

	private int codigo;
	private String descripcion;

	private List<SectorDetalleModel> detalleList = new ArrayList<SectorDetalleModel>();

	private List<PersonalSectorModel> personalSectorList = new ArrayList<PersonalSectorModel>();

	public SectorModel() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<SectorDetalleModel> getDetalleList() {
		return detalleList;
	}

	public void setDetalleList(List<SectorDetalleModel> detalleList) {
		this.detalleList = detalleList;
	}

	public List<PersonalSectorModel> getPersonalSectorList() {
		return personalSectorList;
	}

	public void setPersonalSectorList(List<PersonalSectorModel> personalSectorList) {
		this.personalSectorList = personalSectorList;
	}

}
