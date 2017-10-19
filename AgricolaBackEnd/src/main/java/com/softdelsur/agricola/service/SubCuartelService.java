package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.entity.SubCuartel;

public interface SubCuartelService {

	SubCuartel addSubCuartel(SubCuartel subCuartel);
	SubCuartel buscarPorId(String id);
	
	List<SubCuartel> buscarSubCuartelesActivosPorCuartel(Cuartel cuartel);
	SubCuartel eliminarSubCuartel(SubCuartel subCuartel);
}
