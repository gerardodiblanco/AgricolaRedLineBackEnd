package com.softdelsur.agricola.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softdelsur.agricola.entity.EstadoPeriodo;

public interface EstadoPeriodoRepository extends JpaRepository<EstadoPeriodo, Serializable> {

}
