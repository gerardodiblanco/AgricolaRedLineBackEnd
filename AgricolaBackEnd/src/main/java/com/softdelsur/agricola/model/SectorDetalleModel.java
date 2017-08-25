package com.softdelsur.agricola.model;

import java.util.ArrayList;
import java.util.List;



public class SectorDetalleModel {

    private String id;
    
	private int codigo;
	private String descripcion;

	private SubCuartelModel subcuartel;

	private List<TareaDetalleSectorModel> tareasDetalle = new ArrayList<TareaDetalleSectorModel>();

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

	public SubCuartelModel getSubcuartel() {
		return subcuartel;
	}

	public void setSubcuartel(SubCuartelModel subcuartel) {
		this.subcuartel = subcuartel;
	}

	public List<TareaDetalleSectorModel> getTareasDetalle() {
		return tareasDetalle;
	}

	public void setTareasDetalle(List<TareaDetalleSectorModel> tareasDetalle) {
		this.tareasDetalle = tareasDetalle;
	}


	
}
