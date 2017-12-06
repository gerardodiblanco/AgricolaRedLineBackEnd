package com.softdelsur.agricola.model;

import java.util.ArrayList;
import java.util.List;

public class CampoModelNO {
	private String idCampo;

	private int codigo;
	private String CUIT;
	private float hectarea;
	private String nombre;

	private TipoCampoModel tipo;

	private DomicilioModel domicilio;

	private ProveedorModelABMCampo proveedor;

	private List<CuartelModel> cuartelList = new ArrayList<CuartelModel>();
	private List<CoordenadaModel> coordenadaList = new ArrayList<CoordenadaModel>();

	public CampoModelNO() {
		super();
	}

	public String getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(String idCampo) {
		this.idCampo = idCampo;
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

	public TipoCampoModel getTipo() {
		return tipo;
	}

	public void setTipo(TipoCampoModel tipo) {
		this.tipo = tipo;
	}

	public DomicilioModel getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(DomicilioModel domicilio) {
		this.domicilio = domicilio;
	}

	public ProveedorModelABMCampo getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorModelABMCampo proveedor) {
		this.proveedor = proveedor;
	}

	public List<CuartelModel> getCuartelList() {
		return cuartelList;
	}

	public void setCuartelList(List<CuartelModel> cuartelList) {
		this.cuartelList = cuartelList;
	}

	public List<CoordenadaModel> getCoordenadaList() {
		return coordenadaList;
	}

	public void setCoordenadaList(List<CoordenadaModel> coordenadaList) {
		this.coordenadaList = coordenadaList;
	}

}
