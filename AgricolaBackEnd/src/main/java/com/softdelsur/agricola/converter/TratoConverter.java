package com.softdelsur.agricola.converter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Trato;
import com.softdelsur.agricola.model.TratoModel;
import com.softdelsur.agricola.service.TratoService;

@Component("tratoConverter")
public class TratoConverter {

	@Autowired
	@Qualifier("tratoServiceImpl")
	TratoService tratoService;

	public TratoModel convertTratoToTratoModel(Trato trato) {
		TratoModel tratoModel = new TratoModel();

		tratoModel.setId(trato.getId());
		tratoModel.setNombre(trato.getNombre());
		tratoModel.setCodigo(trato.getCodigo());
		tratoModel.setFechaAlta(trato.getFechaAlta());
		tratoModel.setImporte(trato.getImporte());
		tratoModel.setUnMinima(trato.getUnMinima());

		return tratoModel;
	}

	public List<TratoModel> convertListTratoToListTratoModel(List<Trato> tratos) {

		List<TratoModel> tratoModelList = new ArrayList<>();

		for (Trato trato : tratos) {
			tratoModelList.add(convertTratoToTratoModel(trato));

		}
		return tratoModelList;
	}

	public Trato convetTratoModelToTrato(TratoModel tratoModel) {
		Trato trato = null;

		if (tratoModel.getId() == null) {
			trato = new Trato();
			trato.setFechaAlta(Date.valueOf(LocalDate.now()));
			trato.setFechaBaja(null);

			trato = tratoService.addTrato(trato);
		} else {

			trato = tratoService.findTratoById(tratoModel.getId());
			if (trato == null) {
				trato = new Trato();
				trato.setFechaAlta(Date.valueOf(LocalDate.now()));
				trato.setFechaBaja(null);

				trato = tratoService.addTrato(trato);
			}

		}

		trato.setCodigo(tratoModel.getCodigo());
		trato.setImporte(tratoModel.getImporte());
		trato.setUnMinima(tratoModel.getUnMinima());
		trato.setNombre(tratoModel.getNombre());

		return trato;

	}

}
