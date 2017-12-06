package com.softdelsur.agricola.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "unidad_trabajo_personal")
public class UnidadTrabajoPersonal {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_unidad_trabajo_personal", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	private String idPersonal;
	private Date fechaAlta;
	private Date fechaBaja;
	
	@JoinColumn
	@ManyToOne(cascade = CascadeType.REFRESH)
	private UnidadTrabajo unidadTrabajo;
	
	public UnidadTrabajoPersonal() {
		super();
	}

	public UnidadTrabajo getUnidadTrabajo() {
		return unidadTrabajo;
	}

	public void setUnidadTrabajo(UnidadTrabajo unidadTrabajo) {
		this.unidadTrabajo = unidadTrabajo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaBaja == null) ? 0 : fechaBaja.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idPersonal == null) ? 0 : idPersonal.hashCode());
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
		UnidadTrabajoPersonal other = (UnidadTrabajoPersonal) obj;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		if (fechaBaja == null) {
			if (other.fechaBaja != null)
				return false;
		} else if (!fechaBaja.equals(other.fechaBaja))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idPersonal == null) {
			if (other.idPersonal != null)
				return false;
		} else if (!idPersonal.equals(other.idPersonal))
			return false;
		return true;
	}
	
	
	

}
