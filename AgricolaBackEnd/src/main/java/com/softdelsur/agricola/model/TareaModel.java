package com.softdelsur.agricola.model;

import java.util.ArrayList;
import java.util.List;




public class TareaModel {
    private String id;
	private int codigo;
	private String descripcion;

	private List<TareaInsumoModel> insumosTarea = new ArrayList<TareaInsumoModel>();

	private List<TareaMaquinaModel> maquinasTarea =  new ArrayList<TareaMaquinaModel>();

	public TareaModel() {
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

	public List<TareaInsumoModel> getInsumosTarea() {
		return insumosTarea;
	}

	public void setInsumosTarea(List<TareaInsumoModel> insumosTarea) {
		this.insumosTarea = insumosTarea;
	}

	public List<TareaMaquinaModel> getMaquinasTarea() {
		return maquinasTarea;
	}

	public void setMaquinasTarea(List<TareaMaquinaModel> maquinasTarea) {
		this.maquinasTarea = maquinasTarea;
	}
	
	
	
}
