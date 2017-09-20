package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.EstadoProveedor;
import com.softdelsur.agricola.entity.Proveedor;

public interface ProveedorService {
	
	Proveedor addProveedor(Proveedor proveedor);
	List<Proveedor> buscarProveedoresPorEstado(EstadoProveedor estadoProveedor);
	Proveedor getProveedorByRazonSocial(String razonSocial);

}
