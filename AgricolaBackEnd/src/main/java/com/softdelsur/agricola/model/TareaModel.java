package com.softdelsur.agricola.model;

import java.util.ArrayList;
import java.util.List;




public class TareaModel {
    private String id;
	private int codigo;
	private String descripcion;
	private List<InsumoModel> insumos = new ArrayList<>();
	private List<TratoModel> tratos = new ArrayList<>();
	private List<MaquinariaModel> maquinarias = new ArrayList<>();
	private int cantidadPersonal;
	private TratoModel tratoModel;

	public TareaModel() {
		super();
	}
	
	public TratoModel getTratoModel() {
		return tratoModel;
	}


	public void setTratoModel(TratoModel tratoModel) {
		this.tratoModel = tratoModel;
	}


	public int getCantidadPersonal() {
		return cantidadPersonal;
	}


	public void setCantidadPersonal(int cantidadPersonal) {
		this.cantidadPersonal = cantidadPersonal;
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



	public List<InsumoModel> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<InsumoModel> insumos) {
		this.insumos = insumos;
	}

	public List<TratoModel> getTratos() {
		return tratos;
	}

	public void setTratos(List<TratoModel> tratos) {
		this.tratos = tratos;
	}

	public List<MaquinariaModel> getMaquinarias() {
		return maquinarias;
	}

	public void setMaquinarias(List<MaquinariaModel> maquinarias) {
		this.maquinarias = maquinarias;
	}

		
	
	
}
