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

import com.softdelsur.agricola.converter.MaquinariaConverter;
import com.softdelsur.agricola.model.MaquinariaModel;
import com.softdelsur.agricola.service.MaquinariaService;

@RestController
@RequestMapping("/maquinaria")
public class MaquinariaController {

	@Autowired
	@Qualifier("maquinariaServiceImpl")
	MaquinariaService maquinariaService;

	@Autowired
	@Qualifier("maquinariaConverter")
	MaquinariaConverter maquinariaConverter;

	@CrossOrigin
	@GetMapping("/all")
	public List<MaquinariaModel> buscarMaquinaria() {
		return maquinariaConverter
				.convertListMaquinariaToListMaquinariaModel(maquinariaService.findMaquinariasActivas());

	}

	@CrossOrigin
	@DeleteMapping("/remove/{idMaquinaria}")
	public void eliminarMaquinaria(@PathVariable("idMaquinaria") String idMaquinaria) {
		maquinariaService.removeMaquinaria(idMaquinaria);
	}

	@CrossOrigin
	@PostMapping("/save")
	public void guardarMaquinaria(@RequestBody MaquinariaModel maquinariaModel) {

		maquinariaService.addMaquinaria(maquinariaConverter.convertMaquinaModelToMaquina(maquinariaModel));
	}

}
