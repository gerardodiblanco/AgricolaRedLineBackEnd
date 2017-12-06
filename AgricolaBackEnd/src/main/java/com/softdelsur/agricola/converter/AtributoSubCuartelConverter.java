package com.softdelsur.agricola.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Atributo;
import com.softdelsur.agricola.entity.AtributoOpcion;
import com.softdelsur.agricola.entity.AtributoSubCuartel;
import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.model.AtributoSubCuartelModel;
import com.softdelsur.agricola.service.AtributoOpcionService;
import com.softdelsur.agricola.service.AtributoService;
import com.softdelsur.agricola.service.AtributoSubCuartelService;
import com.softdelsur.agricola.service.SubCuartelService;

@Component("atributoSubCuartelConverter")
public class AtributoSubCuartelConverter {

	@Autowired
	@Qualifier("atributoOpcionServiceImpl")
	AtributoOpcionService atributoOpcionService;

	@Autowired
	@Qualifier("atributoOpcionConverter")
	AtributoOpcionConverter atributoOpcionConverter;

	@Autowired
	@Qualifier("atributoSubCuartelServiceImpl")
	AtributoSubCuartelService atributoSubCuartelService;

	@Autowired
	@Qualifier("atributoServiceImpl")
	AtributoService atributoService;

	@Autowired
	@Qualifier("subCuartelServiceImpl")
	SubCuartelService subCuartelService;

	public AtributoSubCuartelModel convertAtributoSubCuartelToAtributoSubCuartelModel(
			AtributoSubCuartel atributoSubCuartel) {
		AtributoSubCuartelModel atributoSubCuartelModel = new AtributoSubCuartelModel();
		atributoSubCuartelModel.setFechaInicioAsignacion(atributoSubCuartel.getFechaIncioVigencia());
		atributoSubCuartelModel.setIdAtributoSubCuartel(atributoSubCuartel.getId());

		atributoSubCuartelModel.setIdOpcion(atributoSubCuartel.getOpcion().getId());
		atributoSubCuartelModel.setNombreOpcion(atributoSubCuartel.getOpcion().getNombreOpcion());
		atributoSubCuartelModel.setIdSubCuartel(atributoSubCuartel.getSubCuartel().getIdSubCuartel());
		atributoSubCuartelModel.setIdAtributo(atributoSubCuartel.getOpcion().getAtributo().getId());
		atributoSubCuartelModel.setNombreAtributo(atributoSubCuartel.getOpcion().getAtributo().getNombreAtributo());
		atributoSubCuartelModel.setAtributoOpcionModelList(
				atributoOpcionConverter.convertListAtributoOpcionToListAtributoOpcionModel(atributoOpcionService
						.findAtributoOpcionActivos(atributoSubCuartel.getOpcion().getAtributo().getId())));
		return atributoSubCuartelModel;
	}

	public AtributoSubCuartel convertAtributoSubCuartelModelToAtributoSubCuartel(
			AtributoSubCuartelModel atributoSubCuartelModel) {
		AtributoSubCuartel atributoSubCuartel = null;
		SubCuartel subCuartel = null;
		subCuartel = subCuartelService.buscarPorId(atributoSubCuartelModel.getIdSubCuartel());

		if (subCuartel != null) {

			boolean esNuevo = false;
			boolean esModificado = false;

			atributoSubCuartel = atributoSubCuartelService
					.findAtributoSubCuartelById(atributoSubCuartelModel.getIdAtributoSubCuartel());
			if (atributoSubCuartel == null) {

				esNuevo = true;

			} else if (!atributoSubCuartel.getOpcion().getNombreOpcion()
					.equals(atributoSubCuartelModel.getNombreOpcion())) { // fue modificado
				atributoSubCuartel.setFechaFinVigencia(Timestamp.valueOf(LocalDateTime.now()));
				atributoSubCuartel = atributoSubCuartelService.addAtributoSubCuartel(atributoSubCuartel);
				esModificado = true;
			}

			if (esNuevo || esModificado) {

				Atributo atributo = null;
				atributo = atributoService.findAtributoById(atributoSubCuartelModel.getIdAtributo());

				if (atributo != null) {
					List<AtributoOpcion> atributoOpcionList = null;
					atributoOpcionList = atributoOpcionService.findAtributoOpcionActivos(atributo.getId());
					for (AtributoOpcion atributoOpcion : atributoOpcionList) {

						if (atributoSubCuartelModel.getNombreOpcion().equals(atributoOpcion.getNombreOpcion())) {
							if (esNuevo) {
								System.out.println("NUEVO ATRIBUTO");
								atributoSubCuartel = new AtributoSubCuartel(atributoOpcion, subCuartel);
								atributoSubCuartel = atributoSubCuartelService
										.addAtributoSubCuartel(atributoSubCuartel);
							} else if (esModificado) {
								System.out.println(
										"ATRIBUTO MODIFICADO nueva opcion = " + atributoOpcion.getNombreOpcion());
								atributoSubCuartel = new AtributoSubCuartel(atributoOpcion, subCuartel);
								atributoSubCuartel = atributoSubCuartelService
										.addAtributoSubCuartel(atributoSubCuartel);

							}

						}

					}
				}
			}
		} else {
			System.out.println("sub cuartel NULL id == NULL");
		}

		return atributoSubCuartel;

	}

	public List<AtributoSubCuartel> convertListAtributoSubCuartelModelToListAtributoSubCuartel(
			List<AtributoSubCuartelModel> atributoSubCuartelModelList) {
		List<AtributoSubCuartel> atributoSubCuartelList = new ArrayList<>();
		for (AtributoSubCuartelModel atributoSubCuartelModel : atributoSubCuartelModelList) {
			atributoSubCuartelList.add(convertAtributoSubCuartelModelToAtributoSubCuartel(atributoSubCuartelModel));
		}
		return atributoSubCuartelList;
	}

	public List<AtributoSubCuartelModel> convertListAtributoSubCuartelToListAtributoSubCuartelModel(
			List<AtributoSubCuartel> atributoSubCuartelList) {
		List<AtributoSubCuartelModel> atributoSubCuartelModelList = new ArrayList<>();

		for (AtributoSubCuartel atributoSubCuartel : atributoSubCuartelList) {
			System.out.println("convirtiendo atributoSubCuartel ATRIBUTO -> " + atributoSubCuartel.getId());
			if (atributoSubCuartel.getFechaFinVigencia() == null) {
				System.out.println("fecha fin vigencia == null");
				atributoSubCuartelModelList.add(convertAtributoSubCuartelToAtributoSubCuartelModel(atributoSubCuartel));
			} else {
				System.out.println("atributo dado de baja");
			}
		}

		return atributoSubCuartelModelList;

	}
}
