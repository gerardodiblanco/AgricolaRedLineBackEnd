package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.UnidadTrabajo;
import com.softdelsur.agricola.entity.UnidadTrabajoDeposito;

@Repository("unidadTrabajoDepositoRepository")
public interface UnidadTrabajoDepositoRepository extends JpaRepository<UnidadTrabajoDeposito, Serializable>{

	List<UnidadTrabajoDeposito> findUTDByUnidadTrabajoAndFechaBaja(UnidadTrabajo unidadTrabajo, Date fechaBaja);
}
