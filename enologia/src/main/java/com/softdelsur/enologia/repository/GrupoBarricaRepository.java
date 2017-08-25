package com.softdelsur.enologia.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.enologia.entity.GrupoBarrica;

@Repository("grupoBarricaRepository")
public interface GrupoBarricaRepository extends JpaRepository<GrupoBarrica, Serializable>{

	public abstract GrupoBarrica findById(String id);
}
