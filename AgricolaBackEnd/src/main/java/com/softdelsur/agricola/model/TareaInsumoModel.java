package com.softdelsur.agricola.model;



public class TareaInsumoModel {
    private String id;
	private float cantConsumida;

	private InsumoModel insumo;

	public TareaInsumoModel() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getCantConsumida() {
		return cantConsumida;
	}

	public void setCantConsumida(float cantConsumida) {
		this.cantConsumida = cantConsumida;
	}

	public InsumoModel getInsumo() {
		return insumo;
	}

	public void setInsumo(InsumoModel insumo) {
		this.insumo = insumo;
	}
	
}
