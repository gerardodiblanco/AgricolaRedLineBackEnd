package com.softdelsur.agricola.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "personal_sector")
public class PersonalSector {

	  private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name= "id", unique = true, nullable = false)
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @GeneratedValue(generator = "uuid")
	    private String id;
	    
	private Date fechaAsignacion;
	private Date fechaDesAsignacion;
	@ManyToOne
	public Personal personal;
	
	public PersonalSector() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}
	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	public Date getFechaDesAsignacion() {
		return fechaDesAsignacion;
	}
	public void setFechaDesAsignacion(Date fechaDesAsignacion) {
		this.fechaDesAsignacion = fechaDesAsignacion;
	}
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaAsignacion == null) ? 0 : fechaAsignacion.hashCode());
		result = prime * result + ((fechaDesAsignacion == null) ? 0 : fechaDesAsignacion.hashCode());
		result = prime * result + ((personal == null) ? 0 : personal.hashCode());
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
		PersonalSector other = (PersonalSector) obj;
		if (fechaAsignacion == null) {
			if (other.fechaAsignacion != null)
				return false;
		} else if (!fechaAsignacion.equals(other.fechaAsignacion))
			return false;
		if (fechaDesAsignacion == null) {
			if (other.fechaDesAsignacion != null)
				return false;
		} else if (!fechaDesAsignacion.equals(other.fechaDesAsignacion))
			return false;
		if (personal == null) {
			if (other.personal != null)
				return false;
		} else if (!personal.equals(other.personal))
			return false;
		return true;
	}
	
	
	
	
}
