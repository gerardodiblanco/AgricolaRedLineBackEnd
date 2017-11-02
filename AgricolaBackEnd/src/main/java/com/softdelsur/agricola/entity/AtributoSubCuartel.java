package com.softdelsur.agricola.entity;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "atributoSubCuartel")
public class AtributoSubCuartel {

	 private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name= "id", unique = true, nullable = false)
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @GeneratedValue(generator = "uuid")
	    private String id;
	    
	    private Timestamp fechaIncioVigencia;
	    private Timestamp fechaFinVigencia;
	    
	    @ManyToOne(cascade = CascadeType.REFRESH)
	    private AtributoOpcion opcion;
	    
	    
		public AtributoSubCuartel() {
			super();
		}


		public AtributoSubCuartel(AtributoOpcion opcion) {
			this.fechaIncioVigencia = Timestamp.valueOf(LocalDateTime.now());
			this.fechaFinVigencia = null;
			this.opcion = opcion;
		
	}
		
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Timestamp getFechaIncioVigencia() {
			return fechaIncioVigencia;
		}
		public void setFechaIncioVigencia(Timestamp fechaIncioVigencia) {
			this.fechaIncioVigencia = fechaIncioVigencia;
		}
		public Timestamp getFechaFinVigencia() {
			return fechaFinVigencia;
		}
		public void setFechaFinVigencia(Timestamp fechaFinVigencia) {
			this.fechaFinVigencia = fechaFinVigencia;
		}


		public AtributoOpcion getOpcion() {
			return opcion;
		}


		public void setOpcion(AtributoOpcion opcion) {
			this.opcion = opcion;
		}


	    
}
