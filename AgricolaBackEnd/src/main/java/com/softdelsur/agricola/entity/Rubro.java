package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "rubros")
public class Rubro {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_rubro", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idRubro;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "nombre")
	private String nombreRubro;

	public Rubro() {

	}

	public Rubro(String descripcion, String nombreRubro) {
		super();
		this.descripcion = descripcion;
		this.nombreRubro = nombreRubro;
	}

	public String getIdRubro() {
		return idRubro;
	}

	public void setIdRubro(String idRubro) {
		this.idRubro = idRubro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreRubro() {
		return nombreRubro;
	}

	public void setNombreRubro(String nombreRubro) {
		this.nombreRubro = nombreRubro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((nombreRubro == null) ? 0 : nombreRubro.hashCode());
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
		Rubro other = (Rubro) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (nombreRubro == null) {
			if (other.nombreRubro != null)
				return false;
		} else if (!nombreRubro.equals(other.nombreRubro))
			return false;
		return true;
	}

}