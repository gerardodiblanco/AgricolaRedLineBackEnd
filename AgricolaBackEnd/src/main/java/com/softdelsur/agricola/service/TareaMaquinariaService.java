package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.Tarea;
import com.softdelsur.agricola.entity.TareaMaquinaria;

public interface TareaMaquinariaService {

		List<TareaMaquinaria> findTareaMaquinariaByTarea(Tarea tarea);
		TareaMaquinaria addTareaMaquinaria(TareaMaquinaria tareaMaquinaria);
	

}
