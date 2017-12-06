package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "maquinarias")
public class Maquinaria {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_maquina", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	private int codigo;
	private String descripcion;
	private boolean estadoMaquinaria;

	public Maquinaria() {
		super();
	}

	public String getIdMaquina() {
		return id;
	}

	public void setIdMaquina(String idMaquina) {
		this.id = idMaquina;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isEstadoMaquinaria() {
		return estadoMaquinaria;
	}

	public void setEstadoMaquinaria(boolean estadoMaquinaria) {
		this.estadoMaquinaria = estadoMaquinaria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (estadoMaquinaria ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Maquinaria other = (Maquinaria) obj;
		if (codigo != other.codigo)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estadoMaquinaria != other.estadoMaquinaria)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
