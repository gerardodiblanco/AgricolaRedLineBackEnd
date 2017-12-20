package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.AtributoSubCuartel;
import com.softdelsur.agricola.entity.SubCuartel;

@Repository("atributoSubCuartelRepository")
public interface AtributoSubCuartelRepository extends JpaRepository<AtributoSubCuartel, Serializable> {

	AtributoSubCuartel findAtributoSubCuartelById(String id);

	List<AtributoSubCuartel> findAtributosSubCuartelesBySubCuartelAndFechaFinVigencia(SubCuartel subCuartel,
			Timestamp fecha);
}
