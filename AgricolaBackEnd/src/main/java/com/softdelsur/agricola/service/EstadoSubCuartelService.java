package com.softdelsur.agricola.service;

import com.softdelsur.agricola.entity.EstadoSubCuartel;

public interface EstadoSubCuartelService {
	
	EstadoSubCuartel addEstadoSubCuartel(EstadoSubCuartel estadoSubCuartel);
	EstadoSubCuartel buscarEstadoActivo( );
	EstadoSubCuartel buscarEstadoInactivo( );

}
