package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.PeriodoVariedad;
import com.softdelsur.agricola.entity.SubCuartel;

@Repository("periodoVariedadRepository")
public interface PeriodoVariedadRepository extends JpaRepository<PeriodoVariedad, Serializable> {

	PeriodoVariedad findBySubCuartelAndFechaFinPeriodo(SubCuartel subCuartel, Date fechaFinVigencia);

}
