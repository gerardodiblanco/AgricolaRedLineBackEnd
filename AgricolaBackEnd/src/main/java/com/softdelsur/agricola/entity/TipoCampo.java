package com.softdelsur.agricola.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tipos")
public class TipoCampo {
	   private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name= "id_tipo_campo", unique = true, nullable = false)
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @GeneratedValue(generator = "uuid")
	    private String idTipo;
	private int codigo;
	private int descripcion;
	public TipoCampo(){
		
	}
	public TipoCampo(int codigo, int descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	public String getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + descripcion;
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
		TipoCampo other = (TipoCampo) obj;
		if (codigo != other.codigo)
			return false;
		if (descripcion != other.descripcion)
			return false;
		return true;
	}
	

}
