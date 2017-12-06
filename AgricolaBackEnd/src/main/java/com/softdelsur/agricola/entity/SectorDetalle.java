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
@Table(name = "sector_detalle")
public class SectorDetalle {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;

	private int codigo;
	private String descripcion;
	@ManyToOne
	private SubCuartel subcuartel;
	@JoinColumn(name = "id_sector_detalle")
	@OneToMany
	private List<TareaDetalleSector> tareasDetalle = new ArrayList<TareaDetalleSector>();

	public SectorDetalle() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public SubCuartel getSubcuartel() {
		return subcuartel;
	}

	public void setSubcuartel(SubCuartel subcuartel) {
		this.subcuartel = subcuartel;
	}

	public List<TareaDetalleSector> getTareasDetalle() {
		return tareasDetalle;
	}

	public void setTareasDetalle(List<TareaDetalleSector> tareasDetalle) {
		this.tareasDetalle = tareasDetalle;
	}

}
