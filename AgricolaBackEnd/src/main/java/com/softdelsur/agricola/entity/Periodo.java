package com.softdelsur.agricola.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "periodos")
public class Periodo {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_periodo", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idPeriodo;
	@Column(name = "descripcion")
	private String Descripcion;
	@Column(name = "fecha_desde")
	private Date FechaDesde;
	@Column(name = "fecha_hasta")
	private Date FechaHasta;
	@Column(name = "periodo")
	private Date PeriodoAnio;
	@ManyToOne
	private Rubro rubro;
	@ManyToOne
	private EstadoPeriodo estado;

	public Periodo() {

	}

	public Periodo(String descripcion, Date fechaDesde, Date fechaHasta, Date periodoAnio, Rubro rubro,
			EstadoPeriodo estado) {
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

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	public EstadoPeriodo getEstado() {
		return estado;
	}

	public void setEstado(EstadoPeriodo estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Descripcion == null) ? 0 : Descripcion.hashCode());
		result = prime * result + ((FechaDesde == null) ? 0 : FechaDesde.hashCode());
		result = prime * result + ((FechaHasta == null) ? 0 : FechaHasta.hashCode());
		result = prime * result + ((PeriodoAnio == null) ? 0 : PeriodoAnio.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((rubro == null) ? 0 : rubro.hashCode());
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
		Periodo other = (Periodo) obj;
		if (Descripcion == null) {
			if (other.Descripcion != null)
				return false;
		} else if (!Descripcion.equals(other.Descripcion))
			return false;
		if (FechaDesde == null) {
			if (other.FechaDesde != null)
				return false;
		} else if (!FechaDesde.equals(other.FechaDesde))
			return false;
		if (FechaHasta == null) {
			if (other.FechaHasta != null)
				return false;
		} else if (!FechaHasta.equals(other.FechaHasta))
			return false;
		if (PeriodoAnio == null) {
			if (other.PeriodoAnio != null)
				return false;
		} else if (!PeriodoAnio.equals(other.PeriodoAnio))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (rubro == null) {
			if (other.rubro != null)
				return false;
		} else if (!rubro.equals(other.rubro))
			return false;
		return true;
	}

}