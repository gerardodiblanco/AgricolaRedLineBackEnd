package com.softdelsur.agricola.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tareaInsumo")
public class TareaInsumo {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tarea_insumo", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;

	private Date fechaAlta;
	private Date fechaBaja;

	@OneToOne(cascade = CascadeType.REFRESH)
	private Tarea tarea;

	@OneToOne(cascade = CascadeType.REFRESH)
	private Insumo insumo;

	public TareaInsumo() {
		super();
	}

	public TareaInsumo(Tarea tarea, Insumo insumo) {
		super();
		this.tarea = tarea;
		this.insumo = insumo;
		this.setFechaAlta(Date.valueOf(LocalDate.now()));
		this.setFechaBaja(null);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
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

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaBaja == null) ? 0 : fechaBaja.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((insumo == null) ? 0 : insumo.hashCode());
		result = prime * result + ((tarea == null) ? 0 : tarea.hashCode());
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
		TareaInsumo other = (TareaInsumo) obj;
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
		if (insumo == null) {
			if (other.insumo != null)
				return false;
		} else if (!insumo.equals(other.insumo))
			return false;
		if (tarea == null) {
			if (other.tarea != null)
				return false;
		} else if (!tarea.equals(other.tarea))
			return false;
		return true;
	}

}
