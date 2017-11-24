package com.softdelsur.agricola.model;

import java.sql.Date;

public class TratoModel {
	
	    private String id;
	    private String nombre;
	    private Integer codigo;
	    private float importe;
	    private float unMinima;
	    private Date fechaAlta;
	    private boolean checkbox;
	    
	    
		public TratoModel() {
			
		}
		
		

		public boolean isCheckbox() {
			return checkbox;
		}



		public void setCheckbox(boolean checkbox) {
			this.checkbox = checkbox;
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

		public Integer getCodigo() {
			return codigo;
		}

		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}

		public float getImporte() {
			return importe;
		}

		public void setImporte(float importe) {
			this.importe = importe;
		}

		public float getUnMinima() {
			return unMinima;
		}

		public void setUnMinima(float unMinima) {
			this.unMinima = unMinima;
		}

		public Date getFechaAlta() {
			return fechaAlta;
		}

		public void setFechaAlta(Date fechaAlta) {
			this.fechaAlta = fechaAlta;
		}
	    
	    

}
