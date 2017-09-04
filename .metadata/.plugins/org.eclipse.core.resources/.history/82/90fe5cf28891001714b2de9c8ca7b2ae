package com.softdelsur.agricola.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "campos")
public class Campo {
	   private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name= "id_campo", unique = true, nullable = false)
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @GeneratedValue(generator = "uuid")
	    private String idCampo;
	    
	private String altitud;
	private int codigo;
	private String CUIT;
	private float hectarea;
	private String nombre;
@ManyToOne(cascade = CascadeType.REFRESH)
	private TipoCampo tipo;
@ManyToOne(cascade = CascadeType.REFRESH)
	private Domicilio domicilio;
@ManyToOne(cascade = CascadeType.REFRESH)
	private Proveedor proveedor;
@JoinColumn(name = "id_Campo")
@OneToMany(cascade = CascadeType.REFRESH)
	private List<Cuartel> cuartelList = new ArrayList<Cuartel>();

@OneToMany(cascade = CascadeType.PERSIST )
	private List<Coordenada> coordenadaList = new ArrayList<Coordenada>();

public Campo() {
	super();
}
public String getIdCampo() {
	return idCampo;
}
public void setIdCampo(String idCampo) {
	this.idCampo = idCampo;
}
public String getAltitud() {
	return altitud;
}
public void setAltitud(String altitud) {
	this.altitud = altitud;
}
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public String getCUIT() {
	return CUIT;
}
public void setCUIT(String cUIT) {
	CUIT = cUIT;
}
public float getHectarea() {
	return hectarea;
}
public void setHectarea(float hectarea) {
	this.hectarea = hectarea;
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public TipoCampo getTipo() {
	return tipo;
}
public void setTipo(TipoCampo tipo) {
	this.tipo = tipo;
}
public Domicilio getDomicilio() {
	return domicilio;
}
public void setDomicilio(Domicilio domicilio) {
	this.domicilio = domicilio;
}
public Proveedor getProveedor() {
	return proveedor;
}
public void setProveedor(Proveedor proveedor) {
	this.proveedor = proveedor;
}
public List<Cuartel> getCuartelList() {
	return cuartelList;
}
public void setCuartelList(List<Cuartel> cuartelList) {
	this.cuartelList = cuartelList;
}
public List<Coordenada> getCoordenadaList() {
	return coordenadaList;
}
public void setCoordenadaList(List<Coordenada> coordenadaList) {
	this.coordenadaList = coordenadaList;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((CUIT == null) ? 0 : CUIT.hashCode());
	result = prime * result + ((altitud == null) ? 0 : altitud.hashCode());
	result = prime * result + codigo;
	result = prime * result + ((coordenadaList == null) ? 0 : coordenadaList.hashCode());
	result = prime * result + ((cuartelList == null) ? 0 : cuartelList.hashCode());
	result = prime * result + ((domicilio == null) ? 0 : domicilio.hashCode());
	result = prime * result + Float.floatToIntBits(hectarea);
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	result = prime * result + ((proveedor == null) ? 0 : proveedor.hashCode());
	result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
	Campo other = (Campo) obj;
	if (CUIT == null) {
		if (other.CUIT != null)
			return false;
	} else if (!CUIT.equals(other.CUIT))
		return false;
	if (altitud == null) {
		if (other.altitud != null)
			return false;
	} else if (!altitud.equals(other.altitud))
		return false;
	if (codigo != other.codigo)
		return false;
	if (coordenadaList == null) {
		if (other.coordenadaList != null)
			return false;
	} else if (!coordenadaList.equals(other.coordenadaList))
		return false;
	if (cuartelList == null) {
		if (other.cuartelList != null)
			return false;
	} else if (!cuartelList.equals(other.cuartelList))
		return false;
	if (domicilio == null) {
		if (other.domicilio != null)
			return false;
	} else if (!domicilio.equals(other.domicilio))
		return false;
	if (Float.floatToIntBits(hectarea) != Float.floatToIntBits(other.hectarea))
		return false;
	if (nombre == null) {
		if (other.nombre != null)
			return false;
	} else if (!nombre.equals(other.nombre))
		return false;
	if (proveedor == null) {
		if (other.proveedor != null)
			return false;
	} else if (!proveedor.equals(other.proveedor))
		return false;
	if (tipo == null) {
		if (other.tipo != null)
			return false;
	} else if (!tipo.equals(other.tipo))
		return false;
	return true;
}




}
