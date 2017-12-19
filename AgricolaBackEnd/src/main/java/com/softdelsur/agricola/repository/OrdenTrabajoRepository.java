package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.OrdenTrabajo;
@Repository("ordenTrabajoRepository")
public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Serializable> {
	
	OrdenTrabajo findOrdenTrabajoById(String id);
	List<OrdenTrabajo> findOrdenTrabajoByFechaBaja(Date fechaBaja);

}
