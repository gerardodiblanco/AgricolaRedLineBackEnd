package com.softdelsur.enologia.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.enologia.entity.EstadoGrupoBarrica;

@Repository("estadoGrupoBarricaRepository")
public interface EstadoGrupoBarricaRepository extends JpaRepository<EstadoGrupoBarrica, Serializable>{

	public abstract EstadoGrupoBarrica findByidEstadoGrupo(String id);
		
}
