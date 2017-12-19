package com.softdelsur.agricola.model;



public class TareaInsumoModel {
    private String id;
	private float cantConsumida;
	private double cantidad;

	private InsumoModel insumo;

	public TareaInsumoModel() {
		super();
	}
	
	

	public double getCantidad() {
		return cantidad;
	}



	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
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
