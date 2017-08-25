package com.softdelsur.agricola.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.softdelsur.agricola.entity.DetalleParteDiario;
import com.softdelsur.agricola.entity.EstadoParteDiario;
import com.softdelsur.agricola.entity.Periodo;

public class ParteDiarioModel {

    private String idParteDiario;
	private int codigo;
	private Date Fecha;
	
	public List<DetalleParteDiarioModel> detallesParteDiario = new ArrayList<DetalleParteDiarioModel>();
	
	public EstadoParteDiarioModel estadoParteDiario;
	
	public PeriodoModel periodo;

	public ParteDiarioModel() {
		super();
	}

	public String getIdParteDiario() {
		return idParteDiario;
	}

	public void setIdParteDiario(String idParteDiario) {
		this.idParteDiario = idParteDiario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public List<DetalleParteDiarioModel> getDetallesParteDiario() {
		return detallesParteDiario;
	}

	public void setDetallesParteDiario(List<DetalleParteDiarioModel> detallesParteDiario) {
		this.detallesParteDiario = detallesParteDiario;
	}

	public EstadoParteDiarioModel getEstadoParteDiario() {
		return estadoParteDiario;
	}

	public void setEstadoParteDiario(EstadoParteDiarioModel estadoParteDiario) {
		this.estadoParteDiario = estadoParteDiario;
	}

	public PeriodoModel getPeriodo() {
		return periodo;
	}

	public void setPeriodo(PeriodoModel periodo) {
		this.periodo = periodo;
	}


	
}
