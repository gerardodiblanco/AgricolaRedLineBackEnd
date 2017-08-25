package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "localidades")
public class Localidad {
	  private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name= "id_localidad", unique = true, nullable = false)
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @GeneratedValue(generator = "uuid")
	    private String idLocalidad;
	    @Column(name = "codigo_postal")
	private int codPostal;
	    @Column(name = "nombre")
	private String nombreLocalidad;
		public Localidad() {
			super();
		}
		public Localidad(int codPostal, String nombreLocalidad) {
			super();
			this.codPostal = codPostal;
			this.nombreLocalidad = nombreLocalidad;
		}
		public String getIdLocalidad() {
			return idLocalidad;
		}
		public void setIdLocalidad(String idLocalidad) {
			this.idLocalidad = idLocalidad;
		}
		public int getCodPostal() {
			return codPostal;
		}
		public void setCodPostal(int codPostal) {
			this.codPostal = codPostal;
		}
		public String getNombreLocalidad() {
			return nombreLocalidad;
		}
		public void setNombreLocalidad(String nombreLocalidad) {
			this.nombreLocalidad = nombreLocalidad;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + codPostal;
			result = prime * result + ((nombreLocalidad == null) ? 0 : nombreLocalidad.hashCode());
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
			Localidad other = (Localidad) obj;
			if (codPostal != other.codPostal)
				return false;
			if (nombreLocalidad == null) {
				if (other.nombreLocalidad != null)
					return false;
			} else if (!nombreLocalidad.equals(other.nombreLocalidad))
				return false;
			return true;
		}

}
