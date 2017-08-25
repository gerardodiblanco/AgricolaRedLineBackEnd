package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tareaMaquina")
public class TareaMaquina {


    private static final long serialVersionUID = 1L;

    @Id
    @Column(name= "id", unique = true, nullable = false)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;
	private float consumo;
	private int horasTrabajo;
	@ManyToOne
	private Maquina maquina;
	public TareaMaquina() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getConsumo() {
		return consumo;
	}
	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}
	public int getHorasTrabajo() {
		return horasTrabajo;
	}
	public void setHorasTrabajo(int horasTrabajo) {
		this.horasTrabajo = horasTrabajo;
	}
	public Maquina getMaquina() {
		return maquina;
	}
	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(consumo);
		result = prime * result + horasTrabajo;
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
		TareaMaquina other = (TareaMaquina) obj;
		if (Float.floatToIntBits(consumo) != Float.floatToIntBits(other.consumo))
			return false;
		if (horasTrabajo != other.horasTrabajo)
			return false;
		if (maquina == null) {
			if (other.maquina != null)
				return false;
		} else if (!maquina.equals(other.maquina))
			return false;
		return true;
	}
	
	

}
