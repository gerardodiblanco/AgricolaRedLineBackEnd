package com.softdelsur.agricola.service;

import com.softdelsur.agricola.entity.EstadoCuartel;

public interface EstadoCuartelService {
	
	EstadoCuartel findEstadoCuartelByNombre(String nombre);
	EstadoCuartel addEstadoCuartel(EstadoCuartel estadoCuartel);

}
