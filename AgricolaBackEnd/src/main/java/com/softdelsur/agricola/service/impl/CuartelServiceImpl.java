package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.configuration.EntidadesBasicas;
import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.entity.EstadoCuartel;
import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.repository.CuartelRepository;
import com.softdelsur.agricola.service.CuartelService;
import com.softdelsur.agricola.service.EstadoCuartelService;
import com.softdelsur.agricola.service.SubCuartelService;

@Service("cuartelServiceImpl")
public class CuartelServiceImpl implements CuartelService {

	@Autowired
	@Qualifier("cuartelRepository")
	CuartelRepository cuartelRepository;

	@Autowired
	@Qualifier("estadoCuartelServiceImpl")
	EstadoCuartelService estadoCuartelService;

	@Autowired
	@Qualifier("subCuartelServiceImpl")
	SubCuartelService subCuartelService;

	@Override
	public List<Cuartel> findCuartelesByCampoAndEstadoCuartel(Campo campo, EstadoCuartel estadoCuartel) {

		return cuartelRepository.findByCampoAndEstadoCuartel(campo, estadoCuartel);
	}

	@Override
	public Cuartel addCuartel(Cuartel cuartel) {

		return cuartelRepository.save(cuartel);
	}

	@Override
	public Cuartel findCuartelById(String id) {

		return cuartelRepository.findByIdCuartel(id);
	}

	@Override
	public String eliminarCuartel(String id) {
		boolean rta = false;
		EstadoCuartel estadoCuartel = estadoCuartelService
				.findEstadoCuartelByNombre(EntidadesBasicas.estadoCuatelInactivo);
		Cuartel cuartel = null;
		cuartel = findCuartelById(id);

		if (cuartel != null) {
			cuartel.setEstadoCuartel(estadoCuartel);
			cuartel = addCuartel(cuartel);

			List<SubCuartel> subCuartelList = subCuartelService.buscarSubCuartelesActivosPorCuartel(cuartel);

			for (SubCuartel subCuartel : subCuartelList) {
				subCuartelService.eliminarSubCuartel(subCuartel);
			}

			rta = true;
		}

		return "true";
	}

}
