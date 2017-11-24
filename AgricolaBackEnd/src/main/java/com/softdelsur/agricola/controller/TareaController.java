package com.softdelsur.agricola.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.agricola.converter.TareaConverter;
import com.softdelsur.agricola.model.TareaModel;
import com.softdelsur.agricola.service.TareaService;

@RestController
@RequestMapping("/tarea")
public class TareaController {
	
	@Autowired
	@Qualifier("tareaConverter")
	TareaConverter tareaConverter;
	
	@Autowired
	@Qualifier("tareaServiceImpl")
	TareaService tareaService;

	@CrossOrigin
	@GetMapping("/all")
	public List<TareaModel> buscarTareas(){
		return tareaConverter.convertListTareaToTareaListModel(tareaService.findTareasActivas());
		
	}
	
	@CrossOrigin
	@GetMapping("/findTarea/{idTarea}")
	public TareaModel buscarTarea(@PathVariable("idTarea") String idTarea){
		System.out.println("id tarea "+idTarea);
		return tareaConverter.convertTareaToTareaModel(tareaService.findTareaById(idTarea));
		
	}
	
	@CrossOrigin
	@DeleteMapping("/remove/{idTarea}")
	public void eliminarTarea(@PathVariable("idTarea") String idTarea) {
		tareaService.removeTarea(idTarea);
	}
	
	@CrossOrigin
	@PostMapping("/save")
	public void guardarTarea(@RequestBody TareaModel tareaModel) {
		
		tareaService.addTarea(tareaConverter.convertTareaModelToTarea(tareaModel));
	}



}
