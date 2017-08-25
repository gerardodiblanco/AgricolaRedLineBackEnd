package com.softdelsur.enologia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="bosque")
public class Bosque {

	
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name= "id_bosque", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")

	private String idBosque;
	
	@Column(name = "codigo", nullable = false)
	private int codigo;
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	
	public Bosque() {
		super();
	}


	public Bosque(int codigo) {
		super();
		this.codigo = codigo;
	}


	public String getIdBosque() {
		return idBosque;
	}


	public void setIdBosque(String idBosque) {
		this.idBosque = idBosque;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
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
		Bosque other = (Bosque) obj;
		if (codigo != other.codigo)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}
	
	
	
}
