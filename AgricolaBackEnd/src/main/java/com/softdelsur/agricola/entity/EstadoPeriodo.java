package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "estados_periodo")
public class EstadoPeriodo {
	   private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name= "id_estado", unique = true, nullable = false)
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @GeneratedValue(generator = "uuid")
	    private String idEstadoPeriodo;
	    @Column(name = "nombre_estado")
	private String nombreEstadoPeriodo;

	public EstadoPeriodo(){

	}

	public EstadoPeriodo(String nombreEstadoPeriodo) {
		super();
		this.nombreEstadoPeriodo = nombreEstadoPeriodo;
	}

	

	public String getIdEstadoPeriodo() {
		return idEstadoPeriodo;
	}

	public void setIdEstadoPeriodo(String idEstadoPeriodo) {
		this.idEstadoPeriodo = idEstadoPeriodo;
	}

	public String getNombreEstadoPeriodo() {
		return nombreEstadoPeriodo;
	}

	public void setNombreEstadoPeriodo(String nombreEstadoPeriodo) {
		this.nombreEstadoPeriodo = nombreEstadoPeriodo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreEstadoPeriodo == null) ? 0 : nombreEstadoPeriodo.hashCode());
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
		EstadoPeriodo other = (EstadoPeriodo) obj;
		if (nombreEstadoPeriodo == null) {
			if (other.nombreEstadoPeriodo != null)
				return false;
		} else if (!nombreEstadoPeriodo.equals(other.nombreEstadoPeriodo))
			return false;
		return true;
	}
	


}