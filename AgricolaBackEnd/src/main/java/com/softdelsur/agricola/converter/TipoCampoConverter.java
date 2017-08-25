package com.softdelsur.agricola.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.TipoCampo;
import com.softdelsur.agricola.model.TipoCampoModel;

@Component("tipoCampoModel")
public class TipoCampoConverter {
	public TipoCampo convertTipoCampoModelToTipoCampo(TipoCampoModel tipoCampoModel){
		TipoCampo tipoCampo = new TipoCampo();
		tipoCampo.setIdTipo(tipoCampoModel.getIdTipo());
		tipoCampo.setCodigo(tipoCampoModel.getCodigo());
		tipoCampo.setDescripcion(tipoCampoModel.getDescripcion());
		return tipoCampo;
	}
	public TipoCampoModel convertTipoCampoToTipoCampoModel(TipoCampo tipoCampo){
		TipoCampoModel tipoCampoModel = new TipoCampoModel();
		tipoCampoModel.setIdTipo(tipoCampo.getIdTipo());
		tipoCampoModel.setCodigo(tipoCampo.getCodigo());
		tipoCampoModel.setDescripcion(tipoCampo.getDescripcion());
		return tipoCampoModel;
	}

}
