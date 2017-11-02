package com.softdelsur.agricola.model;

import java.util.ArrayList;
import java.util.List;

public class AtributoConOpcionesModel {

	  	private String id;
	    private String nombreAtributo;
	    private List<AtributoOpcionModel> opciones = new ArrayList<>();
	    
	    

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getNombreAtributo() {
			return nombreAtributo;
		}

		public void setNombreAtributo(String nombreAtributo) {
			this.nombreAtributo = nombreAtributo;
		}

		public List<AtributoOpcionModel> getOpciones() {
			return opciones;
		}

		public void setOpciones(List<AtributoOpcionModel> opciones) {
			this.opciones = opciones;
		}
		

		    
	    
}
