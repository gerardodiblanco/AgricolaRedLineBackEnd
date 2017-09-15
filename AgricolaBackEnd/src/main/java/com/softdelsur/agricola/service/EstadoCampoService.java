package com.softdelsur.agricola.service;

import com.softdelsur.agricola.entity.EstadoCampo;

public interface EstadoCampoService {
	
	EstadoCampo addEstadoCampo(EstadoCampo estado);
	
	EstadoCampo buscarEstadoCampoPorNombre(String nombre);

}
