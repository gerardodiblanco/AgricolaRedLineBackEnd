package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.Tarea;
import com.softdelsur.agricola.entity.TareaTrato;

public interface TareaTratoService {
	
	
		List<TareaTrato> findTareaTratoByTarea(Tarea tarea);
		TareaTrato addTareaTrato(TareaTrato tareaTrato);
	


}
