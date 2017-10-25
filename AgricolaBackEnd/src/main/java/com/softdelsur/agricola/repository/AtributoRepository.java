package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.Atributo;

@Repository("atributoRepository")
public interface AtributoRepository extends JpaRepository<Atributo, Serializable> {
	
	Atributo findAtributoById(String id);
	List<Atributo> findAtributosByEstado(boolean estado);

}
