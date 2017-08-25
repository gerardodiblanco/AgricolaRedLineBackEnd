package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "caracteristicas")
public class Caracteristica {
	  private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name= "id_caracteristica", unique = true, nullable = false)
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @GeneratedValue(generator = "uuid")
	    private String idCaracteristica;
	private int codigo;
	@Column(name = "numero")
	private int numeroCaracteristica;
	@ManyToOne
	public TipoCaracteristica tipoCaracteristica;
	public Caracteristica() {
		super();
	}
	public String getIdCaracteristica() {
		return idCaracteristica;
	}
	public void setIdCaracteristica(String idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNumeroCaracteristica() {
		return numeroCaracteristica;
	}
	public void setNumeroCaracteristica(int numeroCaracteristica) {
		this.numeroCaracteristica = numeroCaracteristica;
	}
	public TipoCaracteristica getTipoCaracteristica() {
		return tipoCaracteristica;
	}
	public void setTipoCaracteristica(TipoCaracteristica tipoCaracteristica) {
		this.tipoCaracteristica = tipoCaracteristica;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + numeroCaracteristica;
		result = prime * result + ((tipoCaracteristica == null) ? 0 : tipoCaracteristica.hashCode());
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
		Caracteristica other = (Caracteristica) obj;
		if (codigo != other.codigo)
			return false;
		if (numeroCaracteristica != other.numeroCaracteristica)
			return false;
		if (tipoCaracteristica == null) {
			if (other.tipoCaracteristica != null)
				return false;
		} else if (!tipoCaracteristica.equals(other.tipoCaracteristica))
			return false;
		return true;
	}
	
}
