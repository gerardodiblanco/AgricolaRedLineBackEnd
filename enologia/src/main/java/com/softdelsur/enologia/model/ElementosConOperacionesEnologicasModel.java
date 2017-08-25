package com.softdelsur.enologia.model;

public abstract class  ElementosConOperacionesEnologicasModel {

	private String id;
	
	
	public abstract void operacionEnologica();


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	
}
