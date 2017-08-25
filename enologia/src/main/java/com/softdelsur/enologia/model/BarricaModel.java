package com.softdelsur.enologia.model;



import java.sql.Date;

import com.softdelsur.enologia.model.ElementosConOperacionesEnologicasModel;

public class BarricaModel extends ElementosConOperacionesEnologicasModel{

	
	private int codigoBarrica;
	private String descripcion;
	private Date fechaAdquisicion;
	private Date fechaActivacion;
	private Date fechaVigencia;
	private Date fechaRenovacion;
	private int capacidad;
	private OrigenModel origen;
	private ToneleriaModel toneleria;
	private BosqueModel bosque;
	private TostadoModel tostado;
	private EstadoBarricaModel estadoModel;
	
	
	public BarricaModel() {
		super();
	}


	public int getCodigoBarrica() {
		return codigoBarrica;
	}


	public void setCodigoBarrica(int codigoBarrica) {
		this.codigoBarrica = codigoBarrica;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}


	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}


	public Date getFechaActivacion() {
		return fechaActivacion;
	}


	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}


	public Date getFechaVigencia() {
		return fechaVigencia;
	}


	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}


	public Date getFechaRenovacion() {
		return fechaRenovacion;
	}


	public void setFechaRenovacion(Date fechaRenovacion) {
		this.fechaRenovacion = fechaRenovacion;
	}


	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public OrigenModel getOrigen() {
		return origen;
	}


	public void setOrigen(OrigenModel origen) {
		this.origen = origen;
	}


	public ToneleriaModel getToneleria() {
		return toneleria;
	}


	public void setToneleria(ToneleriaModel toneleria) {
		this.toneleria = toneleria;
	}


	public BosqueModel getBosque() {
		return bosque;
	}


	public void setBosque(BosqueModel bosque) {
		this.bosque = bosque;
	}


	public TostadoModel getTostado() {
		return tostado;
	}


	public void setTostado(TostadoModel tostado) {
		this.tostado = tostado;
	}


	public EstadoBarricaModel getEstadoModel() {
		return estadoModel;
	}


	public void setEstadoModel(EstadoBarricaModel estadoModel) {
		this.estadoModel = estadoModel;
	}


	@Override
	public void operacionEnologica() {
		// TODO Auto-generated method stub
		
	}
	
	
}
