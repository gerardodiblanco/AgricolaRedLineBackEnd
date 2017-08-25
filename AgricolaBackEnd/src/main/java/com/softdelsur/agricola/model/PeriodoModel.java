package com.softdelsur.agricola.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import com.softdelsur.agricola.entity.EstadoPeriodo;
import com.softdelsur.agricola.entity.Rubro;

public class PeriodoModel {
    private String idPeriodo;
  
private String Descripcion;
    
private Date FechaDesde;
    
private Date FechaHasta;
    
private Date PeriodoAnio;
 
private RubroModel rubro;
    
private EstadoPeriodoModel estado;

public PeriodoModel() {
	super();
}

public PeriodoModel(String descripcion, Date fechaDesde, Date fechaHasta, Date periodoAnio, RubroModel rubro,
		EstadoPeriodoModel estado) {
	super();
	Descripcion = descripcion;
	FechaDesde = fechaDesde;
	FechaHasta = fechaHasta;
	PeriodoAnio = periodoAnio;
	this.rubro = rubro;
	this.estado = estado;
}

public String getIdPeriodo() {
	return idPeriodo;
}

public void setIdPeriodo(String idPeriodo) {
	this.idPeriodo = idPeriodo;
}

public String getDescripcion() {
	return Descripcion;
}

public void setDescripcion(String descripcion) {
	Descripcion = descripcion;
}

public Date getFechaDesde() {
	return FechaDesde;
}

public void setFechaDesde(Date fechaDesde) {
	FechaDesde = fechaDesde;
}

public Date getFechaHasta() {
	return FechaHasta;
}

public void setFechaHasta(Date fechaHasta) {
	FechaHasta = fechaHasta;
}

public Date getPeriodoAnio() {
	return PeriodoAnio;
}

public void setPeriodoAnio(Date periodoAnio) {
	PeriodoAnio = periodoAnio;
}

public RubroModel getRubro() {
	return rubro;
}

public void setRubro(RubroModel rubro) {
	this.rubro = rubro;
}

public EstadoPeriodoModel getEstado() {
	return estado;
}

public void setEstado(EstadoPeriodoModel estado) {
	this.estado = estado;
}


}
