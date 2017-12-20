package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.Trato;

@Repository("tratoRepository")
public interface TratoRepository extends JpaRepository<Trato, Serializable> {

	Trato findTratoById(String id);

	List<Trato> findTratosByFechaBaja(Date fechaBaja);

}
