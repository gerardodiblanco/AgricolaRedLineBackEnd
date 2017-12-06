package com.softdelsur.agricola.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.UnidadMedida;
import com.softdelsur.agricola.model.UnidadMedidaModel;

@Component("unidadMedidaConverter")
public class UnidadMedidaConverter {
	public UnidadMedida convertUnidadMedidaModelToUnidadMedida(UnidadMedidaModel unidadMedidaModel) {
		UnidadMedida unidadMedida = new UnidadMedida();
		unidadMedida.setIdUnidadMedida(unidadMedidaModel.getIdUnidadMedida());
		unidadMedida.setNombreUM(unidadMedidaModel.getNombreUM());

		return unidadMedida;
	}

	public UnidadMedidaModel convertUnidadMedidaToUnidadMedidaModel(UnidadMedida unidadMedida) {
		UnidadMedidaModel unidadMedidaModel = new UnidadMedidaModel();
		unidadMedidaModel.setIdUnidadMedida(unidadMedida.getIdUnidadMedida());
		unidadMedidaModel.setNombreUM(unidadMedida.getNombreUM());

		return unidadMedidaModel;
	}

}
