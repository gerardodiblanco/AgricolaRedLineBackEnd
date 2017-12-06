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
@Table(name = "unidad_trabajo_subCuartel")
public class UnidadTrabajoSubCuartel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_unidad_trabajo_subcuartel", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	private Date fechaAlta;
	private Date fechaBaja;
	
	@JoinColumn
	@ManyToOne(cascade = CascadeType.REFRESH)
	private UnidadTrabajo unidadTrabajo;

	@JoinColumn
	@ManyToOne(cascade = CascadeType.REFRESH)
	private SubCuartel subCuartel;
	
	public UnidadTrabajoSubCuartel() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public UnidadTrabajo getUnidadTrabajo() {
		return unidadTrabajo;
	}

	public void setUnidadTrabajo(UnidadTrabajo unidadTrabajo) {
		this.unidadTrabajo = unidadTrabajo;
	}

	public SubCuartel getSubCuartel() {
		return subCuartel;
	}

	public void setSubCuartel(SubCuartel subCuartel) {
		this.subCuartel = subCuartel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaBaja == null) ? 0 : fechaBaja.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((subCuartel == null) ? 0 : subCuartel.hashCode());
		result = prime * result + ((unidadTrabajo == null) ? 0 : unidadTrabajo.hashCode());
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
		UnidadTrabajoSubCuartel other = (UnidadTrabajoSubCuartel) obj;
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
		if (subCuartel == null) {
			if (other.subCuartel != null)
				return false;
		} else if (!subCuartel.equals(other.subCuartel))
			return false;
		if (unidadTrabajo == null) {
			if (other.unidadTrabajo != null)
				return false;
		} else if (!unidadTrabajo.equals(other.unidadTrabajo))
			return false;
		return true;
	}



}
