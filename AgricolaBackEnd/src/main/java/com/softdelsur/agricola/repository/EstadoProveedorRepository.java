package com.softdelsur.agricola.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.EstadoProveedor;
@Repository("estadoProveedorRepository")
public interface EstadoProveedorRepository extends JpaRepository<EstadoProveedor, Serializable> {
	
	EstadoProveedor findByNombreEstadoProveedor(String nombre);

}
