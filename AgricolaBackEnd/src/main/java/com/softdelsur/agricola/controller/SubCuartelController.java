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

import com.softdelsur.agricola.converter.SubCuartelConverter;
import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.model.SubCuartelModel;
import com.softdelsur.agricola.service.CuartelService;
import com.softdelsur.agricola.service.SubCuartelService;

@RestController
@RequestMapping("/subCuartel")
public class SubCuartelController {

	@Autowired
	@Qualifier("subCuartelServiceImpl")
	SubCuartelService subCuartelService;

	@Autowired
	@Qualifier("subCuartelConverter")
	SubCuartelConverter subCuartelConverter;

	@Autowired
	@Qualifier("cuartelServiceImpl")
	CuartelService cuartelService;

	@CrossOrigin
	@GetMapping("/getSubCuartel/{idSubCuartel}")
	public SubCuartelModel buscarSubCuartel(@PathVariable("idSubCuartel") String idSubCuartel) {
		SubCuartel subCuartel = null;
		subCuartel = subCuartelService.buscarPorId(idSubCuartel);
		if (subCuartel == null) {
			System.out.println("subCuartel no encontrado");
		}
		return subCuartelConverter.convertSubCuartelToSubCuartelModel(subCuartel);

	}

	@CrossOrigin
	@GetMapping("/getAllByCuartel/{idCuartel}")
	public List<SubCuartelModel> buscarSubCuarteles(@PathVariable("idCuartel") String idCuartel) {
		List<SubCuartelModel> subCuartelModelList = null;

		Cuartel cuartel = null;
		cuartel = cuartelService.findCuartelById(idCuartel);
		if (cuartel != null) {
			System.out.println("cuartel encontrado");
			List<SubCuartel> subCuartelList = null;
			subCuartelList = subCuartelService.buscarSubCuartelesActivosPorCuartel(cuartel);
			if (subCuartelList != null) {
				System.out.println("sub cuartel encontrado");
				subCuartelModelList = subCuartelConverter.convertListSubCuartelToListSubCuartelModel(subCuartelList);

			}
		}
		return subCuartelModelList;
	}

	@CrossOrigin
	@PostMapping("/save")
	public void guardarSubCuartel(@RequestBody SubCuartelModel subCuartelModel) {
		System.out.println("SAVE");

		subCuartelService.addSubCuartel(subCuartelConverter.convertSubCuartelModelToSubCuartel(subCuartelModel));

	}

	@CrossOrigin
	@DeleteMapping("/remove/{idSubCuartel}")
	public boolean eliminarCuartel(@PathVariable("idSubCuartel") String idSubCuartel) {
		boolean rta = false;

		SubCuartel subCuartel = null;
		subCuartel = subCuartelService.buscarPorId(idSubCuartel);

		System.out.println("sub cuartel " + subCuartel.getDescripcion());

		if (subCuartel != null) {

			subCuartel = subCuartelService.eliminarSubCuartel(subCuartel);
			rta = true;
		}

		return rta;

	}

}
