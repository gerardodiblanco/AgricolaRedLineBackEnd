package com.softdelsur.agricola.entity;

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
@Table(name = "orden_de_trabajo_tarea_insumo")
public class OrdenTrabajoTareaInsumo {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_orden_de_trabajo_tarea_insumo", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	private double cantidad;
	
	@JoinColumn
	@ManyToOne
	private Insumo insumo;
	
	
	
	public OrdenTrabajoTareaInsumo() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cantidad);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((insumo == null) ? 0 : insumo.hashCode());
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
		OrdenTrabajoTareaInsumo other = (OrdenTrabajoTareaInsumo) obj;
		if (Double.doubleToLongBits(cantidad) != Double.doubleToLongBits(other.cantidad))
			return false;
		if (insumo == null) {
			if (other.insumo != null)
				return false;
		} else if (!insumo.equals(other.insumo))
			return false;
		return true;
	}


	
	
	
}
