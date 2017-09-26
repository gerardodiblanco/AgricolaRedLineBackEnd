package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.entity.Cuartel;

public interface CuartelService {
	
	List<Cuartel> findCuartelByCampo(Campo campo);
	
	Cuartel addCuartel(Cuartel cuartel);
	
	Cuartel findCuartelById(String id);

}
