package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "utilizacionRealMaquina")
public class UtilizacionRealMaquina {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	private int cantHoras;
	private int consumo;
	
	@ManyToOne
	public Maquinaria maquina;

	public UtilizacionRealMaquina() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCantHoras() {
		return cantHoras;
	}

	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}

	public int getConsumo() {
		return consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	public Maquinaria getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquinaria maquina) {
		this.maquina = maquina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantHoras;
		result = prime * result + consumo;
		result = prime * result + ((maquina == null) ? 0 : maquina.hashCode());
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
		UtilizacionRealMaquina other = (UtilizacionRealMaquina) obj;
		if (cantHoras != other.cantHoras)
			return false;
		if (consumo != other.consumo)
			return false;
		if (maquina == null) {
			if (other.maquina != null)
				return false;
		} else if (!maquina.equals(other.maquina))
			return false;
		return true;
	}

}
