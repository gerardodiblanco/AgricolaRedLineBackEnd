package com.softdelsur.agricola.entity;

import java.sql.Date;

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
@Table(name = "unidad_trabajo_deposito")
public class UnidadTrabajoDeposito {


	@Id
	@Column(name = "id_unidad_trabajo_deposito", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	private Date fechaAlta;
	private Date fechaBaja;
	
	@JoinColumn
	@ManyToOne(cascade = CascadeType.REFRESH)
	private UnidadTrabajo unidadTrabajo;
	
	@JoinColumn
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Deposito deposito;
	
	
	public UnidadTrabajoDeposito() {
		super();
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public UnidadTrabajo getUnidadTrabajo() {
		return unidadTrabajo;
	}

	public void setUnidadTrabajo(UnidadTrabajo unidadTrabajo) {
		this.unidadTrabajo = unidadTrabajo;
	}

	
	
	
}
