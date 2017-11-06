package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.AtributoSubCuartel;
import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.repository.AtributoSubCuartelRepository;
import com.softdelsur.agricola.service.AtributoSubCuartelService;

@Service("atributoSubCuartelServiceImpl")
public class AtributoSubCuartelServiceImpl implements AtributoSubCuartelService {
	
	@Autowired
	@Qualifier("atributoSubCuartelRepository")
	AtributoSubCuartelRepository atributoSubCuartelRepository;

	@Override
	public AtributoSubCuartel addAtributoSubCuartel(AtributoSubCuartel atributoSubCuartel) {
		// TODO Auto-generated method stub
		return atributoSubCuartelRepository.save(atributoSubCuartel);
	}

	@Override
	public AtributoSubCuartel findAtributoSubCuartelById(String id) {
		
		return atributoSubCuartelRepository.findAtributoSubCuartelById(id);
	}

	@Override
	public List<AtributoSubCuartel> findAtributosSubCuartelesBySubCuartel(SubCuartel subCuartel) {
		
		return atributoSubCuartelRepository.findAtributosSubCuartelesBySubCuartelAndFechaFinVigencia(subCuartel,null);
	}

}
