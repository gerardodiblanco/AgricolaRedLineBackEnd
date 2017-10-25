package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.Variedad;

@Repository("variedadRepository")
public interface VariedadRepository extends JpaRepository<Variedad, Serializable>{
	
	Variedad findById(String id);
	List<Variedad> findByEstado(boolean estado);
	

}
