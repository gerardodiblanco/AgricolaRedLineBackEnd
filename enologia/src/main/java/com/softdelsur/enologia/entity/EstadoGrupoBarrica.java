package com.softdelsur.enologia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "estado_gurpo_barricas")
public class EstadoGrupoBarrica {

	
	
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name= "id_estado_grupo", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")

	private String idEstadoGrupo;
	
	@Column(name = "nombre")
	private String nombreEstadoGrupo;

	public EstadoGrupoBarrica() {
		super();
	}

	public EstadoGrupoBarrica(String nombreEstadoGrupo) {
		super();
		this.nombreEstadoGrupo = nombreEstadoGrupo;
	}

	
	
	public String getIdEstadoGrupo() {
		return idEstadoGrupo;
	}

	public void setIdEstadoGrupo(String idEstadoGrupo) {
		this.idEstadoGrupo = idEstadoGrupo;
	}

	public String getNombreEstadoGrupo() {
		return nombreEstadoGrupo;
	}

	public void setNombreEstadoGrupo(String nombreEstadoGrupo) {
		this.nombreEstadoGrupo = nombreEstadoGrupo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreEstadoGrupo == null) ? 0 : nombreEstadoGrupo.hashCode());
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
		EstadoGrupoBarrica other = (EstadoGrupoBarrica) obj;
		if (nombreEstadoGrupo == null) {
			if (other.nombreEstadoGrupo != null)
				return false;
		} else if (!nombreEstadoGrupo.equals(other.nombreEstadoGrupo))
			return false;
		return true;
	}

	
}
