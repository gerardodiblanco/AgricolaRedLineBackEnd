package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "insumos")
public class Insumo {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idInsumo;

	private int codigo;
	private String descripcion;
	private boolean estado;

	@ManyToOne
	public UnidadMedida unidadMedida;

	public Insumo() {
		super();
	}

	public String getIdInsumo() {
		return idInsumo;
	}

	public void setIdInsumo(String idInsumo) {
		this.idInsumo = idInsumo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (estado ? 1231 : 1237);
		result = prime * result + ((idInsumo == null) ? 0 : idInsumo.hashCode());
		result = prime * result + ((unidadMedida == null) ? 0 : unidadMedida.hashCode());
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
		Insumo other = (Insumo) obj;
		if (codigo != other.codigo)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estado != other.estado)
			return false;
		if (idInsumo == null) {
			if (other.idInsumo != null)
				return false;
		} else if (!idInsumo.equals(other.idInsumo))
			return false;
		if (unidadMedida == null) {
			if (other.unidadMedida != null)
				return false;
		} else if (!unidadMedida.equals(other.unidadMedida))
			return false;
		return true;
	}

}
