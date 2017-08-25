package com.softdelsur.enologia.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "grupos")
@PrimaryKeyJoinColumn(name = "id_grupo")
public class GrupoBarrica extends ElementosConOperacionesEnologicas{
	
	@Column(name = "codigo")
	private int codigoGrupo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToOne
	private EstadoGrupoBarrica estado;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Barrica> barricas = new ArrayList<Barrica>();

	public GrupoBarrica() {
		super();
	}


	public int getCodigoGrupo() {
		return codigoGrupo;
	}


	public void setCodigoGrupo(int codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<Barrica> getBarricas() {
		return barricas;
	}

	public void setBarricas(List<Barrica> barricas) {
		this.barricas = barricas;
	}




	public EstadoGrupoBarrica getEstado() {
		return estado;
	}


	public void setEstado(EstadoGrupoBarrica estado) {
		this.estado = estado;
	}


	@Override
	public void operacionEnologica() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barricas == null) ? 0 : barricas.hashCode());
		result = prime * result + codigoGrupo;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
		GrupoBarrica other = (GrupoBarrica) obj;
		if (barricas == null) {
			if (other.barricas != null)
				return false;
		} else if (!barricas.equals(other.barricas))
			return false;
		if (codigoGrupo != other.codigoGrupo)
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
		return true;
	}
	
	
	

}
