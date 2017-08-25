package com.softdelsur.enologia.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.enologia.entity.Bosque;
import com.softdelsur.enologia.model.BosqueModel;

@Component("bosqueConverter")
public class BosqueConverter {

	public Bosque convertBosqueModelToBosque(BosqueModel bModel){
		Bosque bosque = new Bosque();
		
		bosque.setIdBosque(bModel.getIdBosque());
		bosque.setCodigo(bModel.getCodigo());
		bosque.setDescripcion(bModel.getDescripcion());
				
		return bosque;
	}
	
	public BosqueModel convertBosqueToBosqueModel(Bosque bosque){
		BosqueModel bModel = new BosqueModel();
		
		bModel.setIdBosque(bosque.getIdBosque());
		bModel.setCodigo(bosque.getCodigo());
		bModel.setDescripcion(bosque.getDescripcion());
		
		return bModel;
	}
}
