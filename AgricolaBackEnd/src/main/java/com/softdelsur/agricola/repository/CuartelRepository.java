package com.softdelsur.agricola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.entity.EstadoCuartel;

import java.io.Serializable;
import java.util.List;

@Repository("cuartelRepository")
public interface CuartelRepository extends JpaRepository<Cuartel, Serializable> {

	List<Cuartel> findByCampoAndEstadoCuartel(Campo campo,EstadoCuartel estadoCuartel);
	
	Cuartel findByIdCuartel(String idCuartel);
}
