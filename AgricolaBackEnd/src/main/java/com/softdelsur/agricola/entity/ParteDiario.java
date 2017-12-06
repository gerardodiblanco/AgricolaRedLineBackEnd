package com.softdelsur.agricola.entity;

import java.sql.Date;
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
@Table(name = "parteDiario")
public class ParteDiario {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_parte_diario", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idParteDiario;
	private int codigo;
	private Date Fecha;
	@JoinColumn(name = "id_parte_diario")
	@OneToMany
	public List<DetalleParteDiario> detallesParteDiario = new ArrayList<DetalleParteDiario>();
	@ManyToOne
	public EstadoParteDiario estadoParteDiario;
	@ManyToOne
	public Periodo periodo;

	public ParteDiario() {
		super();
	}

	public String getIdParteDiario() {
		return idParteDiario;
	}

	public void setIdParteDiario(String idParteDiario) {
		this.idParteDiario = idParteDiario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public List<DetalleParteDiario> getDetallesParteDiario() {
		return detallesParteDiario;
	}

	public void setDetallesParteDiario(List<DetalleParteDiario> detallesParteDiario) {
		this.detallesParteDiario = detallesParteDiario;
	}

	public EstadoParteDiario getEstadoParteDiario() {
		return estadoParteDiario;
	}

	public void setEstadoParteDiario(EstadoParteDiario estadoParteDiario) {
		this.estadoParteDiario = estadoParteDiario;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Fecha == null) ? 0 : Fecha.hashCode());
		result = prime * result + codigo;
		result = prime * result + ((estadoParteDiario == null) ? 0 : estadoParteDiario.hashCode());
		result = prime * result + ((periodo == null) ? 0 : periodo.hashCode());
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
		ParteDiario other = (ParteDiario) obj;
		if (Fecha == null) {
			if (other.Fecha != null)
				return false;
		} else if (!Fecha.equals(other.Fecha))
			return false;
		if (codigo != other.codigo)
			return false;
		if (estadoParteDiario == null) {
			if (other.estadoParteDiario != null)
				return false;
		} else if (!estadoParteDiario.equals(other.estadoParteDiario))
			return false;
		if (periodo == null) {
			if (other.periodo != null)
				return false;
		} else if (!periodo.equals(other.periodo))
			return false;
		return true;
	}

}
