package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "estadosProveedor")
public class EstadoProveedor {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name= "id_estado", unique = true, nullable = false)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String idEstadoProveedor;
    @Column(name = "nombre")
	private String nombreEstadoProveedor;
	public EstadoProveedor() {
		super();
	}
	public EstadoProveedor(String nombreEstadoProveedor) {
		super();
		this.nombreEstadoProveedor = nombreEstadoProveedor;
	}
	public String getIdEstadoProveedor() {
		return idEstadoProveedor;
	}
	public void setIdEstadoProveedor(String idEstadoProveedor) {
		this.idEstadoProveedor = idEstadoProveedor;
	}
	public String getNombreEstadoProveedor() {
		return nombreEstadoProveedor;
	}
	public void setNombreEstadoProveedor(String nombreEstadoProveedor) {
		this.nombreEstadoProveedor = nombreEstadoProveedor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreEstadoProveedor == null) ? 0 : nombreEstadoProveedor.hashCode());
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
		EstadoProveedor other = (EstadoProveedor) obj;
		if (nombreEstadoProveedor == null) {
			if (other.nombreEstadoProveedor != null)
				return false;
		} else if (!nombreEstadoProveedor.equals(other.nombreEstadoProveedor))
			return false;
		return true;
	}
	
    
    
}
