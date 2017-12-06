package com.softdelsur.agricola.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softdelsur.agricola.entity.Deposito;

@Repository("depositoRepository")
public interface DepositoRepository extends JpaRepository<Deposito, Serializable> {
	
	Deposito findDepositoById(String id);

}
