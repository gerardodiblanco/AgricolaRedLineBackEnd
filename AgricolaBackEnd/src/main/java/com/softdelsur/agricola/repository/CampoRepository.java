package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.entity.EstadoCampo;

@Repository("campoRepository")
public interface CampoRepository extends JpaRepository<Campo, Serializable> {

	Campo findCampoByIdCampo(String idCampo);

	List<Campo> findByEstadoCampo(EstadoCampo estadoCampo);

}
