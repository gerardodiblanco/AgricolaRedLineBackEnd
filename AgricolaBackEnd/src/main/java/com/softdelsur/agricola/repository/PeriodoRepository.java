package com.softdelsur.agricola.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softdelsur.agricola.entity.Periodo;

public interface PeriodoRepository extends JpaRepository<Periodo,Serializable> {

}
