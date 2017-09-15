package com.softdelsur.agricola.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.EstadoProveedor;
import com.softdelsur.agricola.repository.EstadoProveedorRepository;
import com.softdelsur.agricola.service.EstadoProveedorService;

@Service("estadoProveedorServiceImpl")
public class EstadoProveedorServiceImpl implements EstadoProveedorService {
	
	@Autowired
	@Qualifier("estadoProveedorRepository")
	EstadoProveedorRepository estadoProveedorRepository;

	@Override
	public EstadoProveedor addEstadoProveedor(EstadoProveedor estadoProveedor) {
		
		return estadoProveedorRepository.save(estadoProveedor);
	}


	
	




}
