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

import com.softdelsur.agricola.converter.InsumoConverter;
import com.softdelsur.agricola.model.InsumoModel;
import com.softdelsur.agricola.service.InsumoService;

@RestController
@RequestMapping("/insumo")
public class InsumoController {

	@Autowired
	@Qualifier("insumoServiceImpl")
	InsumoService insumoService;

	@Autowired
	@Qualifier("insumoConverter")
	InsumoConverter insumoConverter;

	@CrossOrigin
	@GetMapping("/all")
	public List<InsumoModel> buscarInsumos() {
		return insumoConverter.convertListInsumoToListInsumoModel(insumoService.findInsumosActivos());

	}

	@CrossOrigin
	@DeleteMapping("/remove/{idInsumo}")
	public void eliminarInsumo(@PathVariable("idInsumo") String idInsomo) {
		insumoService.removeInsumo(idInsomo);
	}

	@CrossOrigin
	@PostMapping("/save")
	public void guardarInsumo(@RequestBody InsumoModel insumoModel) {

		insumoService.addInsumo(insumoConverter.convertInsumoModelToInsumo(insumoModel));
	}

}
