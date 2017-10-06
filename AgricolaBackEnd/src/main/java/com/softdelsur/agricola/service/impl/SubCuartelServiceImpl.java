package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.repository.SubCuartelRepository;
import com.softdelsur.agricola.service.SubCuartelService;

@Service("subCuartelServiceImpl")
public class SubCuartelServiceImpl implements SubCuartelService {
	
	@Autowired
	@Qualifier("subCuartelRepository")
	SubCuartelRepository subCuartelRepository;

	@Override
	public SubCuartel addSubCuartel(SubCuartel subCuartel) {
		 
		return subCuartelRepository.save(subCuartel);
	}

	@Override
	public SubCuartel buscarPorId(String id) {
		return subCuartelRepository.findByIdSubCuartel(id);
	}

	@Override
	public List<SubCuartel> buscarPorCuartel(Cuartel cuartel) {
		
		return subCuartelRepository.findByCuartel(cuartel);
	}

}
