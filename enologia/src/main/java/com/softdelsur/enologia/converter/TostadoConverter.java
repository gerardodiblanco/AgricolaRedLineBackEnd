package com.softdelsur.enologia.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.enologia.entity.Tostado;
import com.softdelsur.enologia.model.TostadoModel;

@Component("tostadoConverter")
public class TostadoConverter {

	public Tostado convertTostadoModelToTostado(TostadoModel tModel){
		Tostado tostado = new Tostado();
		tostado.setIdTostado(tModel.getIdTostado());
		tostado.setCodigo(tModel.getCodigo());
		tostado.setDescripcion(tModel.getDescripcion());
		
		return tostado;
	}
	public TostadoModel convertTostadoToTostadoModel(Tostado tostado){
		TostadoModel tModel = new TostadoModel();
		tModel.setIdTostado(tostado.getIdTostado());
		tModel.setCodigo(tostado.getCodigo());
		tModel.setDescripcion(tostado.getDescripcion());
		
		return tModel;
	}
}
