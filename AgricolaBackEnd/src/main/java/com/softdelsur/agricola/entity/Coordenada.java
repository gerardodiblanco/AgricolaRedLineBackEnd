package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "coordenadas")
public class Coordenada {

	   private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name= "id", unique = true, nullable = false)
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @GeneratedValue(generator = "uuid")
	    private String id;
	    
	    private double latitud;
	    private double longitud;
	    
	    
	    
		public Coordenada() {
			super();
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public double getLatitud() {
			return latitud;
		}
		public void setLatitud(double latitud) {
			this.latitud = latitud;
		}
		public double getLongitud() {
			return longitud;
		}
		public void setLongitud(double longitud) {
			this.longitud = longitud;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(latitud);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(longitud);
			result = prime * result + (int) (temp ^ (temp >>> 32));
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
			Coordenada other = (Coordenada) obj;
			if (Double.doubleToLongBits(latitud) != Double.doubleToLongBits(other.latitud))
				return false;
			if (Double.doubleToLongBits(longitud) != Double.doubleToLongBits(other.longitud))
				return false;
			return true;
		}
	

	
	    
	    
	   
}
