package com.softdelsur.agricola.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.agricola.entity.Campo;
import com.softdelsur.agricola.model.CampoModel;
import com.softdelsur.agricola.model.CoordenadaModel;
import com.softdelsur.agricola.service.CampoService;

@RestController
@RequestMapping("/campo")
public class CampoController {


	
	@Autowired
	@Qualifier("campoServiceImpl")
	CampoService campoService;
	
	@CrossOrigin
	@RequestMapping("/all")
	public List<CampoDTO> getCampos() {
		List<CampoDTO> campoDTOList = new ArrayList<CampoDTO>();
		
		for (CampoModel campoModel : campoService.findCampos()) {
			CampoDTO campoDTO = new CampoDTO();
			campoDTO.setCodigo(campoModel.getCodigo());
			campoDTO.setHectarea(campoModel.getHectarea());
			campoDTO.setNombre(campoModel.getNombre());
			campoDTO.setCUIT(campoModel.getCUIT());
			campoDTO.setCoordenadaModel(campoModel.getCoordenadaList());
			campoDTOList.add(campoDTO);
		}
		
		return campoDTOList;
		
	}
	
	

	
	
	  




}

	class CampoDTO{
	private String nombre;
	private int codigo;
	private float hectarea;
	private String CUIT;
	private List<CoordenadaModel> coordenadaModel;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public float getHectarea() {
		return hectarea;
	}
	public void setHectarea(float hectarea) {
		this.hectarea = hectarea;
	}
	public String getCUIT() {
		return CUIT;
	}
	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}
	public List<CoordenadaModel> getCoordenadaModel() {
		return coordenadaModel;
	}
	public void setCoordenadaModel(List<CoordenadaModel> coordenadaModel) {
		this.coordenadaModel = coordenadaModel;
	}

	
}
	