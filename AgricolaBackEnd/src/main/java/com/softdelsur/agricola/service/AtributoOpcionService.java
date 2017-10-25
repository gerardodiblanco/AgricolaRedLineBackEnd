package com.softdelsur.agricola.service;



import java.util.List;

import com.softdelsur.agricola.entity.AtributoOpcion;

public interface AtributoOpcionService {

	
	AtributoOpcion findAtributoOpcionById(String id);
	AtributoOpcion addAtributoOpcion(AtributoOpcion atributoOpcion);
	AtributoOpcion eliminarAtributoOpcion(String id);
	List<AtributoOpcion> findAtributoOpcionActivos(String id);
}
