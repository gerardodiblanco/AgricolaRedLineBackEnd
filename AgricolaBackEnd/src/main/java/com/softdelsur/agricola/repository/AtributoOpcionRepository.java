package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.Atributo;
import com.softdelsur.agricola.entity.AtributoOpcion;

@Repository("atributoOpcionRepository")
public interface AtributoOpcionRepository  extends JpaRepository<AtributoOpcion, Serializable>{
	
	AtributoOpcion findAtributoOpcionById(String id);
	List<AtributoOpcion> findAtributosByEstadoAndAtributo(boolean estado, Atributo atributo);

}
