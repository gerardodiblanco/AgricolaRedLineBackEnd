package com.softdelsur.enologia.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.enologia.entity.Barrica;
import com.softdelsur.enologia.model.BarricaModel;

@Component("barricaConverter")
public class BarricaConverter {
	
	@Autowired
	@Qualifier("estadoBarricaConverter")
	EstadoBarricaConverter converterEstado;
	
	@Autowired
	@Qualifier("bosqueConverter")
	BosqueConverter converterBosque;
	
	@Autowired
	@Qualifier("origenConverter")
	OrigenConverter converterOrigen;
	
	@Autowired
	@Qualifier("toneleriaConverter")
	ToneleriaConverter converterToneleria;
	
	@Autowired
	@Qualifier("tostadoConverter")
	TostadoConverter converterTostado;
	
	public Barrica convertBarricaModelToBarrica(BarricaModel bModel){
		Barrica barrica = new Barrica();
		
		barrica.setId(bModel.getId());
		barrica.setCodigoBarrica(bModel.getCodigoBarrica());
		barrica.setDescripcion(bModel.getDescripcion());
		barrica.setFechaAdquisicion(bModel.getFechaAdquisicion());
		barrica.setFechaActivacion(bModel.getFechaActivacion());
		barrica.setFechaVigencia(bModel.getFechaVigencia());
		barrica.setFechaRenovacion(bModel.getFechaRenovacion());
		barrica.setFechaRenovacion(bModel.getFechaRenovacion());
		barrica.setCapacidad(bModel.getCapacidad());
		barrica.setOrigen(converterOrigen.convertOrigenModelToOrigen(bModel.getOrigen()));
		barrica.setToneleria(converterToneleria.convertToneleriaModelToToneleria(bModel.getToneleria()));		
		barrica.setBosque(converterBosque.convertBosqueModelToBosque(bModel.getBosque()));
		barrica.setTostado(converterTostado.convertTostadoModelToTostado(bModel.getTostado()));	
		barrica.setEstado(converterEstado.convertEstadoBarricaModelToEstadoBarrica(bModel.getEstadoModel()));
		
		
		return barrica;
		
	}
	
	
	public BarricaModel convertBarricaToBarricaModel(Barrica barrica){
		BarricaModel bModel = new BarricaModel();
		bModel.setId(barrica.getId());
		bModel.setCodigoBarrica(barrica.getCodigoBarrica());
		bModel.setDescripcion(barrica.getDescripcion());
		bModel.setFechaAdquisicion(barrica.getFechaAdquisicion());
		bModel.setFechaActivacion(barrica.getFechaActivacion());
		bModel.setFechaVigencia(barrica.getFechaVigencia());
		bModel.setFechaRenovacion(barrica.getFechaRenovacion());
		bModel.setFechaRenovacion(barrica.getFechaRenovacion());
		bModel.setCapacidad(barrica.getCapacidad());
		bModel.setOrigen(converterOrigen.convertOrigenToOrigenModel(barrica.getOrigen()));
		bModel.setToneleria(converterToneleria.convertToneleriaToToneleriaModel(barrica.getToneleria()));		
		bModel.setBosque(converterBosque.convertBosqueToBosqueModel(barrica.getBosque()));
		bModel.setTostado(converterTostado.convertTostadoToTostadoModel(barrica.getTostado()));	
		bModel.setEstadoModel(converterEstado.convertEstadoBarricaToEstadoBarricaModel(barrica.getEstado()));
		

		return bModel;
	}

}
