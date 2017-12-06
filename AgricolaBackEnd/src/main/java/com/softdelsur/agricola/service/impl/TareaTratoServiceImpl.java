package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.Tarea;
import com.softdelsur.agricola.entity.TareaTrato;
import com.softdelsur.agricola.repository.TareaTratoRepository;
import com.softdelsur.agricola.service.TareaTratoService;

@Service("tareaTratoServiceImpl")
public class TareaTratoServiceImpl implements TareaTratoService {

	@Autowired
	@Qualifier("tareaTratoRepository")
	TareaTratoRepository tareaTratoReposirtory;

	@Override
	public List<TareaTrato> findTareaTratoByTarea(Tarea tarea) {
		// TODO Auto-generated method stub
		return tareaTratoReposirtory.findTareaTratoActivosByTareaAndFechaBaja(tarea, null);
	}

	@Override
	public TareaTrato addTareaTrato(TareaTrato tareaTrato) {
		// TODO Auto-generated method stub
		return tareaTratoReposirtory.save(tareaTrato);
	}

}
