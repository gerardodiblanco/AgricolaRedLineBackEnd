package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.entity.EstadoSubCuartel;
import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.repository.SubCuartelRepository;
import com.softdelsur.agricola.service.EstadoSubCuartelService;
import com.softdelsur.agricola.service.SubCuartelService;

@Service("subCuartelServiceImpl")
public class SubCuartelServiceImpl implements SubCuartelService {

	@Autowired
	@Qualifier("subCuartelRepository")
	SubCuartelRepository subCuartelRepository;

	@Autowired
	@Qualifier("estadoSubCuartelServiceImpl")
	EstadoSubCuartelService estadoSubCuartelService;

	@Override
	public SubCuartel addSubCuartel(SubCuartel subCuartel) {

		return subCuartelRepository.save(subCuartel);
	}

	@Override
	public SubCuartel buscarPorId(String id) {
		return subCuartelRepository.findByIdSubCuartel(id);
	}

	@Override
	public List<SubCuartel> buscarSubCuartelesActivosPorCuartel(Cuartel cuartel) {
		EstadoSubCuartel estadoSubCuartel = estadoSubCuartelService.buscarEstadoActivo();
		System.out.println("buscar estado sub cuartel");
		System.out.println(estadoSubCuartel.getDescripcion());

		return subCuartelRepository.findByCuartelAndEstado(cuartel, estadoSubCuartel);
	}

	@Override
	public SubCuartel eliminarSubCuartel(SubCuartel subCuartel) {
		EstadoSubCuartel estadoSubCuartel = estadoSubCuartelService.buscarEstadoInactivo();
		subCuartel.setEstado(estadoSubCuartel);
		subCuartel = subCuartelRepository.save(subCuartel);
		return subCuartel;
	}

	@Override
	public List<SubCuartel> buscarSubCuartelesActivos() {
		EstadoSubCuartel estadoSubCuartel = estadoSubCuartelService.buscarEstadoActivo();
		
		return subCuartelRepository.findByEstado(estadoSubCuartel);
	}

}
