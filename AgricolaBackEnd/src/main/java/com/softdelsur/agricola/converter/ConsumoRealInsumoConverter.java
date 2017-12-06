package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.ConsumoRealInsumo;
import com.softdelsur.agricola.model.ConsumoRealInsumoModel;

@Component("consumoRealInsumoConverter")
public class ConsumoRealInsumoConverter {

	@Autowired
	@Qualifier("insumoConverter")
	InsumoConverter insumoConverter;

	public ConsumoRealInsumo convertModelToEntidad(ConsumoRealInsumoModel consumoRealInsumoModel) {
		ConsumoRealInsumo consumoRealInsumo = new ConsumoRealInsumo();
		consumoRealInsumo.setId(consumoRealInsumoModel.getId());
		consumoRealInsumo.setCantidad(consumoRealInsumoModel.getCantidad());
		consumoRealInsumo.setInsumo(insumoConverter.convertInsumoModelToInsumo(consumoRealInsumoModel.getInsumo()));

		return consumoRealInsumo;
	}

	public ConsumoRealInsumoModel convertEntidadToModel(ConsumoRealInsumo consumoRealInsumo) {
		ConsumoRealInsumoModel consumoRealInsumoModel = new ConsumoRealInsumoModel();
		consumoRealInsumoModel.setId(consumoRealInsumo.getId());
		consumoRealInsumoModel.setCantidad(consumoRealInsumo.getCantidad());
		consumoRealInsumoModel.setInsumo(insumoConverter.convertInsumoToInsumoModel(consumoRealInsumo.getInsumo()));

		return consumoRealInsumoModel;
	}

	public List<ConsumoRealInsumo> convertListModelToListEntidad(
			List<ConsumoRealInsumoModel> consumoRealInsumoModelList) {
		List<ConsumoRealInsumo> consumoRealInsumoList = new ArrayList<ConsumoRealInsumo>();
		for (ConsumoRealInsumoModel consumoRealInsumoModel : consumoRealInsumoModelList) {
			consumoRealInsumoList.add(convertModelToEntidad(consumoRealInsumoModel));
		}
		return consumoRealInsumoList;
	}

	public List<ConsumoRealInsumoModel> convertListListEntidadToModel(List<ConsumoRealInsumo> consumoRealInsumoList) {
		List<ConsumoRealInsumoModel> consumoRealInsumoModelList = new ArrayList<ConsumoRealInsumoModel>();
		for (ConsumoRealInsumo consumoRealInsumo : consumoRealInsumoList) {
			consumoRealInsumoModelList.add(convertEntidadToModel(consumoRealInsumo));
		}
		return consumoRealInsumoModelList;
	}
}
