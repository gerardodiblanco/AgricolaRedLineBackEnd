	package com.softdelsur.agricola.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Insumo;
import com.softdelsur.agricola.model.InsumoModel;

@Component("insumoConverter")
public class InsumoConverter {
	
	@Autowired
	@Qualifier("unidadMedidaConverter")
	UnidadMedidaConverter unidadMedidaConverter;
	
	public Insumo convertInsumoModelToInsumo(InsumoModel insumoModel){
		Insumo insumo = new Insumo();
		insumo.setIdInsumo(insumoModel.getIdInsumo());
		insumo.setCodigo(insumoModel.getCodigo());
		insumo.setDescripcion(insumoModel.getDescripcion());
		insumo.setUnidadMedida(unidadMedidaConverter.convertUnidadMedidaModelToUnidadMedida(insumoModel.getUnidadMedida()));
		
		return insumo;
		
	}
	public InsumoModel convertInsumoToInsumoModel(Insumo insumo){
		InsumoModel insumoModel = new InsumoModel();
		insumoModel.setIdInsumo(insumo.getIdInsumo());
		insumoModel.setCodigo(insumo.getCodigo());
		insumoModel.setDescripcion(insumo.getDescripcion());
		insumoModel.setUnidadMedida(unidadMedidaConverter.convertUnidadMedidaToUnidadMedidaModel(insumo.getUnidadMedida()));
		
		return insumoModel;
		
	}

}
