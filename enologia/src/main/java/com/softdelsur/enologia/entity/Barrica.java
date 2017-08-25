package com.softdelsur.enologia.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "barricas" )
@PrimaryKeyJoinColumn(name = "id_barrica")
public class Barrica extends ElementosConOperacionesEnologicas {

	
	
	@Column(name = "c_barrica")
	private int codigoBarrica;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_adquisicion")
	private Date fechaAdquisicion;
	
	@Column(name = "fecha_activacion")
	private Date fechaActivacion;
	
	@Column(name = "fecha_vigencia")
	private Date fechaVigencia;
	
	@Column(name = "fecha_renovacion")
	private Date fechaRenovacion;

	@Column(name = "capacidad")
	private int capacidad;

	@ManyToOne
	private Origen origen;
	
	@ManyToOne
	private Toneleria toneleria;
	
	@ManyToOne
	private Bosque bosque;
	
	@ManyToOne
	private Tostado tostado;
	
	@ManyToOne
	private EstadoBarrica estado;
	
	
	public Barrica(){
		
	}


	public Barrica(int codigoBarrica, Date fechaAdquisicion, Date fechaActivacion, Date fechaVigencia,
			EstadoBarrica estado) {
		super();
		this.codigoBarrica = codigoBarrica;
		this.fechaAdquisicion = fechaAdquisicion;
		this.fechaActivacion = fechaActivacion;
		this.fechaVigencia = fechaVigencia;
		this.estado = estado;
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


	public void setFechaVigencia(Date fehcaVigencia) {
		this.fechaVigencia = fehcaVigencia;
	}


	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public Date getFechaRenovacion() {
		return fechaRenovacion;
	}


	public void setFechaRenovacion(Date fechaRenovacion) {
		this.fechaRenovacion = fechaRenovacion;
	}


	public Origen getOrigen() {
		return origen;
	}


	public void setOrigen(Origen origen) {
		this.origen = origen;
	}


	public Toneleria getToneleria() {
		return toneleria;
	}


	public void setToneleria(Toneleria toneleria) {
		this.toneleria = toneleria;
	}


	public Bosque getBosque() {
		return bosque;
	}


	public void setBosque(Bosque bosque) {
		this.bosque = bosque;
	}


	public Tostado getTostado() {
		return tostado;
	}


	public void setTostado(Tostado tostado) {
		this.tostado = tostado;
	}


	public EstadoBarrica getEstado() {
		return estado;
	}


	public void setEstado(EstadoBarrica estado) {
		this.estado = estado;
	}


	@Override
	public void operacionEnologica() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bosque == null) ? 0 : bosque.hashCode());
		result = prime * result + capacidad;
		result = prime * result + codigoBarrica;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaActivacion == null) ? 0 : fechaActivacion.hashCode());
		result = prime * result + ((fechaAdquisicion == null) ? 0 : fechaAdquisicion.hashCode());
		result = prime * result + ((fechaRenovacion == null) ? 0 : fechaRenovacion.hashCode());
		result = prime * result + ((fechaVigencia == null) ? 0 : fechaVigencia.hashCode());
		result = prime * result + ((origen == null) ? 0 : origen.hashCode());
		result = prime * result + ((toneleria == null) ? 0 : toneleria.hashCode());
		result = prime * result + ((tostado == null) ? 0 : tostado.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Barrica other = (Barrica) obj;
		if (bosque == null) {
			if (other.bosque != null)
				return false;
		} else if (!bosque.equals(other.bosque))
			return false;
		if (capacidad != other.capacidad)
			return false;
		if (codigoBarrica != other.codigoBarrica)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaActivacion == null) {
			if (other.fechaActivacion != null)
				return false;
		} else if (!fechaActivacion.equals(other.fechaActivacion))
			return false;
		if (fechaAdquisicion == null) {
			if (other.fechaAdquisicion != null)
				return false;
		} else if (!fechaAdquisicion.equals(other.fechaAdquisicion))
			return false;
		if (fechaRenovacion == null) {
			if (other.fechaRenovacion != null)
				return false;
		} else if (!fechaRenovacion.equals(other.fechaRenovacion))
			return false;
		if (fechaVigencia == null) {
			if (other.fechaVigencia != null)
				return false;
		} else if (!fechaVigencia.equals(other.fechaVigencia))
			return false;
		if (origen == null) {
			if (other.origen != null)
				return false;
		} else if (!origen.equals(other.origen))
			return false;
		if (toneleria == null) {
			if (other.toneleria != null)
				return false;
		} else if (!toneleria.equals(other.toneleria))
			return false;
		if (tostado == null) {
			if (other.tostado != null)
				return false;
		} else if (!tostado.equals(other.tostado))
			return false;
		return true;
	}


	

	
}

