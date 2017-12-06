package com.softdelsur.agricola.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.converter.DomicilioConverter;
import com.softdelsur.agricola.entity.Domicilio;
import com.softdelsur.agricola.repository.DomicilioRepository;
import com.softdelsur.agricola.service.DomicilioService;

@Service("domicilioServiceImpl")
public class DomicilioServiceImpl implements DomicilioService {

	@Autowired
	@Qualifier("domicilioRepository")
	DomicilioRepository domicilioRepository;

	@Autowired
	@Qualifier("domicilioConverter")
	DomicilioConverter domicilioConverter;

	@Override
	public Domicilio addDomicilio(Domicilio domicilio) {

		return domicilioRepository.save(domicilio);
	}

}
