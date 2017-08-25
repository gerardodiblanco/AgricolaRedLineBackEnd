package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Caracteristica;
import com.softdelsur.agricola.model.CaracteristicaModel;
import com.softdelsur.agricola.model.TipoCaracteristicaModel;

@Component("caracteristicaConverter")
public class CaracteristicaConverter {
	@Autowired
	@Qualifier("tipoCaracteristicaConverter")
	TipoCaracteristicaConverter tipoCaracteristicaConverter;
	public Caracteristica convertCaracteristicaModelToCaracteristica(CaracteristicaModel caracteristicaModel){
		Caracteristica caracteristica = new Caracteristica();
		caracteristica.setIdCaracteristica(caracteristicaModel.getIdCaracteristica());
		caracteristica.setCodigo(caracteristicaModel.getCodigo());
		caracteristica.setNumeroCaracteristica(caracteristicaModel.getNumeroCaracteristica());
		caracteristica.setTipoCaracteristica(tipoCaracteristicaConverter.convertTipoCaracteristicaModelToTipoCaracteristica(caracteristicaModel.getTipoCaracteristica()));
		return caracteristica;
	}
	public CaracteristicaModel convertCaracteristicaToCaracteristicaModel(Caracteristica caracteristica){
		CaracteristicaModel caracteristicaModel = new CaracteristicaModel();
		caracteristicaModel.setIdCaracteristica(caracteristica.getIdCaracteristica());
		caracteristicaModel.setCodigo(caracteristica.getCodigo());
		caracteristicaModel.setNumeroCaracteristica(caracteristica.getNumeroCaracteristica());
		caracteristicaModel.setTipoCaracteristica(tipoCaracteristicaConverter.convertTipoCaracteristicaToTipoCaracteristicaModel(caracteristica.getTipoCaracteristica()));
		return caracteristicaModel;
	}
	public List<Caracteristica> convertListCaracteristicaModelToListCaracteristica(List<CaracteristicaModel> caracteristicaModelList){
		List<Caracteristica> caracteristicas = new ArrayList<Caracteristica>();
		for(CaracteristicaModel caracteristicaModel : caracteristicaModelList){
			caracteristicas.add(convertCaracteristicaModelToCaracteristica(caracteristicaModel));
		}
		return caracteristicas;
		
	}
	public List<CaracteristicaModel> convertListCaracteristicaToListCaracteristicaModel(List<Caracteristica> caracteristicaList){
		List<CaracteristicaModel> caracteristicasModel = new ArrayList<CaracteristicaModel>();
		for(Caracteristica caracteristica : caracteristicaList){
			caracteristicasModel.add(convertCaracteristicaToCaracteristicaModel(caracteristica));
		}
		return caracteristicasModel;
		
	}

}
