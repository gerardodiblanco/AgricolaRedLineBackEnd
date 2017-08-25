package com.softdelsur.enologia.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.enologia.entity.EstadoBarrica;

@Repository("estadoBarricaRepository")
public interface EstadoBarricaRepository extends JpaRepository<EstadoBarrica, Serializable>{

	public abstract EstadoBarrica findByidEstadoBarrica(String id);
}
