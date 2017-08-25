package com.softdelsur.enologia.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.enologia.entity.Barrica;

@Repository("barricaRepository")
public interface BarricaRepository extends JpaRepository<Barrica, Serializable>{
	
	public abstract Barrica findByCodigoBarrica(int codigo);
	public abstract Barrica findBarricaByid(String id);
	
}
