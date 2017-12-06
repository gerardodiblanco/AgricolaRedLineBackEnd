package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.UnidadTrabajo;
import com.softdelsur.agricola.entity.UnidadTrabajoPersonal;

@Repository("unidadTrabajoPersonalRepository")
public interface UnidadTrabajoPersonalRepository extends JpaRepository<UnidadTrabajoPersonal, Serializable>{

	
	List<UnidadTrabajoPersonal> findUTPByUnidadTrabajoAndFechaBaja(UnidadTrabajo unidadTrabajo, Date fechaBaja);
	UnidadTrabajoPersonal findUTPById(String id);
}
