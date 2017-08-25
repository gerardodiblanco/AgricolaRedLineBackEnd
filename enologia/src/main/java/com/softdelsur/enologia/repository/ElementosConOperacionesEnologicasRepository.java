package com.softdelsur.enologia.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.enologia.entity.ElementosConOperacionesEnologicas;

@Repository("elementosConOperacionesEnologicasRepository")
public interface ElementosConOperacionesEnologicasRepository extends JpaRepository<ElementosConOperacionesEnologicas, Serializable>{

	public abstract ElementosConOperacionesEnologicas findById(String id);

}
