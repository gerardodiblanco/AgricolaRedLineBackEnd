package com.softdelsur.agricola.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "domicilios")
public class Domicilio {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_domicilio", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idDomicilio;
	private String calle;
	private int dto;
	private int numero;
	private String otro;
	private int piso;
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Localidad localidad;

	public Domicilio() {
		super();
	}

	public Domicilio(String calle, int dto, int numero, String otro, int piso, Localidad localidad) {
		super();
		this.calle = calle;
		this.dto = dto;
		this.numero = numero;
		this.otro = otro;
		this.piso = piso;
		this.localidad = localidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + dto;
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + numero;
		result = prime * result + ((otro == null) ? 0 : otro.hashCode());
		result = prime * result + piso;
		return result;
	}

	public String getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(String idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getDto() {
		return dto;
	}

	public void setDto(int dto) {
		this.dto = dto;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getOtro() {
		return otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Domicilio other = (Domicilio) obj;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (dto != other.dto)
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (numero != other.numero)
			return false;
		if (otro == null) {
			if (other.otro != null)
				return false;
		} else if (!otro.equals(other.otro))
			return false;
		if (piso != other.piso)
			return false;
		return true;
	}

}
