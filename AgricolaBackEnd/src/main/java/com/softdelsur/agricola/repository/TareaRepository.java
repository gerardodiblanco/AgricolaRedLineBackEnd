package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.Tarea;

@Repository("tareaRepository")
public interface TareaRepository extends JpaRepository<Tarea, Serializable> {

	List<Tarea> findTareasByFechaBaja(Date fechaBaja);

	Tarea findTareaById(String id);

}
