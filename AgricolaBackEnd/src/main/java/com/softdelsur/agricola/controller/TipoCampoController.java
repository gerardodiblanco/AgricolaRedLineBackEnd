package com.softdelsur.agricola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.agricola.model.TipoCampoModel;

import com.softdelsur.agricola.service.TipoCampoService;

@RestController
@RequestMapping("/tipoCampo")
public class TipoCampoController {

	@Autowired
	@Qualifier("tipoCampoServiceImpl")
	TipoCampoService tipoCampoService;

	@CrossOrigin
	@GetMapping("/all")
	public List<TipoCampoModel> getTiposCampo() {

		return tipoCampoService.findAll();

	}

}
