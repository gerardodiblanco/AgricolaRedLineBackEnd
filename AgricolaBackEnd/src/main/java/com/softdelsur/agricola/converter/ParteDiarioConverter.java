package com.softdelsur.agricola.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.ParteDiario;
import com.softdelsur.agricola.model.ParteDiarioModel;

@Component("parteDiarioConverter")
public class ParteDiarioConverter {
	@Autowired
	@Qualifier("estadoParteDiarioConverter")
	EstadoParteDiarioConverter estadoParteDiarioConverter;
	
	@Autowired
	@Qualifier("periodoConverter")
	PeriodoConverter periodoConverter;

	public ParteDiario convertParteDiarioModelToParteDiario(ParteDiarioModel parteDiarioModel){
		ParteDiario parteDiario = new ParteDiario();
		parteDiario.setIdParteDiario(parteDiarioModel.getIdParteDiario());
		parteDiario.setCodigo(parteDiarioModel.getCodigo());
		parteDiario.setFecha(parteDiarioModel.getFecha());
		parteDiario.setDetallesParteDiario();
		parteDiario.setEstadoParteDiario(estadoParteDiarioConverter.convertEstadoParteDiarioModelToEstadoParteDiario(parteDiarioModel.getEstadoParteDiario()));
		parteDiario.setPeriodo(periodoConverter.convertPeriodoModelToPeriodo(parteDiarioModel.getPeriodo()));
		
		return parteDiario;
	}
	public ParteDiarioModel convertParteDiarioToParteDiarioModel(ParteDiario parteDiario){
		ParteDiarioModel parteDiarioModel = new ParteDiarioModel();
		parteDiarioModel.setIdParteDiario(parteDiario.getIdParteDiario());
		parteDiarioModel.setCodigo(parteDiario.getCodigo());
		parteDiarioModel.setFecha(parteDiario.getFecha());
		parteDiarioModel.setDetallesParteDiario();
		parteDiarioModel.setEstadoParteDiario(estadoParteDiarioConverter.convertEstadoParteDiarioToEstadoParteDiarioModel(parteDiario.getEstadoParteDiario()));
		parteDiarioModel.setPeriodo(periodoConverter.convertPeriodoToPeriodoModel(parteDiario.getPeriodo()));
		
		return parteDiarioModel;
	}
}
