package com.softdelsur.enologia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "estado_barrica")
public class EstadoBarrica {

	private static final long serialVersionUID = 1L;


	@Id
	@Column(name= "id_estado_barrica", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")

	private String idEstadoBarrica;
	
	@Column(name = "nombre")
	private String nombreEstadoBarrica;

	
	
	public EstadoBarrica() {
		super();
	}



	public EstadoBarrica(String nombreEstadoBarrica) {
		super();
		this.nombreEstadoBarrica = nombreEstadoBarrica;
	}



	public String getIdEstadoBarrica() {
		return idEstadoBarrica;
	}



	public void setIdEstadoBarrica(String idEstadoBarrica) {
		this.idEstadoBarrica = idEstadoBarrica;
	}



	public String getNombreEstadoBarrica() {
		return nombreEstadoBarrica;
	}



	public void setNombreEstadoBarrica(String nombreEstadoBarrica) {
		this.nombreEstadoBarrica = nombreEstadoBarrica;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreEstadoBarrica == null) ? 0 : nombreEstadoBarrica.hashCode());
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
		EstadoBarrica other = (EstadoBarrica) obj;
		if (nombreEstadoBarrica == null) {
			if (other.nombreEstadoBarrica != null)
				return false;
		} else if (!nombreEstadoBarrica.equals(other.nombreEstadoBarrica))
			return false;
		return true;
	}
	
	
	
	
}
