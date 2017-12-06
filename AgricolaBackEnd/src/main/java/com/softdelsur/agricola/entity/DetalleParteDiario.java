package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "detalleParteDiario")
public class DetalleParteDiario {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;

	private int cantidad;
	@ManyToOne
	public PersonalTarea personalTarea;

	public DetalleParteDiario() {
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

	public PersonalTarea getPersonalTarea() {
		return personalTarea;
	}

	public void setPersonalTarea(PersonalTarea personalTarea) {
		this.personalTarea = personalTarea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((personalTarea == null) ? 0 : personalTarea.hashCode());
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
		DetalleParteDiario other = (DetalleParteDiario) obj;
		if (cantidad != other.cantidad)
			return false;
		if (personalTarea == null) {
			if (other.personalTarea != null)
				return false;
		} else if (!personalTarea.equals(other.personalTarea))
			return false;
		return true;
	}

}
