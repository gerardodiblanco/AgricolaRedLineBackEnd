package com.softdelsur.agricola.controller;

import java.util.List;

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

import com.softdelsur.agricola.converter.TratoConverter;
import com.softdelsur.agricola.model.TratoModel;
import com.softdelsur.agricola.service.TratoService;


@RestController
@RequestMapping("/trato")
public class TratoController {

	@Autowired
	@Qualifier("tratoServiceImpl")
	TratoService tratoService;
	
	@Autowired
	@Qualifier("tratoConverter")
	TratoConverter tratoConverter;
	
	
	@CrossOrigin
	@GetMapping("/all")
	public List<TratoModel> buscarTratos(){
		return tratoConverter.convertListTratoToListTratoModel(tratoService.findTratosActivos());
		
	}
	
	@CrossOrigin
	@DeleteMapping("/remove/{idTrato}")
	public void eliminarTrato(@PathVariable("idTrato") String idTrato) {
		tratoService.removeTrato(idTrato);
	}
	
	@CrossOrigin
	@PostMapping("/save")
	public void guardarTrato(@RequestBody TratoModel tratoModel) {
		
		tratoService.addTrato(tratoConverter.convetTratoModelToTrato(tratoModel));
	}

	
}
