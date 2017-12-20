package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.EstadoOrdenTrabajoTarea;
import com.softdelsur.agricola.entity.OrdenTrabajo;
import com.softdelsur.agricola.entity.OrdenTrabajoTarea;

@Repository("ordenTrabajoTareaRepository")
public interface OrdenTrabajoTareaRepository extends JpaRepository<OrdenTrabajoTarea, Serializable> {

	List<OrdenTrabajoTarea> findOrdenTrabajoTareaByOrdenTrabajoAndEstado(OrdenTrabajo ordenTrabajo,
			EstadoOrdenTrabajoTarea estadoOrdenTrabajoTarea);

}
