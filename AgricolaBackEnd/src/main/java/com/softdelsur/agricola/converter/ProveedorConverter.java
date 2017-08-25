package com.softdelsur.agricola.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Proveedor;
import com.softdelsur.agricola.model.ProveedorModel;

@Component("proveedorConverter")
public class ProveedorConverter {
	
	@Autowired
	@Qualifier("estadoProveedorConverter")
	EstadoProveedorConverter estadoProveedorConverter;
	
	public Proveedor convertProveedorModelToProveedor(ProveedorModel proveedorModel){
		Proveedor proveedor = new Proveedor();
		proveedor.setIdProveedor(proveedorModel.getIdProveedor());
		proveedor.setCodigo(proveedorModel.getCodigo());
		proveedor.setDescripcion(proveedorModel.getDescripcion());
		proveedor.setRazonSocial(proveedorModel.getRazonSocial());
		proveedor.setEstado(estadoProveedorConverter.convertEstadoProveedorModelToEstadoProveedor(proveedorModel.getEstado()));
		
		return proveedor;
	}
	public ProveedorModel convertProveedorToProveedorModel(Proveedor proveedor){
		ProveedorModel proveedorModel = new ProveedorModel();
		proveedorModel.setIdProveedor(proveedor.getIdProveedor());
		proveedorModel.setCodigo(proveedor.getCodigo());
		proveedorModel.setDescripcion(proveedor.getDescripcion());
		proveedorModel.setRazonSocial(proveedor.getRazonSocial());
		proveedorModel.setEstado(estadoProveedorConverter.convertEstadoProveedorToEstadoProveedorModel(proveedor.getEstado()));
		return proveedorModel;
	}

}
