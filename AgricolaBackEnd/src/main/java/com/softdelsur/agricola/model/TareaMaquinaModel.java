package com.softdelsur.agricola.model;

public class TareaMaquinaModel {

	private String id;
	private float consumo;
	private int horasTrabajo;
	private double cantidad;

	private MaquinariaModel maquina;

	public TareaMaquinaModel() {
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

	public float getConsumo() {
		return consumo;
	}

	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}

	public int getHorasTrabajo() {
		return horasTrabajo;
	}

	public void setHorasTrabajo(int horasTrabajo) {
		this.horasTrabajo = horasTrabajo;
	}

	public MaquinariaModel getMaquina() {
		return maquina;
	}

	public void setMaquina(MaquinariaModel maquina) {
		this.maquina = maquina;
	}

}
