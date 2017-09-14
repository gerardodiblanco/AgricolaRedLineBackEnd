package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Coordenada;

import com.softdelsur.agricola.model.CoordenadaModel;
import com.softdelsur.agricola.service.CoordenadaService;

@Component("coordenadaConverter")
public class CoordenadaConverter {
	
	@Autowired
	@Qualifier("coordenadaServiceImpl")
	CoordenadaService coordenadaService;
	
	public Coordenada convertCoordenadaModelToCoordenada(CoordenadaModel coordenadaModel) {
		System.out.println("convirtiendo coordenadas");
		Coordenada coordenada = new Coordenada();
		if(coordenadaModel.getId() == null) {
			coordenada = coordenadaService.addCorrdenada(coordenada);
		}else {
		coordenada.setId(coordenadaModel.getId());
		}
		coordenada.setLatitud(coordenadaModel.getLatitud());
		coordenada.setLongitud(coordenadaModel.getLongitud());
		coordenada.setNroOrden(coordenadaModel.getNroOrden());
		
		return coordenada;
	}
	
	public CoordenadaModel convertCoordenadaToCoordenadaModel(Coordenada coordenada) {
		CoordenadaModel coordenadaModel = new CoordenadaModel();
		coordenadaModel.setId(coordenada.getId());
		coordenadaModel.setLatitud(coordenada.getLatitud());
		coordenadaModel.setLongitud(coordenada.getLongitud());
		coordenadaModel.setNroOrden(coordenada.getNroOrden());
		
		return coordenadaModel;
	}
	
	public List<Coordenada> convertListModelToListEntity(List<CoordenadaModel> coordenadaModelList){
		List<Coordenada> coordenadaList = new ArrayList<Coordenada>();
		
		for (CoordenadaModel coordenadaModel : coordenadaModelList) {
			coordenadaList.add(convertCoordenadaModelToCoordenada(coordenadaModel));
		}
		return coordenadaList;
	}
	
	public List<CoordenadaModel> convertListEntityToListModel(List<Coordenada> coordenadaList){
		List<CoordenadaModel> coordenadaModelList = new ArrayList<CoordenadaModel>();
		
		for (Coordenada coordenada : coordenadaList) {
			coordenadaModelList.add(convertCoordenadaToCoordenadaModel(coordenada));
		}
		return coordenadaModelList;
	}

}
