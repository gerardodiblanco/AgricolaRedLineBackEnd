package com.softdelsur.agricola.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.EstadoCuartel;

@Repository("estadoCuartelRepository")
public interface EstadoCuartelRepository  extends JpaRepository<EstadoCuartel, Serializable>{

	EstadoCuartel findEstadoCuartelByNombre(String nombre);
}