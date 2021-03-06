package com.softdelsur.agricola.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.EstadoCampo;

@Repository("estadoCampoRepository")
public interface EstadoCampoRepository extends JpaRepository<EstadoCampo, Serializable> {

	EstadoCampo findEstadoCampoByNombre(String nombre);
}
