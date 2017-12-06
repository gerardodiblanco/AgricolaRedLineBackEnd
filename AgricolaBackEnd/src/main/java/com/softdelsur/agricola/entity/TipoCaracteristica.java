package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tiposCaracteristica")
public class TipoCaracteristica {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tipo_caracteristica", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idTipoCaracteristica;
	private int codigo;
	@Column(name = "nombre")
	private String nombreCaracteristica;

	public TipoCaracteristica() {
		super();
	}

	public TipoCaracteristica(int codigo, String nombreCaracteristica) {
		super();
		this.codigo = codigo;
		this.nombreCaracteristica = nombreCaracteristica;
	}

	public String getIdTipoCaracteristica() {
		return idTipoCaracteristica;
	}

	public void setIdTipoCaracteristica(String idTipoCaracteristica) {
		this.idTipoCaracteristica = idTipoCaracteristica;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombreCaracteristica() {
		return nombreCaracteristica;
	}

	public void setNombreCaracteristica(String nombreCaracteristica) {
		this.nombreCaracteristica = nombreCaracteristica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((nombreCaracteristica == null) ? 0 : nombreCaracteristica.hashCode());
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
		TipoCaracteristica other = (TipoCaracteristica) obj;
		if (codigo != other.codigo)
			return false;
		if (nombreCaracteristica == null) {
			if (other.nombreCaracteristica != null)
				return false;
		} else if (!nombreCaracteristica.equals(other.nombreCaracteristica))
			return false;
		return true;
	}

}
