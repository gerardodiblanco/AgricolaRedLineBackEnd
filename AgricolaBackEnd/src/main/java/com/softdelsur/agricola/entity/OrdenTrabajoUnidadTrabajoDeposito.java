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
@Table(name = "orden_de_trabajo_unidad_trabajo_deposito")
public class OrdenTrabajoUnidadTrabajoDeposito {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_orden_de_trabajo_unidad_trabajo_deposito", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	private boolean seleccion;

	@JoinColumn
	@ManyToOne(cascade = CascadeType.REFRESH)
	private UnidadTrabajoDeposito unidadTrabajoDeposito;

	public OrdenTrabajoUnidadTrabajoDeposito(boolean seleccion, UnidadTrabajoDeposito unidadTrabajoDeposito) {
		super();
		this.seleccion = seleccion;
		this.unidadTrabajoDeposito = unidadTrabajoDeposito;
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

	public UnidadTrabajoDeposito getUnidadTrabajoDeposito() {
		return unidadTrabajoDeposito;
	}

	public void setUnidadTrabajoDeposito(UnidadTrabajoDeposito unidadTrabajoDeposito) {
		this.unidadTrabajoDeposito = unidadTrabajoDeposito;
	}

}
