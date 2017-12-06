package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.PeriodoVariedad;
import com.softdelsur.agricola.model.PeriodoVariedadModel;

@Component("periodoVariedadConverter")
public class PeriodoVariedadConverter {

	public List<PeriodoVariedad> convertListPeriodoVariedadModelToListPeriodoVariedad(
			List<PeriodoVariedadModel> periodoVariedadModelList) {
		List<PeriodoVariedad> periodoVariedadLis = new ArrayList<>();
		return periodoVariedadLis;
	}

	public List<PeriodoVariedadModel> convertListPeriodoVariedadToListPeriodoVariedadModel(
			List<PeriodoVariedad> periodoVariedadList) {
		List<PeriodoVariedadModel> periodoVariedadModelList = new ArrayList<>();
		return periodoVariedadModelList;

	}

}
