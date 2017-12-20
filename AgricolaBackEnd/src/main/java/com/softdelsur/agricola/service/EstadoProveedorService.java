package com.softdelsur.agricola.service;

import com.softdelsur.agricola.entity.EstadoProveedor;

public interface EstadoProveedorService {

	EstadoProveedor addEstadoProveedor(EstadoProveedor estadoProveedor);

	EstadoProveedor findEstadoByNombre(String nombre);

}
