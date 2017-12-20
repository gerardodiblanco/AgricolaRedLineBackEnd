package com.softdelsur.agricola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softdelsur.agricola.entity.UnidadTrabajo;
import com.softdelsur.agricola.entity.UnidadTrabajoDeposito;
import com.softdelsur.agricola.repository.UnidadTrabajoDepositoRepository;
import com.softdelsur.agricola.service.UnidadTrabajoDepositoService;

@Service("unidadTrabajoDepositoServiceImpl")
public class UnidadTrabajoDepositoServiceImpl implements UnidadTrabajoDepositoService {

	@Autowired
	@Qualifier("unidadTrabajoDepositoRepository")
	UnidadTrabajoDepositoRepository unidadTrabajoDepositoRepository;

	@Override
	public List<UnidadTrabajoDeposito> findVigenteByUnidadTrabajo(UnidadTrabajo unidadTrabajo) {
		// TODO Auto-generated method stub
		return unidadTrabajoDepositoRepository.findUTDByUnidadTrabajoAndFechaBaja(unidadTrabajo, null);
	}

	@Override
	public UnidadTrabajoDeposito findById(String id) {
		// TODO Auto-generated method stub
		return unidadTrabajoDepositoRepository.findById(id);
	}

	@Override
	public UnidadTrabajoDeposito addUnidadTrabajoDeposito(UnidadTrabajoDeposito unidadTrabajoDeposito) {
		// TODO Auto-generated method stub
		return unidadTrabajoDepositoRepository.save(unidadTrabajoDeposito);
	}

}
