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
@Table(name = "cuartel")
public class Cuartel {
	  private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name= "id_cuartel", unique = true, nullable = false)
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @GeneratedValue(generator = "uuid")
	    private String idCuartel;
	private int codigo;
	private String descripcion;
	private float hectarea;
	@JoinColumn(name = "id_cuartel")
	@OneToMany
	private List<SubCuartel> subcuarteles  = new ArrayList<SubCuartel>();
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Campo campo;
	
	@OneToMany(cascade = CascadeType.MERGE )
	private List<Coordenada> coordenadaList = new ArrayList<Coordenada>();
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private EstadoCuartel estadoCuartel;
	
	public Cuartel() {
		
	}
	public String getIdCuartel() {
		return idCuartel;
	}
	public void setIdCuartel(String idCuartel) {
		this.idCuartel = idCuartel;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getHectarea() {
		return hectarea;
	}
	public void setHectarea(float hectarea) {
		this.hectarea = hectarea;
	}
	public List<SubCuartel> getSubcuarteles() {
		return subcuarteles;
	}
	public void setSubcuarteles(List<SubCuartel> subcuarteles) {
		this.subcuarteles = subcuarteles;
	}
	public Campo getCampo() {
		return campo;
	}
	public void setCampo(Campo campo) {
		this.campo = campo;
	}
	
	
	public List<Coordenada> getCoordenadaList() {
		return coordenadaList;
	}
	public void setCoordenadaList(List<Coordenada> coordenadaList) {
		this.coordenadaList = coordenadaList;

	}
	
	
	public EstadoCuartel getEstadoCuartel() {
		return estadoCuartel;
	}
	public void setEstadoCuartel(EstadoCuartel estadoCuartel) {
		this.estadoCuartel = estadoCuartel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campo == null) ? 0 : campo.hashCode());
		result = prime * result + codigo;
		result = prime * result + ((coordenadaList == null) ? 0 : coordenadaList.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estadoCuartel == null) ? 0 : estadoCuartel.hashCode());
		result = prime * result + Float.floatToIntBits(hectarea);
		result = prime * result + ((idCuartel == null) ? 0 : idCuartel.hashCode());
		result = prime * result + ((subcuarteles == null) ? 0 : subcuarteles.hashCode());
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
		Cuartel other = (Cuartel) obj;
		if (campo == null) {
			if (other.campo != null)
				return false;
		} else if (!campo.equals(other.campo))
			return false;
		if (codigo != other.codigo)
			return false;
		if (coordenadaList == null) {
			if (other.coordenadaList != null)
				return false;
		} else if (!coordenadaList.equals(other.coordenadaList))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estadoCuartel == null) {
			if (other.estadoCuartel != null)
				return false;
		} else if (!estadoCuartel.equals(other.estadoCuartel))
			return false;
		if (Float.floatToIntBits(hectarea) != Float.floatToIntBits(other.hectarea))
			return false;
		if (idCuartel == null) {
			if (other.idCuartel != null)
				return false;
		} else if (!idCuartel.equals(other.idCuartel))
			return false;
		if (subcuarteles == null) {
			if (other.subcuarteles != null)
				return false;
		} else if (!subcuarteles.equals(other.subcuarteles))
			return false;
		return true;
	}
	

	

	

	}
