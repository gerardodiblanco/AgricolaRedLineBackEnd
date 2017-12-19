package com.softdelsur.agricola.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mysql.fabric.xmlrpc.base.Array;

@Entity
@Table(name = "orden_de_trabajo")
public class OrdenTrabajo {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_orden_trabajo", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	private String descripcion;
	private Date fechaAlta;
	private Date fechaBaja;
	
	@JoinColumn(name = "id_unidad_trabajo")
	@ManyToOne(cascade = CascadeType.REFRESH)
	private UnidadTrabajo unidadTrabajo;
	
	@JoinColumn(name = "id_orden_trabajo")
	@OneToMany(cascade = CascadeType.REFRESH)
	private List<OrdenTrabajoUnidadTrabajoSubCuartel> ordenTrabajoUnidadTrabajoSubCuartelList = new ArrayList<>();
	
	@JoinColumn(name = "id_orden_trabajo")
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrdenTrabajoUnidadTrabajoDeposito> ordenTrabajoUnidadTrabajoDepositoList = new ArrayList<>();
	
	@JoinColumn(name = "id_orden_trabajo")
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrdenTrabajoUnidadTrabajoPersonal> ordenTrabajoUnidadTrabajoPersonalList = new ArrayList<>();
	
	

	public OrdenTrabajo() {
		super();
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



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UnidadTrabajo getUnidadTrabajo() {
		return unidadTrabajo;
	}

	public void setUnidadTrabajo(UnidadTrabajo unidadTrabajo) {
		this.unidadTrabajo = unidadTrabajo;
	}

	
	
	public List<OrdenTrabajoUnidadTrabajoSubCuartel> getOrdenTrabajoUnidadTrabajoSubCuartelList() {
		return ordenTrabajoUnidadTrabajoSubCuartelList;
	}
	
	



	public List<OrdenTrabajoUnidadTrabajoDeposito> getOrdenTrabajoUnidadTrabajoDepositoList() {
		return ordenTrabajoUnidadTrabajoDepositoList;
	}



	public void setOrdenTrabajoUnidadTrabajoDepositoList(
			List<OrdenTrabajoUnidadTrabajoDeposito> ordenTrabajoUnidadTrabajoDepositoList) {
		this.ordenTrabajoUnidadTrabajoDepositoList = ordenTrabajoUnidadTrabajoDepositoList;
	}



	public List<OrdenTrabajoUnidadTrabajoPersonal> getOrdenTrabajoUnidadTrabajoPersonalList() {
		return ordenTrabajoUnidadTrabajoPersonalList;
	}



	public void setOrdenTrabajoUnidadTrabajoPersonalList(
			List<OrdenTrabajoUnidadTrabajoPersonal> ordenTrabajoUnidadTrabajoPersonalList) {
		this.ordenTrabajoUnidadTrabajoPersonalList = ordenTrabajoUnidadTrabajoPersonalList;
	}



	public void setOrdenTrabajoUnidadTrabajoSubCuartelList(
			List<OrdenTrabajoUnidadTrabajoSubCuartel> ordenTrabajoUnidadTrabajoSubCuartelList) {
		this.ordenTrabajoUnidadTrabajoSubCuartelList = ordenTrabajoUnidadTrabajoSubCuartelList;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaBaja == null) ? 0 : fechaBaja.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ordenTrabajoUnidadTrabajoDepositoList == null) ? 0
				: ordenTrabajoUnidadTrabajoDepositoList.hashCode());
		result = prime * result + ((ordenTrabajoUnidadTrabajoPersonalList == null) ? 0
				: ordenTrabajoUnidadTrabajoPersonalList.hashCode());
		result = prime * result + ((ordenTrabajoUnidadTrabajoSubCuartelList == null) ? 0
				: ordenTrabajoUnidadTrabajoSubCuartelList.hashCode());
		result = prime * result + ((unidadTrabajo == null) ? 0 : unidadTrabajo.hashCode());
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
		OrdenTrabajo other = (OrdenTrabajo) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		if (fechaBaja == null) {
			if (other.fechaBaja != null)
				return false;
		} else if (!fechaBaja.equals(other.fechaBaja))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ordenTrabajoUnidadTrabajoDepositoList == null) {
			if (other.ordenTrabajoUnidadTrabajoDepositoList != null)
				return false;
		} else if (!ordenTrabajoUnidadTrabajoDepositoList.equals(other.ordenTrabajoUnidadTrabajoDepositoList))
			return false;
		if (ordenTrabajoUnidadTrabajoPersonalList == null) {
			if (other.ordenTrabajoUnidadTrabajoPersonalList != null)
				return false;
		} else if (!ordenTrabajoUnidadTrabajoPersonalList.equals(other.ordenTrabajoUnidadTrabajoPersonalList))
			return false;
		if (ordenTrabajoUnidadTrabajoSubCuartelList == null) {
			if (other.ordenTrabajoUnidadTrabajoSubCuartelList != null)
				return false;
		} else if (!ordenTrabajoUnidadTrabajoSubCuartelList.equals(other.ordenTrabajoUnidadTrabajoSubCuartelList))
			return false;
		if (unidadTrabajo == null) {
			if (other.unidadTrabajo != null)
				return false;
		} else if (!unidadTrabajo.equals(other.unidadTrabajo))
			return false;
		return true;
	}



}
