package com.softdelsur.agricola.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.EstadoProveedor;
import com.softdelsur.agricola.model.EstadoProveedorModel;

@Component("estadoProveedorConverter")
public class EstadoProveedorConverter {

	public EstadoProveedor convertEstadoProveedorModelToEstadoProveedor(EstadoProveedorModel estadoModel) {
		EstadoProveedor estado = new EstadoProveedor();
		estado.setIdEstadoProveedor(estadoModel.getIdEstadoProveedor());
		estado.setNombreEstadoProveedor(estadoModel.getNombreEstadoProveedor());
		return estado;
	}

	public EstadoProveedorModel convertEstadoProveedorToEstadoProveedorModel(EstadoProveedor estado) {
		EstadoProveedorModel estadoModel = new EstadoProveedorModel();
		estadoModel.setIdEstadoProveedor(estado.getIdEstadoProveedor());
		estadoModel.setNombreEstadoProveedor(estado.getNombreEstadoProveedor());
		return estadoModel;
	}
}
