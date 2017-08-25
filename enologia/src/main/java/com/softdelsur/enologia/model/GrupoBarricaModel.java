package com.softdelsur.enologia.model;

import java.util.ArrayList;
import java.util.List;

import com.softdelsur.enologia.model.EstadoGrupoBarricaModel;


public class GrupoBarricaModel extends ElementosConOperacionesEnologicasModel {

	private int codigoGrupo;
	private String descripcion;
	private EstadoGrupoBarricaModel estado;
	private List<BarricaModel> barricas = new ArrayList<BarricaModel>();
	
	public GrupoBarricaModel() {
		super();
	}

	public GrupoBarricaModel(int codigoGrupo, String descripcion,
			com.softdelsur.enologia.model.EstadoGrupoBarricaModel estado, List<BarricaModel> barricas) {
		super();
		this.codigoGrupo = codigoGrupo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.barricas = barricas;
	}

	public int getCodigoGrupo() {
		return codigoGrupo;
	}

	public void setCodigoGrupo(int codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EstadoGrupoBarricaModel getEstado() {
		return estado;
	}

	public void setEstado(EstadoGrupoBarricaModel estado) {
		this.estado = estado;
	}

	public List<BarricaModel> getBarricas() {
		return barricas;
	}

	public void setBarricas(List<BarricaModel> barricas) {
		this.barricas = barricas;
	}

	@Override
	public void operacionEnologica() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
