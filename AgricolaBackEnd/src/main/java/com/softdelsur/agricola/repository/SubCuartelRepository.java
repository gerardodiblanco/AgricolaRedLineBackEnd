package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.entity.EstadoSubCuartel;
import com.softdelsur.agricola.entity.SubCuartel;

@Repository("subCuartelRepository")
public interface SubCuartelRepository extends JpaRepository<SubCuartel, Serializable> {

	SubCuartel findByIdSubCuartel(String id);

	List<SubCuartel> findByCuartelAndEstado(Cuartel cuartel, EstadoSubCuartel estadoSubCuartel);

	List<SubCuartel> findByEstado(EstadoSubCuartel estadoSubCuartel);
}
