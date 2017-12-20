package com.softdelsur.agricola.controller;

import java.util.ArrayList;
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

import com.softdelsur.agricola.converter.SubCuartelConverter;
import com.softdelsur.agricola.converter.UnidadTrabajoConverter;
import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.entity.UnidadTrabajoSubCuartel;
import com.softdelsur.agricola.model.UnidadTrabajoModel;
import com.softdelsur.agricola.model.UnidadTrabajoSubCuartelModel;
import com.softdelsur.agricola.service.SubCuartelService;
import com.softdelsur.agricola.service.UnidadTrabajoService;
import com.softdelsur.agricola.service.UnidadTrabajoSubCuartelService;

@RestController
@RequestMapping("/unidadTrabajo")
public class UnidadTrabajoController {

	@Autowired
	@Qualifier("subCuartelServiceImpl")
	SubCuartelService subCuartelService;

	@Autowired
	@Qualifier("unidadTrabajoSubCuartelServiceImpl")
	UnidadTrabajoSubCuartelService unidadTrabajoSubCuartelService;

	@Autowired
	@Qualifier("subCuartelConverter")
	SubCuartelConverter subCuartelConverter;

	@Autowired
	@Qualifier("unidadTrabajoConverter")
	UnidadTrabajoConverter unidadTrabajoConverter;

	@Autowired
	@Qualifier("unidadTrabajoServiceImpl")
	UnidadTrabajoService unidadTrabajoService;

	@CrossOrigin
	@GetMapping("/allSubCuarteles")
	public List<UnidadTrabajoSubCuartelModel> buscarSubCuartelesActivosSinUnidadTrabajo() {
		List<UnidadTrabajoSubCuartelModel> unidadTrabajoSubCuartelModelList = new ArrayList<>();
		List<SubCuartel> subCuartelList = subCuartelService.buscarSubCuartelesActivos();

		for (SubCuartel subCuartel : subCuartelList) {
			UnidadTrabajoSubCuartel unidadTrabajoSubCuartel = null;
			unidadTrabajoSubCuartel = unidadTrabajoSubCuartelService
					.buscarUnidadTrabajoVigentePorSubCuartel(subCuartel);

			if (unidadTrabajoSubCuartel == null) {
				System.out.println("unidad de trabajo sub cuarte l == null ");
				unidadTrabajoSubCuartelModelList
						.add(unidadTrabajoConverter.convertSubCuartelToUnidadTrabajoSubCuartelModel(subCuartel));
			} else {
				System.out.println("distinto de null");
			}

		}

		return unidadTrabajoSubCuartelModelList;
	}

	@CrossOrigin
	@GetMapping("/all")
	public List<UnidadTrabajoModel> buscarUnidadesTrabajos() {
		return unidadTrabajoConverter
				.convertListUnidadTrabajoToListUnidadTrabajoModel(unidadTrabajoService.findUnidadTrabajoActivos());
	}

	@CrossOrigin
	@PostMapping("/save")
	public UnidadTrabajoModel guardarUnidadTrabajo(@RequestBody UnidadTrabajoModel unidadTrabajoModel) {
		return unidadTrabajoConverter.convertUnidadTrabajoToUnidadTrabajoModel(unidadTrabajoService
				.addUnidadTrabajo(unidadTrabajoConverter.convertUnidadTrabajoModelToUnidadTrabajo(unidadTrabajoModel)));
	}

	@CrossOrigin
	@GetMapping("/findUnidadTrabajo/{id}")
	public UnidadTrabajoModel buscarUnidadTrabajo(@PathVariable("id") String id) {
		return unidadTrabajoConverter
				.convertUnidadTrabajoToUnidadTrabajoModel(unidadTrabajoService.findUnidadTrabajoById(id));
	}

	@CrossOrigin
	@DeleteMapping("/remove/{id}")
	public void eliminarTarea(@PathVariable("id") String id) {
		unidadTrabajoService.remove(id);
	}

}
