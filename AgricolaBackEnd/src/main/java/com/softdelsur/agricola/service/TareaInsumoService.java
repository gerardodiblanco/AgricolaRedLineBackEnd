package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.Tarea;
import com.softdelsur.agricola.entity.TareaInsumo;

public interface TareaInsumoService {

	List<TareaInsumo> findTareaInsumoByTarea(Tarea tarea);

	TareaInsumo addTareaInsumo(TareaInsumo tareaInsumo);
}
