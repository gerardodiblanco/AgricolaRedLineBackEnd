package com.softdelsur.enologia.model;

public class EstadoGrupoBarricaModel {

	
	private String idEstadoGrupo;
	private String nombreEstadoGrupo;
	
	public EstadoGrupoBarricaModel() {
		super();
	}

	public EstadoGrupoBarricaModel(String idEstadoGrupo, String nombreEstadoGrupo) {
		super();
		this.idEstadoGrupo = idEstadoGrupo;
		this.nombreEstadoGrupo = nombreEstadoGrupo;
	}

	public String getIdEstadoGrupo() {
		return idEstadoGrupo;
	}

	public void setIdEstadoGrupo(String idEstadoGrupo) {
		this.idEstadoGrupo = idEstadoGrupo;
	}

	public String getNombreEstadoGrupo() {
		return nombreEstadoGrupo;
	}

	public void setNombreEstadoGrupo(String nombreEstadoGrupo) {
		this.nombreEstadoGrupo = nombreEstadoGrupo;
	}
	
	
	
}
