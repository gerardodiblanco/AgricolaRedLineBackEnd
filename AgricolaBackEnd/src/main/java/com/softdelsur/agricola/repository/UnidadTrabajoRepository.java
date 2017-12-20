package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.UnidadTrabajo;

@Repository("unidadTrabajoRepository")
public interface UnidadTrabajoRepository extends JpaRepository<UnidadTrabajo, Serializable> {

	UnidadTrabajo findUnidadTrabajoById(String id);

	List<UnidadTrabajo> findAllActivosByEstadoActivo(boolean estadoActivo);
}
