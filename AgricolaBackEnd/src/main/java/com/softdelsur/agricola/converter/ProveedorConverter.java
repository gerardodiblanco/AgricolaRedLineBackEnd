package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Proveedor;
import com.softdelsur.agricola.model.ProveedorModelABMCampo;

@Component("proveedorConverter")
public class ProveedorConverter {

	@Autowired
	@Qualifier("estadoProveedorConverter")
	EstadoProveedorConverter estadoProveedorConverter;

	/*
	 * public Proveedor convertProveedorModelToProveedor(ProveedorModelABMCampo
	 * proveedorModel){ Proveedor proveedor = new Proveedor();
	 * proveedor.setIdProveedor(proveedorModel.getIdProveedor());
	 * proveedor.setCodigo(proveedorModel.getCodigo());
	 * proveedor.setDescripcion(proveedorModel.getDescripcion());
	 * proveedor.setRazonSocial(proveedorModel.getRazonSocial());
	 * proveedor.setEstado(estadoProveedorConverter.
	 * convertEstadoProveedorModelToEstadoProveedor(proveedorModel.getEstado()));
	 * 
	 * return proveedor; }
	 */
	public ProveedorModelABMCampo convertProveedorToProveedorModelABMCampo(Proveedor proveedor) {
		ProveedorModelABMCampo proveedorModel = new ProveedorModelABMCampo();

		proveedorModel.setDescripcion(proveedor.getDescripcion());
		proveedorModel.setRazonSocial(proveedor.getRazonSocial());

		return proveedorModel;
	}

	public List<ProveedorModelABMCampo> convertListProveedorToListProveedorModelABMCampo(
			List<Proveedor> proveedorList) {
		List<ProveedorModelABMCampo> proveedorModelABMCampoList = new ArrayList<ProveedorModelABMCampo>();
		for (Proveedor p : proveedorList) {
			proveedorModelABMCampoList.add(convertProveedorToProveedorModelABMCampo(p));
		}
		return proveedorModelABMCampoList;
	}

}
