package com.softdelsur.agricola.entity;

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

@Entity
@Table(name = "orden_de_trabajo_tarea")
public class OrdenTrabajoTarea {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_orden_de_trabajo_tarea", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	
	@JoinColumn
	@ManyToOne
	private OrdenTrabajo ordenTrabajo;
	
	@JoinColumn
	@ManyToOne
	private Tarea tarea;
	
	@JoinColumn
	@ManyToOne
	private EstadoOrdenTrabajoTarea estado;
	
	@JoinColumn
	@ManyToOne
	private Trato trato;
	
	@JoinColumn
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrdenTrabajoTareaMaquinaria> ordenTrabajoTareaMaquinariaList = new ArrayList<>();
	
	@JoinColumn
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrdenTrabajoTareaInsumo> ordenTrabajoTareaInsumoList = new ArrayList<>();
	
	private int cantidadPersonal;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OrdenTrabajo getOrdenTrabajo() {
		return ordenTrabajo;
	}

	public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public EstadoOrdenTrabajoTarea getEstado() {
		return estado;
	}

	public void setEstado(EstadoOrdenTrabajoTarea estado) {
		this.estado = estado;
	}

	public Trato getTrato() {
		return trato;
	}

	public void setTrato(Trato trato) {
		this.trato = trato;
	}

	public List<OrdenTrabajoTareaMaquinaria> getOrdenTrabajoTareaMaquinariaList() {
		return ordenTrabajoTareaMaquinariaList;
	}

	public void setOrdenTrabajoTareaMaquinariaList(List<OrdenTrabajoTareaMaquinaria> ordenTrabajoTareaMaquinariaList) {
		this.ordenTrabajoTareaMaquinariaList = ordenTrabajoTareaMaquinariaList;
	}

	public List<OrdenTrabajoTareaInsumo> getOrdenTrabajoTareaInsumoList() {
		return ordenTrabajoTareaInsumoList;
	}

	public void setOrdenTrabajoTareaInsumoList(List<OrdenTrabajoTareaInsumo> ordenTrabajoTareaInsumoList) {
		this.ordenTrabajoTareaInsumoList = ordenTrabajoTareaInsumoList;
	}

	public int getCantidadPersonal() {
		return cantidadPersonal;
	}

	public void setCantidadPersonal(int cantidadPersonal) {
		this.cantidadPersonal = cantidadPersonal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidadPersonal;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ordenTrabajo == null) ? 0 : ordenTrabajo.hashCode());
		result = prime * result + ((ordenTrabajoTareaInsumoList == null) ? 0 : ordenTrabajoTareaInsumoList.hashCode());
		result = prime * result
				+ ((ordenTrabajoTareaMaquinariaList == null) ? 0 : ordenTrabajoTareaMaquinariaList.hashCode());
		result = prime * result + ((tarea == null) ? 0 : tarea.hashCode());
		result = prime * result + ((trato == null) ? 0 : trato.hashCode());
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
		OrdenTrabajoTarea other = (OrdenTrabajoTarea) obj;
		if (cantidadPersonal != other.cantidadPersonal)
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ordenTrabajo == null) {
			if (other.ordenTrabajo != null)
				return false;
		} else if (!ordenTrabajo.equals(other.ordenTrabajo))
			return false;
		if (ordenTrabajoTareaInsumoList == null) {
			if (other.ordenTrabajoTareaInsumoList != null)
				return false;
		} else if (!ordenTrabajoTareaInsumoList.equals(other.ordenTrabajoTareaInsumoList))
			return false;
		if (ordenTrabajoTareaMaquinariaList == null) {
			if (other.ordenTrabajoTareaMaquinariaList != null)
				return false;
		} else if (!ordenTrabajoTareaMaquinariaList.equals(other.ordenTrabajoTareaMaquinariaList))
			return false;
		if (tarea == null) {
			if (other.tarea != null)
				return false;
		} else if (!tarea.equals(other.tarea))
			return false;
		if (trato == null) {
			if (other.trato != null)
				return false;
		} else if (!trato.equals(other.trato))
			return false;
		return true;
	}



	


	
	
}
