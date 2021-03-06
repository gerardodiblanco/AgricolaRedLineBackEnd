package com.softdelsur.agricola.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.Caracteristica;

@Repository("caracteristicaRepository")
public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Serializable> {

}
