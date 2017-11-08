package com.softdelsur.agricola.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "periodoVariedad")
public class PeriodoVariedad {
	 private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name= "id", unique = true, nullable = false)
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @GeneratedValue(generator = "uuid")
	    private String id;
	    
	    private Date fechaInicioPeriodo;
	    private Date fechaFinPeriodo;
	    @JoinColumn
	    @ManyToOne(cascade = CascadeType.REFRESH)
	   private Variedad variedad;
	    
	    @JoinColumn
	    @ManyToOne(cascade = CascadeType.REFRESH)
	    private SubCuartel subCuartel;
	    
	    public PeriodoVariedad() {
	    }
	    
		public PeriodoVariedad(SubCuartel subCuartel, Variedad variedad) {
			this.subCuartel = subCuartel;
			this.variedad = variedad;
			this.fechaInicioPeriodo = Date.valueOf(LocalDate.now());
			this.fechaFinPeriodo = null;

		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Date getFechaInicioPeriodo() {
			return fechaInicioPeriodo;
		}
		public void setFechaInicioPeriodo(Date fechaInicioPeriodo) {
			this.fechaInicioPeriodo = fechaInicioPeriodo;
		}
		public Date getFechaFinPeriodo() {
			return fechaFinPeriodo;
		}
		public void setFechaFinPeriodo(Date fechaFinPeriodo) {
			this.fechaFinPeriodo = fechaFinPeriodo;
		}
		public Variedad getVariedad() {
			return variedad;
		}
		public void setVariedad(Variedad variedad) {
			this.variedad = variedad;
		}
		public SubCuartel getSubCuartel() {
			return subCuartel;
		}
		public void setSubCuartel(SubCuartel subCuartel) {
			this.subCuartel = subCuartel;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((fechaFinPeriodo == null) ? 0 : fechaFinPeriodo.hashCode());
			result = prime * result + ((fechaInicioPeriodo == null) ? 0 : fechaInicioPeriodo.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((subCuartel == null) ? 0 : subCuartel.hashCode());
			result = prime * result + ((variedad == null) ? 0 : variedad.hashCode());
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
			PeriodoVariedad other = (PeriodoVariedad) obj;
			if (fechaFinPeriodo == null) {
				if (other.fechaFinPeriodo != null)
					return false;
			} else if (!fechaFinPeriodo.equals(other.fechaFinPeriodo))
				return false;
			if (fechaInicioPeriodo == null) {
				if (other.fechaInicioPeriodo != null)
					return false;
			} else if (!fechaInicioPeriodo.equals(other.fechaInicioPeriodo))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (subCuartel == null) {
				if (other.subCuartel != null)
					return false;
			} else if (!subCuartel.equals(other.subCuartel))
				return false;
			if (variedad == null) {
				if (other.variedad != null)
					return false;
			} else if (!variedad.equals(other.variedad))
				return false;
			return true;
		}


		
	
		
		
	    
		
	    

}
