package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Atributo;
import com.softdelsur.agricola.entity.AtributoOpcion;
import com.softdelsur.agricola.model.AtributoOpcionModel;
import com.softdelsur.agricola.service.AtributoOpcionService;
import com.softdelsur.agricola.service.AtributoService;

@Component("atributoOpcionConverter")
public class AtributoOpcionConverter {

	@Autowired
	@Qualifier("atributoOpcionServiceImpl")
	AtributoOpcionService atributoOpcionService;

	@Autowired
	@Qualifier("atributoServiceImpl")
	AtributoService atributoService;

	public AtributoOpcionModel convertAtributoOpcionToAtributoOpcionModel(AtributoOpcion atributoOpcion) {

		AtributoOpcionModel atributoOpcionModel = new AtributoOpcionModel();

		atributoOpcionModel.setId(atributoOpcion.getId());
		atributoOpcionModel.setNombreOpcion(atributoOpcion.getNombreOpcion());
		atributoOpcionModel.setIdAtributo(atributoOpcion.getAtributo().getNombreAtributo());
		atributoOpcionModel.setIdAtributo(atributoOpcion.getAtributo().getId());

		return atributoOpcionModel;
	}

	public List<AtributoOpcionModel> convertListAtributoOpcionToListAtributoOpcionModel(
			List<AtributoOpcion> atributoOpcionList) {
		List<AtributoOpcionModel> atributoOpcionModelList = new ArrayList<AtributoOpcionModel>();
		for (AtributoOpcion atributoOpcion : atributoOpcionList) {
			atributoOpcionModelList.add(convertAtributoOpcionToAtributoOpcionModel(atributoOpcion));
		}

		return atributoOpcionModelList;
	}

	public AtributoOpcion convertAtributoOpcionModelToAtributoOpcion(AtributoOpcionModel atributoOpcionModel) {
		AtributoOpcion atributoOpcion = null;
		Atributo atributo = null;

		if (atributoOpcionModel.getIdAtributo() != null) {
			atributo = atributoService.findAtributoById(atributoOpcionModel.getIdAtributo());
			if (atributo != null) {
				if (atributoOpcionModel.getId() == null) {
					atributoOpcion = new AtributoOpcion();
					atributoOpcion = atributoOpcionService.addAtributoOpcion(atributoOpcion);
				} else {
					atributoOpcion = atributoOpcionService.findAtributoOpcionById(atributoOpcionModel.getId());
				}
				if (atributoOpcion != null) {
					atributoOpcion.setNombreOpcion(atributoOpcionModel.getNombreOpcion());
					atributoOpcion.setAtributo(atributo);
					atributoOpcion.setEstado(true);
					atributoOpcion = atributoOpcionService.addAtributoOpcion(atributoOpcion);

				}

			}
		}
		return atributoOpcion;
	}
}
