package com.softdelsur.agricola.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Periodo;
import com.softdelsur.agricola.model.PeriodoModel;

@Component("periodoConverter")
public class PeriodoConverter {
	@Autowired
	@Qualifier("estadoPeriodoConverter")
	EstadoPeriodoConverter estadoPeriodoConverter;
	
	@Autowired
	@Qualifier("rubroConverter")
	RubroConverter rubroConverter;
	
	public Periodo convertPeriodoModelToPeriodo(PeriodoModel periodoModel){

		
		Periodo periodo = new Periodo();
		periodo.setIdPeriodo(periodoModel.getIdPeriodo());
		periodo.setDescripcion(periodo.getDescripcion());
		periodo.setEstado(estadoPeriodoConverter.convertEstadoPeriodoModelToEstadoPeriodo(periodoModel.getEstado()));
		periodo.setFechaDesde(periodoModel.getFechaDesde());
		periodo.setFechaHasta(periodoModel.getFechaHasta());
		periodo.setPeriodoAnio(periodoModel.getPeriodoAnio());
		periodo.setRubro(rubroConverter.convertRubroModelToRubro(periodoModel.getRubro()));
		return periodo;
	}
	public PeriodoModel convertPeriodoToPeriodoModel(Periodo periodo){
		PeriodoModel periodoModel = new PeriodoModel();
		periodoModel.setIdPeriodo(periodo.getIdPeriodo());
		periodoModel.setDescripcion(periodo.getDescripcion());
		periodoModel.setEstado(estadoPeriodoConverter.convertEstadoPeriodoToEstadoPeriodo(periodo.getEstado()));
		periodoModel.setFechaDesde(periodo.getFechaDesde());
		periodoModel.setFechaHasta(periodo.getFechaHasta());
		periodoModel.setPeriodoAnio(periodo.getPeriodoAnio());
		periodoModel.setRubro(rubroConverter.convetRubroToRubroModel(periodo.getRubro()));
		
		return periodoModel;
	}
}
