package com.softdelsur.agricola.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "proveedores")
public class Proveedor {


    private static final long serialVersionUID = 1L;

    @Id
    @Column(name= "id_proveedor", unique = true, nullable = false)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String idProveedor;
	private int codigo;
	private String descripcion;
@Column(name = "razon_social")
	private String razonSocial;
@ManyToOne(cascade = CascadeType.REFRESH)
	private EstadoProveedor estado;
public Proveedor(){
	
}
public Proveedor(int codigo, String descripcion, String razonSocial, EstadoProveedor estado) {
	super();
	this.codigo = codigo;
	this.descripcion = descripcion;
	this.razonSocial = razonSocial;
	this.estado = estado;
}
public String getIdProveedor() {
	return idProveedor;
}
public void setIdProveedor(String idProveedor) {
	this.idProveedor = idProveedor;
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
public String getRazonSocial() {
	return razonSocial;
}
public void setRazonSocial(String razonSocial) {
	this.razonSocial = razonSocial;
}
public EstadoProveedor getEstado() {
	return estado;
}
public void setEstado(EstadoProveedor estado) {
	this.estado = estado;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + codigo;
	result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
	result = prime * result + ((estado == null) ? 0 : estado.hashCode());
	result = prime * result + ((razonSocial == null) ? 0 : razonSocial.hashCode());
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
	Proveedor other = (Proveedor) obj;
	if (codigo != other.codigo)
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
	if (razonSocial == null) {
		if (other.razonSocial != null)
			return false;
	} else if (!razonSocial.equals(other.razonSocial))
		return false;
	return true;
}


}
