package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.Tarea;

public interface TareaService {

	Tarea removeTarea(String id);

	Tarea addTarea(Tarea tarea);

	List<Tarea> findTareasActivas();

	Tarea findTareaById(String id);
}
