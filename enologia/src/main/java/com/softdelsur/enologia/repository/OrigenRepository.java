package com.softdelsur.enologia.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.enologia.entity.Origen;


@Repository("origenRepository")
public interface OrigenRepository extends JpaRepository<Origen, Serializable>{

	public Origen findByidOrigen(String id);
}
