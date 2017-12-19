package com.softdelsur.agricola.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softdelsur.agricola.entity.EstadoOrdenTrabajoTarea;

public interface EstadoOrdenTrabajoTareaRepository extends JpaRepository<EstadoOrdenTrabajoTarea, Serializable>{

	EstadoOrdenTrabajoTarea findByNombre(String nombre);
}
