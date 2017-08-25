package com.softdelsur.enologia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.enologia.converter.GrupoBarricaConverter;
import com.softdelsur.enologia.entity.Barrica;
import com.softdelsur.enologia.entity.GrupoBarrica;
import com.softdelsur.enologia.model.GrupoBarricaModel;
import com.softdelsur.enologia.repository.BarricaRepository;
import com.softdelsur.enologia.repository.GrupoBarricaRepository;
import com.softdelsur.enologia.service.GrupoBarricaService;

@Service("grupoBarricaServiceImpl")
public class GrupoBarricaServiceImpl implements GrupoBarricaService {

	@Autowired
	@Qualifier("grupoBarricaRepository")
	GrupoBarricaRepository grupoBarricaRepository;
	
	@Autowired
	@Qualifier("grupoBarricaConverter")
	GrupoBarricaConverter converterGrupoBarrica;
	
	@Autowired
	@Qualifier("barricaRepository")
	BarricaRepository barricaRepository;
	
	
	@Override
	public List<GrupoBarricaModel> listAllGruposBarrica() {
		 List<GrupoBarrica> grupoBarrica = grupoBarricaRepository.findAll();
		 List<GrupoBarricaModel> gruposModel = new ArrayList<GrupoBarricaModel>();
		 for (GrupoBarrica grupo : grupoBarrica) {
			gruposModel.add(converterGrupoBarrica.convertGrupoBarricaToGrupoBarricaModel(grupo));
		}
		return gruposModel;
	}

	@Override
	public GrupoBarricaModel addGrupo(GrupoBarricaModel grupoModel) {
		GrupoBarrica grupoBarrica = converterGrupoBarrica.convertGrupoBarricaModelToGrupoBarrica(grupoModel);
		
		return converterGrupoBarrica.convertGrupoBarricaToGrupoBarricaModel(grupoBarricaRepository.save(grupoBarrica));
	}

	@Override
	public GrupoBarricaModel addBarrica(String idGrupo, String idBarrica) {
		GrupoBarrica grupo = grupoBarricaRepository.findById(idGrupo);
		Barrica barrica = barricaRepository.findBarricaByid(idBarrica);
		
		grupo.getBarricas().add(barrica);
		
		return converterGrupoBarrica.convertGrupoBarricaToGrupoBarricaModel(grupoBarricaRepository.save(grupo));
	}

	@Override
	public GrupoBarricaModel findGrupoBarricaById(String id) {
		
		return converterGrupoBarrica.convertGrupoBarricaToGrupoBarricaModel(grupoBarricaRepository.findById(id));
	}

	

}
