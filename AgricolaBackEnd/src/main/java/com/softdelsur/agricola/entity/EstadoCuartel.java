package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "estados_cuartel")
public class EstadoCuartel {
	

	   private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name= "id_domicilio", unique = true, nullable = false)
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @GeneratedValue(generator = "uuid")
	    private String id;
	    private String nombre;
	    
	    
		public EstadoCuartel() {
			
		}
		
		
		
		public EstadoCuartel(String nombre) {
			super();
			this.nombre = nombre;
		}



		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
			EstadoCuartel other = (EstadoCuartel) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (nombre == null) {
				if (other.nombre != null)
					return false;
			} else if (!nombre.equals(other.nombre))
				return false;
			return true;
		}
		
		
	    
	    
}
