package com.softdelsur.agricola.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tareaMaquinaria")
public class TareaMaquinaria {


    private static final long serialVersionUID = 1L;

    @Id
    @Column(name= "id", unique = true, nullable = false)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;
	
    private Date fechaAlta;
    private Date fechaBaja;
    
    @OneToOne(cascade = CascadeType.REFRESH)
    private Tarea Tarea;
    
    @OneToOne(cascade = CascadeType.REFRESH)
	private Maquinaria maquina;
	
    public TareaMaquinaria() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Maquinaria getMaquina() {
		return maquina;
	}
	public void setMaquina(Maquinaria maquina) {
		this.maquina = maquina;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public Tarea getTarea() {
		return Tarea;
	}
	public void setTarea(Tarea tarea) {
		Tarea = tarea;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Tarea == null) ? 0 : Tarea.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaBaja == null) ? 0 : fechaBaja.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TareaMaquinaria other = (TareaMaquinaria) obj;
		if (Tarea == null) {
			if (other.Tarea != null)
				return false;
		} else if (!Tarea.equals(other.Tarea))
			return false;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		if (fechaBaja == null) {
			if (other.fechaBaja != null)
				return false;
		} else if (!fechaBaja.equals(other.fechaBaja))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maquina == null) {
			if (other.maquina != null)
				return false;
		} else if (!maquina.equals(other.maquina))
			return false;
		return true;
	}

}
