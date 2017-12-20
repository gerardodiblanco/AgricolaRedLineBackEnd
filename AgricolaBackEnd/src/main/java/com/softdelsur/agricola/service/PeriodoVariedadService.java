package com.softdelsur.agricola.service;

import com.softdelsur.agricola.entity.PeriodoVariedad;
import com.softdelsur.agricola.entity.SubCuartel;

public interface PeriodoVariedadService {

	PeriodoVariedad addPeriodoVariedad(PeriodoVariedad periodoVariedad);

	PeriodoVariedad findPeriodoBariedadVigenteBySubCuartel(SubCuartel subCuartel);

}
