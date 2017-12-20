package com.softdelsur.agricola.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.Deposito;
import com.softdelsur.agricola.repository.DepositoRepository;
import com.softdelsur.agricola.service.DepositoService;

@Service("depositoServiceImpl")
public class DepositoServiceImpl implements DepositoService {

	@Autowired
	@Qualifier("depositoRepository")
	DepositoRepository depositoRepository;

	@Override
	public Deposito findDepositoById(String id) {
		// TODO Auto-generated method stub
		return depositoRepository.findDepositoById(id);
	}

}
