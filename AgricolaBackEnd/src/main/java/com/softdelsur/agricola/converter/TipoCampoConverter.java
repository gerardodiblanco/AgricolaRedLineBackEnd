package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.TipoCampo;
import com.softdelsur.agricola.model.TipoCampoModel;

@Component("tipoCampoConverter")
public class TipoCampoConverter {
	public TipoCampo convertTipoCampoModelToTipoCampo(TipoCampoModel tipoCampoModel) {
		TipoCampo tipoCampo = new TipoCampo();
		tipoCampo.setIdTipo(tipoCampoModel.getIdTipo());
		tipoCampo.setCodigo(tipoCampoModel.getCodigo());
		tipoCampo.setNombre(tipoCampoModel.getNombre());
		return tipoCampo;
	}

	public TipoCampoModel convertTipoCampoToTipoCampoModel(TipoCampo tipoCampo) {
		TipoCampoModel tipoCampoModel = new TipoCampoModel();
		tipoCampoModel.setIdTipo(tipoCampo.getIdTipo());
		tipoCampoModel.setCodigo(tipoCampo.getCodigo());
		tipoCampoModel.setNombre(tipoCampo.getNombre());
		return tipoCampoModel;
	}

	public List<TipoCampoModel> convertListTipoCampoToTipoCampoModel(List<TipoCampo> tipoCampoList) {
		List<TipoCampoModel> tipoCampoModelList = new ArrayList<TipoCampoModel>();

		for (TipoCampo tipoCampo : tipoCampoList) {
			tipoCampoModelList.add(convertTipoCampoToTipoCampoModel(tipoCampo));
		}
		return tipoCampoModelList;
	}
}
