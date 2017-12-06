package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.model.CampoDTO;

@Component("campoDTOConverter")
public class CampoDTOConverter {

	public CampoDTO convertCampoToCampoDTO(Campo campo) {
		CampoDTO campoDTO = new CampoDTO();
		campoDTO.setIdCampo(campo.getIdCampo());
		campoDTO.setCuit(campo.getCUIT());
		campoDTO.setHectarea(campo.getHectarea());
		campoDTO.setNombre(campo.getNombre());
		campoDTO.setTipo(campo.getTipo().getNombre());

		return campoDTO;

	}

	public List<CampoDTO> convertListCampoToListCampoDTO(List<Campo> campoList) {
		List<CampoDTO> campoDTOList = new ArrayList<CampoDTO>();

		for (Campo campo : campoList) {
			campoDTOList.add(convertCampoToCampoDTO(campo));
		}
		return campoDTOList;
	}

}
