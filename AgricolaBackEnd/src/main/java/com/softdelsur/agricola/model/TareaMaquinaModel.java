package com.softdelsur.agricola.model;


public class TareaMaquinaModel {
	
    private String id;
	private float consumo;
	private int horasTrabajo;

	private MaquinaModel maquina;

	public TareaMaquinaModel() {
		super();
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

	public MaquinaModel getMaquina() {
		return maquina;
	}

	public void setMaquina(MaquinaModel maquina) {
		this.maquina = maquina;
	}
	
	

}
