package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.converter.AtributoConverter;
import com.softdelsur.agricola.entity.Atributo;
import com.softdelsur.agricola.model.AtributoConOpcionesModel;
import com.softdelsur.agricola.repository.AtributoRepository;
import com.softdelsur.agricola.service.AtributoService;

@Service("atributoServiceImpl")
public class AtributoServiceImpl implements AtributoService{
	
	@Autowired
	 @Qualifier("atributoRepository")
	 AtributoRepository atributoRepository;
	
	@Autowired
	 @Qualifier("atributoConverter")
	 AtributoConverter atributoConverter;

	@Override
	public Atributo findAtributoById(String id) {
		// TODO Auto-generated method stub
		return atributoRepository.findAtributoById(id);
	}

	@Override
	public Atributo addAtributo(Atributo atributo) {
		// TODO Auto-generated method stub
		return atributoRepository.save(atributo);
	}

	@Override
	public List<Atributo> findAtributosActivos() {
		// TODO Auto-generated method stub
		return atributoRepository.findAtributosByEstado(true);
	}

	@Override
	public Atributo eliminarAtributo(String id) {
	Atributo atributo = null;
	atributo = atributoRepository.findAtributoById(id);
	if (atributo != null) {
		atributo.setEstado(false);
		atributo = addAtributo(atributo);
	}
		return addAtributo(atributo);
	}

	@Override
	public List<AtributoConOpcionesModel> findAtributosActivosConOpciones() {
		// TODO Auto-generated method stub
		return atributoConverter.convertListAtributoToListAtributoConOpcionesModel(
				atributoRepository.findAtributosByEstado(true));
	}

}
