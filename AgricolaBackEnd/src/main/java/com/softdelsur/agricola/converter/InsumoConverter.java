	package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Insumo;
import com.softdelsur.agricola.entity.UnidadMedida;
import com.softdelsur.agricola.model.InsumoModel;
import com.softdelsur.agricola.service.InsumoService;

@Component("insumoConverter")
public class InsumoConverter {
	
	@Autowired
	@Qualifier("unidadMedidaConverter")
	UnidadMedidaConverter unidadMedidaConverter;
	
	
	
	@Autowired
	@Qualifier("insumoServiceImpl")
	InsumoService insumoService;
	
	public Insumo convertInsumoModelToInsumo(InsumoModel insumoModel){
		Insumo insumo = null;
		
		if(insumoModel.getId() == null) {
			insumo = new Insumo();
			insumo.setEstado(true);
			
		}else {
			insumo = insumoService.findInsumoById(insumoModel.getId());
			if(insumo == null) {
				insumo = new Insumo();
				insumo.setEstado(true);
			}
		}
		insumo.setIdInsumo(insumoModel.getId());
		insumo.setCodigo(insumoModel.getCodigo());
		insumo.setDescripcion(insumoModel.getDescripcion());
		
		// falta la unidad de medida
		/*
		UnidadMedida unidadMedida = null;
		unidadMedida = new UnidadMedida();
		unidadMedida.setNombreUM("kg");
		
		insumo.setUnidadMedida(unidadMedidaConverter.convertUnidadMedidaModelToUnidadMedida(insumoModel.getUnidadMedida()));
		*/
		return insumo;
		
	}
	public InsumoModel convertInsumoToInsumoModel(Insumo insumo){
		InsumoModel insumoModel = new InsumoModel();
		insumoModel.setId(insumo.getIdInsumo());
		insumoModel.setCodigo(insumo.getCodigo());
		insumoModel.setDescripcion(insumo.getDescripcion());
	//	insumoModel.setUnidadMedida(insumo.getUnidadMedida().getNombreUM());
		
		return insumoModel;
		
	}
	
	public List<InsumoModel> convertListInsumoToListInsumoModel(List<Insumo> insumoList){
		List<InsumoModel> insumoModelList = new ArrayList<>();
		
		for(Insumo insumo:insumoList) {
			insumoModelList.add(convertInsumoToInsumoModel(insumo));
		}
		return insumoModelList;
	}
	

}
