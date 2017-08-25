package com.softdelsur.agricola.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.TipoCaracteristica;

@Repository("tipoCaracteristicaRepository")
public interface TipoCaracteristicaRepository extends JpaRepository<TipoCaracteristica, Serializable>{

}
