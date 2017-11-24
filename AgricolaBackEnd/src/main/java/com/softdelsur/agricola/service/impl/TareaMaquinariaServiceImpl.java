package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.Tarea;
import com.softdelsur.agricola.entity.TareaMaquinaria;
import com.softdelsur.agricola.repository.TareaMaquinariaRepository;
import com.softdelsur.agricola.repository.TareaTratoRepository;
import com.softdelsur.agricola.service.TareaMaquinariaService;

@Service("tareaMaquinariaServiceImpl")
public class TareaMaquinariaServiceImpl implements TareaMaquinariaService{

	
	@Autowired
	@Qualifier("tareaMaquinariaRepository")
	TareaMaquinariaRepository tareaMaquiariaRepository;

	@Override
	public List<TareaMaquinaria> findTareaMaquinariaByTarea(Tarea tarea) {
		// TODO Auto-generated method stub
		return tareaMaquiariaRepository.findTareaMaquinariaActicaByTareaAndFechaBaja(tarea, null);
	}

	@Override
	public TareaMaquinaria addTareaMaquinaria(TareaMaquinaria tareaMaquinaria) {
		// TODO Auto-generated method stub
		return tareaMaquiariaRepository.save(tareaMaquinaria);
	}
}
