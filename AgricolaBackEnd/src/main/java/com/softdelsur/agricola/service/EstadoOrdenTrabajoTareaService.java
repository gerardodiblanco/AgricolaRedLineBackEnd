package com.softdelsur.agricola.service;

import com.softdelsur.agricola.entity.EstadoOrdenTrabajoTarea;

public interface EstadoOrdenTrabajoTareaService {

	EstadoOrdenTrabajoTarea findByNombre(String nombre);

	EstadoOrdenTrabajoTarea addEstadoOrdenTrabajoTarea(EstadoOrdenTrabajoTarea estadoOrdenTrabajoTarea);

}
