package com.softdelsur.agricola.model;

public class InsumoModel {
	private String id;

	private int codigo;
	private String descripcion;
	private String unidadMedida;
	private boolean checkbox;

	public InsumoModel() {
		super();
	}

	public boolean isCheckbox() {
		return checkbox;
	}

	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
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

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

}
