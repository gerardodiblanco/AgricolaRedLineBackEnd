package com.softdelsur.agricola.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Maquina;
import com.softdelsur.agricola.model.MaquinaModel;

@Component("maquinaConverter")
public class MaquinaConverter {
	
	public Maquina convertMaquinaModelToMaquina(MaquinaModel maquinaModel){
		Maquina maquina = new Maquina();
		maquina.setIdMaquina(maquinaModel.getIdMaquina());
		maquina.setCodigo(maquinaModel.getCodigo());
		maquina.setDescripcion(maquinaModel.getDescripcion());
		
		return maquina;
	}
	public MaquinaModel convertMaquinaToMaquinaModel(Maquina maquina){
		MaquinaModel maquinaModel = new MaquinaModel();
		maquinaModel.setIdMaquina(maquina.getIdMaquina());
		maquinaModel.setCodigo(maquina.getCodigo());
		maquinaModel.setDescripcion(maquina.getDescripcion());
		
		return maquinaModel;
	}

}
