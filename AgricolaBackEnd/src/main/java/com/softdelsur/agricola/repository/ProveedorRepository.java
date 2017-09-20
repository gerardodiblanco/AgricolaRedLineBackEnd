package com.softdelsur.agricola.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softdelsur.agricola.entity.EstadoProveedor;
import com.softdelsur.agricola.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Serializable>{
	
	List<Proveedor> findByEstado(EstadoProveedor estadoProveedor);
	Proveedor findByRazonSocial(String razonSocial);

}
