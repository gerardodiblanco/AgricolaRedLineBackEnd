package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "depositos")
public class Deposito {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_deposito", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	private String referenciaId;
	private boolean estadoActivo;

	public Deposito() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdDeposito() {
		return referenciaId;
	}

	public void setIdDeposito(String idDeposito) {
		this.referenciaId = idDeposito;
	}

	public boolean isEstadoActivo() {
		return estadoActivo;
	}

	public void setEstadoActivo(boolean estadoActivo) {
		this.estadoActivo = estadoActivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (estadoActivo ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((referenciaId == null) ? 0 : referenciaId.hashCode());
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
		Deposito other = (Deposito) obj;
		if (estadoActivo != other.estadoActivo)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (referenciaId == null) {
			if (other.referenciaId != null)
				return false;
		} else if (!referenciaId.equals(other.referenciaId))
			return false;
		return true;
	}

}
