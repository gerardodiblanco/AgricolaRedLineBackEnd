package com.softdelsur.agricola.model;

public class UtilizacionRealMaquinaModel {
	private String id;
	private int cantHoras;
	private int consumo;

	public MaquinariaModel maquina;

	public UtilizacionRealMaquinaModel() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCantHoras() {
		return cantHoras;
	}

	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}

	public int getConsumo() {
		return consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	public MaquinariaModel getMaquina() {
		return maquina;
	}

	public void setMaquina(MaquinariaModel maquina) {
		this.maquina = maquina;
	}

}
