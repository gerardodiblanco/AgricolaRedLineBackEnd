package com.softdelsur.agricola.model;

import javax.persistence.ManyToOne;

import com.softdelsur.agricola.entity.PersonalTarea;

public class DetalleParteDiarioModel {
    private String id;
    
	private int cantidad;
	
	public PersonalTareaModel personalTarea;

	public DetalleParteDiarioModel() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public PersonalTareaModel getPersonalTarea() {
		return personalTarea;
	}

	public void setPersonalTarea(PersonalTareaModel personalTarea) {
		this.personalTarea = personalTarea;
	}
	
	
}
