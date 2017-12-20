package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.Tarea;
import com.softdelsur.agricola.entity.TareaInsumo;

@Repository("tareaInsumoRepository")
public interface TareaInsumoRepository extends JpaRepository<TareaInsumo, Serializable> {

	List<TareaInsumo> findTareaInsumoActivasByTareaAndFechaBaja(Tarea tarea, Date fechaBaja);
}
