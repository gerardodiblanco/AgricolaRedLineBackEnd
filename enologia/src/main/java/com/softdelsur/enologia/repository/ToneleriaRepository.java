package com.softdelsur.enologia.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.enologia.entity.Toneleria;

@Repository("toneleriaRepository")
public interface ToneleriaRepository extends JpaRepository<Toneleria, Serializable>{

	public Toneleria findByIdToneleria(String id);
}
