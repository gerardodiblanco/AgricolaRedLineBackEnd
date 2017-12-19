package com.softdelsur.agricola.service;

import java.sql.Date;
import java.util.List;

import com.softdelsur.agricola.entity.OrdenTrabajo;

public interface OrdenTrabajoService {
	
	OrdenTrabajo findOrdenTrabajoById(String id);
	OrdenTrabajo addOrdenTrabajo(OrdenTrabajo ordenTrabajo);
	List<OrdenTrabajo> findOrdenesTrabajosActivos();

}
