package com.softdelsur.agricola.converter;

import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Rubro;
import com.softdelsur.agricola.model.RubroModel;

@Component("rubroConverter")
public class RubroConverter {

	public Rubro convertRubroModelToRubro(RubroModel rubroModel){
		Rubro rubro = new Rubro();
		rubro.setIdRubro(rubroModel.getIdRubro());
		rubro.setDescripcion(rubroModel.getDescripcion());
		rubro.setNombreRubro(rubroModel.getNombreRubro());
		return rubro;
	}
	public RubroModel convetRubroToRubroModel(Rubro rubro){
		RubroModel rubroModel = new RubroModel();
		rubroModel.setIdRubro(rubro.getIdRubro());
		rubroModel.setDescripcion(rubro.getDescripcion());
		rubroModel.setNombreRubro(rubro.getNombreRubro());
		
		return rubroModel;
	}
}
