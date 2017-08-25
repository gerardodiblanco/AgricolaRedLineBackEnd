package com.softdelsur.enologia.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.enologia.entity.Toneleria;
import com.softdelsur.enologia.model.ToneleriaModel;

@Component("toneleriaConverter")
public class ToneleriaConverter {
	
	public Toneleria convertToneleriaModelToToneleria(ToneleriaModel tModel){
		Toneleria toneleria = new Toneleria();
		toneleria.setIdToneleria(tModel.getIdToneleria());
		toneleria.setCodigo(tModel.getCodigo());
		toneleria.setDescripcion(tModel.getDescripcion());
		
		return toneleria;		
	}
	public ToneleriaModel convertToneleriaToToneleriaModel(Toneleria toneleria){
		ToneleriaModel tModel = new ToneleriaModel();
		tModel.setIdToneleria(toneleria.getIdToneleria());
		tModel.setCodigo(toneleria.getCodigo());
		tModel.setDescripcion(toneleria.getDescripcion());
		return tModel;
	}

}
