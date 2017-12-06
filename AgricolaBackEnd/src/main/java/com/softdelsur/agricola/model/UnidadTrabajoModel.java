package com.softdelsur.agricola.model;

import java.util.ArrayList;
import java.util.List;

import com.softdelsur.agricola.entity.UnidadTrabajoDeposito;
import com.softdelsur.agricola.entity.UnidadTrabajoPersonal;

public class UnidadTrabajoModel {

	private String id;
	private String nombre;
	private List<UnidadTrabajoSubCuartelModel> subCuarteles = new ArrayList<>();
	private List<UnidadTrabajoPersonalModel> personaless = new ArrayList<>();
	private List<UnidadTrabajoDepositoModel> depositos = new ArrayList<>();
	
	public UnidadTrabajoModel() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<UnidadTrabajoSubCuartelModel> getSubCuarteles() {
		return subCuarteles;
	}

	public void setSubCuarteles(List<UnidadTrabajoSubCuartelModel> subCuarteles) {
		this.subCuarteles = subCuarteles;
	}

	public List<UnidadTrabajoPersonalModel> getPersonaless() {
		return personaless;
	}

	public void setPersonaless(List<UnidadTrabajoPersonalModel> personaless) {
		this.personaless = personaless;
	}

	public List<UnidadTrabajoDepositoModel> getDepositos() {
		return depositos;
	}

	public void setDepositos(List<UnidadTrabajoDepositoModel> depositos) {
		this.depositos = depositos;
	}


	
	
	
}
