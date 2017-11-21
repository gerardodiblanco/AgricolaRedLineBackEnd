package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.Insumo;

@Repository("insumoRepository")
public interface InsumoRepository extends JpaRepository<Insumo, Serializable> {
	
	List<Insumo> findInsumosByEstado(boolean estado);
	Insumo findInsumoByIdInsumo(String id);

}
