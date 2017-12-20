package com.softdelsur.agricola.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orden_de_trabajo_unidad_trabajo_subcuartel")
public class OrdenTrabajoUnidadTrabajoSubCuartel {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_orden_de_trabajo_unidad_trabajo_subcuartel", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	private boolean seleccion;

	@JoinColumn(name = "id_unidad_trabajo_subcuartel")
	@OneToOne(cascade = CascadeType.REFRESH)
	private UnidadTrabajoSubCuartel unidadTrabajoSubCuartel;

	public OrdenTrabajoUnidadTrabajoSubCuartel() {
		super();
	}

	public OrdenTrabajoUnidadTrabajoSubCuartel(boolean seleccion, UnidadTrabajoSubCuartel unidadTrabajoSubCuartel) {
		super();
		this.seleccion = seleccion;
		this.unidadTrabajoSubCuartel = unidadTrabajoSubCuartel;
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

	public UnidadTrabajoSubCuartel getUnidadTrabajoSubCuartel() {
		return unidadTrabajoSubCuartel;
	}

	public void setUnidadTrabajoSubCuartel(UnidadTrabajoSubCuartel unidadTrabajoSubCuartel) {
		this.unidadTrabajoSubCuartel = unidadTrabajoSubCuartel;
	}

}
