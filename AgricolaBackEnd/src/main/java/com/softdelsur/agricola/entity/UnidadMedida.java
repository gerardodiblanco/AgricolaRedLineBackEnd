package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "unidad_medida")
public class UnidadMedida {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_unidad_medida", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idUnidadMedida;
	private String nombreUM;

	public UnidadMedida() {
		super();
	}

	public String getIdUnidadMedida() {
		return idUnidadMedida;
	}

	public void setIdUnidadMedida(String idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}

	public String getNombreUM() {
		return nombreUM;
	}

	public void setNombreUM(String nombreUM) {
		this.nombreUM = nombreUM;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreUM == null) ? 0 : nombreUM.hashCode());
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
		UnidadMedida other = (UnidadMedida) obj;
		if (nombreUM == null) {
			if (other.nombreUM != null)
				return false;
		} else if (!nombreUM.equals(other.nombreUM))
			return false;
		return true;
	}

}
