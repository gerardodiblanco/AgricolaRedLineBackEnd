package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "estadoParteDiario")
public class EstadoParteDiario {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_estado", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idEstadoParteDiario;
	private int codigo;
	@Column(name = "nombre")
	private String nombreEstado;

	public EstadoParteDiario() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public String getIdEstadoParteDiario() {
		return idEstadoParteDiario;
	}

	public void setIdEstadoParteDiario(String idEstadoParteDiario) {
		this.idEstadoParteDiario = idEstadoParteDiario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((nombreEstado == null) ? 0 : nombreEstado.hashCode());
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
		EstadoParteDiario other = (EstadoParteDiario) obj;
		if (codigo != other.codigo)
			return false;
		if (nombreEstado == null) {
			if (other.nombreEstado != null)
				return false;
		} else if (!nombreEstado.equals(other.nombreEstado))
			return false;
		return true;
	}

}
