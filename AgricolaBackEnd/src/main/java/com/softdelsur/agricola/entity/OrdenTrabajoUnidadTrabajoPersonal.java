package com.softdelsur.agricola.entity;

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
@Table(name = "orden_de_trabajo_unidad_trabajo_personal")
public class OrdenTrabajoUnidadTrabajoPersonal {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_orden_de_trabajo_unidad_trabajo_personal", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	private boolean seleccion;
	
	@JoinColumn
	@ManyToOne(cascade = CascadeType.REFRESH)
	private UnidadTrabajoPersonal unidadTrabajoPersonal;
	
	

	public OrdenTrabajoUnidadTrabajoPersonal() {
		super();
	}

	
	
	public OrdenTrabajoUnidadTrabajoPersonal(boolean seleccion, UnidadTrabajoPersonal unidadTrabajoPersonal) {
		super();
		this.seleccion = seleccion;
		this.unidadTrabajoPersonal = unidadTrabajoPersonal;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isSeleccion() {
		return seleccion;
	}

	public void setSeleccion(boolean seleccion) {
		this.seleccion = seleccion;
	}

	public UnidadTrabajoPersonal getUnidadTrabajoPersonal() {
		return unidadTrabajoPersonal;
	}

	public void setUnidadTrabajoPersonal(UnidadTrabajoPersonal unidadTrabajoPersonal) {
		this.unidadTrabajoPersonal = unidadTrabajoPersonal;
	}

	

}