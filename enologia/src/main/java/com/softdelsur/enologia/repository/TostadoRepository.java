package com.softdelsur.enologia.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.enologia.entity.Tostado;

@Repository("tostadoRepository")
public interface TostadoRepository extends JpaRepository<Tostado, Serializable>{

	public abstract Tostado findTostadoByidTostado(String id);
}
