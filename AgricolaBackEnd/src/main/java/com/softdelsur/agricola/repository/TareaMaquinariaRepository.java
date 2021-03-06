package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.Tarea;
import com.softdelsur.agricola.entity.TareaMaquinaria;

@Repository("tareaMaquinariaRepository")
public interface TareaMaquinariaRepository extends JpaRepository<TareaMaquinaria, Serializable> {

	List<TareaMaquinaria> findTareaMaquinariaActicaByTareaAndFechaBaja(Tarea tarea, Date fechaBaja);
}
