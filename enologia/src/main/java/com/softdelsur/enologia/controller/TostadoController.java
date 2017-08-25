package com.softdelsur.enologia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softdelsur.enologia.model.TostadoModel;
import com.softdelsur.enologia.service.impl.TostadoServiceImpl;

@RestController
@RequestMapping("/tostado")
public class TostadoController {
	
	@Autowired
	@Qualifier("tostadoServiceImpl")
	TostadoServiceImpl tostadoServiceImpl;

	@RequestMapping("/todos")
	public List<TostadoModel> getAllTostado(){
		
		return tostadoServiceImpl.listAllTostado();
	}
}
