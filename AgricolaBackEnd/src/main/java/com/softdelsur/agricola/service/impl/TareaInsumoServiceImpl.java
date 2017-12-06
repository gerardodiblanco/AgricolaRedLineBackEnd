package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.Tarea;
import com.softdelsur.agricola.entity.TareaInsumo;
import com.softdelsur.agricola.repository.TareaInsumoRepository;
import com.softdelsur.agricola.service.TareaInsumoService;

@Service("tareaInsumoServiceImpl")
public class TareaInsumoServiceImpl implements TareaInsumoService {

	@Autowired
	@Qualifier("tareaInsumoRepository")
	TareaInsumoRepository tareaInsumoReposirtory;

	@Override
	public List<TareaInsumo> findTareaInsumoByTarea(Tarea tarea) {
		// TODO Auto-generated method stub
		return tareaInsumoReposirtory.findTareaInsumoActivasByTareaAndFechaBaja(tarea, null);
	}

	@Override
	public TareaInsumo addTareaInsumo(TareaInsumo tareaInsumo) {
		// TODO Auto-generated method stub
		return tareaInsumoReposirtory.save(tareaInsumo);
	}
}
