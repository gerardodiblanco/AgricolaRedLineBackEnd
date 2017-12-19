package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.EstadoOrdenTrabajoTarea;
import com.softdelsur.agricola.entity.OrdenTrabajo;
import com.softdelsur.agricola.entity.OrdenTrabajoTarea;

public interface OrdenTrabajoTareaService {
	
	OrdenTrabajoTarea addOrdenTrabajoTarea(OrdenTrabajoTarea ordenTrabajoTarea);
	List<OrdenTrabajoTarea> findOrdenTrabajoTareaByOrdenTrabajoAndEstado(OrdenTrabajo ordenTrabajo, EstadoOrdenTrabajoTarea estadoOrdenTrabajoTarea);
	
	void delelteOrdenTrabajoTarea(OrdenTrabajoTarea ordenTrabajoTarea);
}
