package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.Maquinaria;

@Repository("maquinariaRepository")
public interface MaquinariaRespository extends JpaRepository<Maquinaria, Serializable>{

	Maquinaria findMaquinariaById(String id);
	List<Maquinaria> findMaquinariasByEstadoMaquinaria(boolean estado);
}
