package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.entity.EstadoCuartel;

public interface CuartelService {

	List<Cuartel> findCuartelesByCampoAndEstadoCuartel(Campo campo, EstadoCuartel estadoCuartel);

	Cuartel addCuartel(Cuartel cuartel);

	Cuartel findCuartelById(String id);

	String eliminarCuartel(String id);

}
