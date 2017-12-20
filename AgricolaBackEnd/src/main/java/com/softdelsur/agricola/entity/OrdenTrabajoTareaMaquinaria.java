package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orden_de_trabajo_tarea_maquinaria")
public class OrdenTrabajoTareaMaquinaria {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_orden_de_trabajo_tarea_maquinaria", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	private int cantidad;

	@JoinColumn
	@ManyToOne
	private Maquinaria maquinaria;

	public OrdenTrabajoTareaMaquinaria() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Maquinaria getMaquinaria() {
		return maquinaria;
	}

	public void setMaquinaria(Maquinaria maquinaria) {
		this.maquinaria = maquinaria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((maquinaria == null) ? 0 : maquinaria.hashCode());
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
		OrdenTrabajoTareaMaquinaria other = (OrdenTrabajoTareaMaquinaria) obj;
		if (cantidad != other.cantidad)
			return false;
		if (maquinaria == null) {
			if (other.maquinaria != null)
				return false;
		} else if (!maquinaria.equals(other.maquinaria))
			return false;
		return true;
	}

}
