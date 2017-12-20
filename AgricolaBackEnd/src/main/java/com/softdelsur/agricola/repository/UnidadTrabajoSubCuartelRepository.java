package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.entity.UnidadTrabajo;
import com.softdelsur.agricola.entity.UnidadTrabajoSubCuartel;

@Repository("unidadTrabajoSubCuartelRepository")
public interface UnidadTrabajoSubCuartelRepository extends JpaRepository<UnidadTrabajoSubCuartel, Serializable> {

	UnidadTrabajoSubCuartel findBySubCuartelAndFechaBaja(SubCuartel subCuartel, Date fechaBaja);

	List<UnidadTrabajoSubCuartel> findByUnidadTrabajoAndFechaBaja(UnidadTrabajo unidadTrabajo, Date fechaBaja);

	UnidadTrabajoSubCuartel findById(String id);
}
