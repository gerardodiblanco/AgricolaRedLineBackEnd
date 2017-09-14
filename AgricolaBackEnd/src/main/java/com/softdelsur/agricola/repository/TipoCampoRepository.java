package com.softdelsur.agricola.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.TipoCampo;

@Repository("tipoCampoRepository")
public interface TipoCampoRepository extends JpaRepository<TipoCampo, Serializable> {
	
	TipoCampo findByNombre(String nombre);

}
