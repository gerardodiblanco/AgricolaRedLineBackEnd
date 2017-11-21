package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Maquinaria;
import com.softdelsur.agricola.model.MaquinariaModel;
import com.softdelsur.agricola.service.MaquinariaService;

@Component("maquinariaConverter")
public class MaquinariaConverter {

	@Autowired
	@Qualifier("maquinariaServiceImpl")
	MaquinariaService maquinariaService;
	
	public Maquinaria convertMaquinaModelToMaquina(MaquinariaModel maquinariaModel) {
		Maquinaria maquinaria = null;

		if (maquinariaModel.getIdMaquina() == null) {
			maquinaria = new Maquinaria();
			maquinaria.setEstadoMaquinaria(true);
		//	maquinaria = maquinariaService.addMaquinaria(maquinaria);
		} else {
			maquinaria = maquinariaService.findMaquinariaById(maquinariaModel.getIdMaquina());

			if (maquinaria == null) {
				maquinaria = new Maquinaria();
				maquinaria.setEstadoMaquinaria(true);
			//	maquinaria = maquinariaService.addMaquinaria(maquinaria);
			}
		}
		maquinaria.setIdMaquina(maquinariaModel.getIdMaquina());
		maquinaria.setCodigo(maquinariaModel.getCodigo());
		maquinaria.setDescripcion(maquinariaModel.getDescripcion());

		System.out.println(" maquinaria "+maquinaria.getId());
		System.out.println("descripcion "+maquinaria.getDescripcion());
		return maquinaria;
	}
	public MaquinariaModel convertMaquinaToMaquinaModel(Maquinaria maquinaria){
		MaquinariaModel maquinariaModel = new MaquinariaModel();
		maquinariaModel.setIdMaquina(maquinaria.getIdMaquina());
		maquinariaModel.setCodigo(maquinaria.getCodigo());
		maquinariaModel.setDescripcion(maquinaria.getDescripcion());
		
		return maquinariaModel;
	}
	
	public List<MaquinariaModel> convertListMaquinariaToListMaquinariaModel(List<Maquinaria> maquinariaList){
		List<MaquinariaModel> maquinariaModelList = new ArrayList<>();
		
		for(Maquinaria maquinaria:maquinariaList) {
			maquinariaModelList.add(convertMaquinaToMaquinaModel(maquinaria));
		}
		return maquinariaModelList;
	}

}
