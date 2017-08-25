package com.softdelsur.agricola.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "subCuartel")
public class SubCuartel {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name= "id", unique = true, nullable = false)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String idSubCuartel;
	private int codigo;
	private String descripcion;
	private float hectarea;
	@ManyToOne
	private EstadoSubCuartel estado;
	@JoinColumn(name = "id_subcuartel")
	@OneToMany
	public List<AtributoSubCuartel> atributosSubCuartel = new ArrayList<AtributoSubCuartel>();
	@JoinColumn(name = "id_subcuartel")
	@OneToMany
	public List<PeriodoVariedad> periodosVariedad  = new ArrayList<PeriodoVariedad>();
	@JoinColumn(name = "id_subcuartel")
	@OneToMany
	public List<Caracteristica> caracteristicas  = new ArrayList<Caracteristica>();
	public SubCuartel() {
		super();
	}
	public String getIdSubCuartel() {
		return idSubCuartel;
	}
	public void setIdSubCuartel(String idSubCuartel) {
		this.idSubCuartel = idSubCuartel;
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
	public EstadoSubCuartel getEstado() {
		return estado;
	}
	public void setEstado(EstadoSubCuartel estado) {
		this.estado = estado;
	}
	public List<AtributoSubCuartel> getAtributosSubCuartel() {
		return atributosSubCuartel;
	}
	public void setAtributosSubCuartel(List<AtributoSubCuartel> atributosSubCuartel) {
		this.atributosSubCuartel = atributosSubCuartel;
	}
	public List<PeriodoVariedad> getPeriodosVariedad() {
		return periodosVariedad;
	}
	public void setPeriodosVariedad(List<PeriodoVariedad> periodosVariedad) {
		this.periodosVariedad = periodosVariedad;
	}
	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atributosSubCuartel == null) ? 0 : atributosSubCuartel.hashCode());
		result = prime * result + ((caracteristicas == null) ? 0 : caracteristicas.hashCode());
		result = prime * result + codigo;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + Float.floatToIntBits(hectarea);
		result = prime * result + ((periodosVariedad == null) ? 0 : periodosVariedad.hashCode());
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
		SubCuartel other = (SubCuartel) obj;
		if (atributosSubCuartel == null) {
			if (other.atributosSubCuartel != null)
				return false;
		} else if (!atributosSubCuartel.equals(other.atributosSubCuartel))
			return false;
		if (caracteristicas == null) {
			if (other.caracteristicas != null)
				return false;
		} else if (!caracteristicas.equals(other.caracteristicas))
			return false;
		if (codigo != other.codigo)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (Float.floatToIntBits(hectarea) != Float.floatToIntBits(other.hectarea))
			return false;
		if (periodosVariedad == null) {
			if (other.periodosVariedad != null)
				return false;
		} else if (!periodosVariedad.equals(other.periodosVariedad))
			return false;
		return true;
	}

	
}
