package com.softdelsur.agricola.model;

public class CoordenadaModel {
	
    private String id;
    
    private double latitud;
    private double longitud;
    private int nroOrden;
    
    public CoordenadaModel(int orden,double lat,double lng) {
    	this.latitud = lat;
    	this.longitud = lng;
    	this.nroOrden = orden;
    }
    
    
    
	public CoordenadaModel() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}



	public int getNroOrden() {
		return nroOrden;
	}



	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	
    
    

}
