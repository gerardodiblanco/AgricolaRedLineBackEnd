package com.softdelsur.agricola.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.Tarea;
import com.softdelsur.agricola.repository.TareaRepository;
import com.softdelsur.agricola.service.TareaService;

@Service("tareaServiceImpl")
public class TareaServiceImpl implements TareaService{
	
	@Autowired
	@Qualifier("tareaRepository")
	TareaRepository tareaRespository;

	@Override
	public Tarea removeTarea(String id) {
		Tarea tarea = null;
		tarea = tareaRespository.findTareaById(id);
		if(tarea != null) {
			tarea.setFechaBaja(Date.valueOf(LocalDate.now()));
			tarea = tareaRespository.save(tarea);
		}
	
		return tarea;
	}

	@Override
	public Tarea addTarea(Tarea tarea) {
		
		return tareaRespository.save(tarea);
	}

	@Override
	public List<Tarea> findTareasActivas() {
		
		return tareaRespository.findTareasByFechaBaja(null);
	}

}
