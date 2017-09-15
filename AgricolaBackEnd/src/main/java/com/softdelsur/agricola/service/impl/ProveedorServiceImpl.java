package com.softdelsur.agricola.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.converter.ProveedorConverter;
import com.softdelsur.agricola.entity.Proveedor;
import com.softdelsur.agricola.model.ProveedorModel;
import com.softdelsur.agricola.repository.ProveedorRepository;
import com.softdelsur.agricola.service.ProveedorService;

@Service("proveedorServiceImpl")
public class ProveedorServiceImpl implements ProveedorService {
	
	@Autowired
	@Qualifier("proveedorConverter")
	ProveedorConverter proveedorConverter;
	
	@Autowired
	@Qualifier("proveedorRepository")
	ProveedorRepository proveedorRepository;

	@Override
	public Proveedor addProveedor(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}

}
