package com.softdelsur.agricola.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.AtributoSubCuartel;

@Repository("atributoSubCuartelRepository")
public interface AtributoSubCuartelRepository  extends JpaRepository<AtributoSubCuartel, Serializable>{

}
