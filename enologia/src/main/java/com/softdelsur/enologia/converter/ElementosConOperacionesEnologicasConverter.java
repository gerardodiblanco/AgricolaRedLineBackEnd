package com.softdelsur.enologia.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.softdelsur.enologia.model.*;
import com.softdelsur.enologia.entity.*;

import com.softdelsur.enologia.entity.ElementosConOperacionesEnologicas;
import com.softdelsur.enologia.model.ElementosConOperacionesEnologicasModel;

@Component("elementosConOperacionesEnologicasConverter")
public class ElementosConOperacionesEnologicasConverter {
	
	@Autowired
	@Qualifier("barricaConverter")
	private BarricaConverter converterBarrica;
	
	@Autowired 
	@Qualifier("grupoBarricaConverter")
	GrupoBarricaConverter converterGrupoBarrica;
	
	public ElementosConOperacionesEnologicasModel convertElementosConOperacionesEnologicasToElementosConOperacionesEnologicasModel(ElementosConOperacionesEnologicas el){
		
		ElementosConOperacionesEnologicasModel elementoModel = null;
				
		if(Barrica.class == el.getClass()){
			elementoModel = converterBarrica.convertBarricaToBarricaModel((Barrica)el);
			elementoModel.setId(el.getId());
		}
		if(GrupoBarrica.class == el.getClass()){
			elementoModel = converterGrupoBarrica.convertGrupoBarricaToGrupoBarricaModel((GrupoBarrica)el);
			elementoModel.setId(el.getId());
		}
		
		
		
		
		
	return elementoModel;
	}

	
	
	public ElementosConOperacionesEnologicas convertElementosConOperacionesEnologicasModelToElementosConOperacionesEnologicas(ElementosConOperacionesEnologicasModel elModel){
		
		ElementosConOperacionesEnologicas elemento = null;
		
		if(BarricaModel.class == elModel.getClass()){
			elemento = converterBarrica.convertBarricaModelToBarrica((BarricaModel)elModel);
			elemento.setId(elModel.getId());
		}
		if(GrupoBarricaModel.class == elModel.getClass()){
			elemento = converterGrupoBarrica.convertGrupoBarricaModelToGrupoBarrica((GrupoBarricaModel)elModel);
			elemento.setId(elModel.getId());
		}
			
	return elemento;
	}

}
