package com.softdelsur.agricola.service;

import java.util.List;

import com.softdelsur.agricola.entity.AtributoSubCuartel;
import com.softdelsur.agricola.entity.SubCuartel;

public interface AtributoSubCuartelService {

	AtributoSubCuartel findAtributoSubCuartelById(String id);

	AtributoSubCuartel addAtributoSubCuartel(AtributoSubCuartel atributoSubCuartel);

	List<AtributoSubCuartel> findAtributosSubCuartelesBySubCuartel(SubCuartel subCuartel);

}
