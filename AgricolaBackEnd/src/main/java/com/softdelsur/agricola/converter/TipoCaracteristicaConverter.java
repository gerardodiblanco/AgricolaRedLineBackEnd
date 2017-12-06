package com.softdelsur.agricola.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.TipoCaracteristica;
import com.softdelsur.agricola.model.TipoCaracteristicaModel;

@Component("tipoCaracteristicaConverter")
public class TipoCaracteristicaConverter {
	public TipoCaracteristica convertTipoCaracteristicaModelToTipoCaracteristica(
			TipoCaracteristicaModel tipoCaracteristicaModel) {
		TipoCaracteristica tipoCaracteristica = new TipoCaracteristica();
		tipoCaracteristica.setIdTipoCaracteristica(tipoCaracteristicaModel.getIdTipoCaracteristica());
		tipoCaracteristica.setCodigo(tipoCaracteristicaModel.getCodigo());
		tipoCaracteristica.setNombreCaracteristica(tipoCaracteristicaModel.getIdTipoCaracteristica());
		return tipoCaracteristica;
	}

	public TipoCaracteristicaModel convertTipoCaracteristicaToTipoCaracteristicaModel(
			TipoCaracteristica tipoCaracteristica) {
		TipoCaracteristicaModel tipoCaracteristicaModel = new TipoCaracteristicaModel();
		tipoCaracteristicaModel.setIdTipoCaracteristica(tipoCaracteristica.getIdTipoCaracteristica());
		tipoCaracteristicaModel.setCodigo(tipoCaracteristica.getCodigo());
		tipoCaracteristicaModel.setNombreCaracteristica(tipoCaracteristica.getNombreCaracteristica());
		return tipoCaracteristicaModel;
	}

}
