package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.converter.CampoConverter;
import com.softdelsur.agricola.converter.CampoDTOConverter;
import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.entity.EstadoCampo;
import com.softdelsur.agricola.model.CampoDTO;
import com.softdelsur.agricola.model.CampoModel;

import com.softdelsur.agricola.repository.CampoRepository;

import com.softdelsur.agricola.service.CampoService;
import com.softdelsur.agricola.service.EstadoCampoService;

@Service("campoServiceImpl")
public class CampoServiceImpl implements CampoService {

	@Autowired
	@Qualifier("campoConverter")
	CampoConverter campoConverter;

	@Autowired
	@Qualifier("campoRepository")
	CampoRepository campoRepository;

	@Autowired
	@Qualifier("campoDTOConverter")
	CampoDTOConverter campoDTOConverter;

	@Autowired
	@Qualifier("estadoCampoServiceImpl")
	EstadoCampoService estadoCampoService;

	@Override
	public List<CampoDTO> findCamposDTOPorEstado(String nombreEstado) {

		System.out.println("buscando por estado");

		EstadoCampo estadoCampo = estadoCampoService.buscarEstadoCampoPorNombre(nombreEstado);

		System.out.println("Nombre estado " + estadoCampo.getNombre());

		return campoDTOConverter.convertListCampoToListCampoDTO(campoRepository.findByEstadoCampo(estadoCampo));
	}

	// campoModel 2
	@Override
	public List<CampoModel> findCamposModel() {
		List<Campo> campoList = campoRepository.findAll();

		return campoConverter.convertListEntityToListModel((campoList));
	}

	@Override
	public CampoModel findCampoByIdCampo(String id) {

		return campoConverter.convertCampoToCampoModel(campoRepository.findCampoByIdCampo(id));
	}

	@Override
	public Campo findByIdCampo(String id) {

		return campoRepository.findCampoByIdCampo(id);
	}

	@Override
	public Campo addCampo(Campo campo) {

		return campoRepository.save(campo);
	}

	@Override
	public String eliminarCampo(String id) {

		EstadoCampo estadoCampo = estadoCampoService.buscarEstadoCampoPorNombre("Eliminado");
		Campo campo = campoRepository.findCampoByIdCampo(id);
		campo.setEstadoCampo(estadoCampo);
		campoRepository.save(campo);
		return campo.getNombre() + "eliminado";

	}

}
