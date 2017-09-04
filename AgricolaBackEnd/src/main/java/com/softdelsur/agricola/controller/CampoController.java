package com.softdelsur.agricola.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<CampoModel> getCampos() {

		
		return campoService.findCampos();
		
	}
	
	@PostMapping("/nuevo")
	public boolean guardarCampo(@RequestBody  CampoModel campoModel) { //falta algo en el parametro @...
		campoModel = campoService.addCampo(campoModel);
		
		return true;
	}
	
	


}

	
	