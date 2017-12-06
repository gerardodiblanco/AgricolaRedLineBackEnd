package com.softdelsur.agricola.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tratos")
public class Trato {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")

	private String id;
	private String nombre;
	private Integer codigo;
	private float importe;
	private float unMinima;
	private Date fechaAlta;
	private Date fechaBaja;

	public Trato() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public float getUnMinima() {
		return unMinima;
	}

	public void setUnMinima(float unMinima) {
		this.unMinima = unMinima;
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
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaBaja == null) ? 0 : fechaBaja.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(importe);
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + Float.floatToIntBits(unMinima);
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
		Trato other = (Trato) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
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
		if (Float.floatToIntBits(importe) != Float.floatToIntBits(other.importe))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Float.floatToIntBits(unMinima) != Float.floatToIntBits(other.unMinima))
			return false;
		return true;
	}

}