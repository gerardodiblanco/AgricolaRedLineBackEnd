package com.softdelsur.enologia.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.enologia.entity.Barrica;
import com.softdelsur.enologia.entity.GrupoBarrica;
import com.softdelsur.enologia.model.BarricaModel;
import com.softdelsur.enologia.model.GrupoBarricaModel;

@Component("grupoBarricaConverter")
public class GrupoBarricaConverter {
	
	@Autowired
	@Qualifier("barricaConverter")
	BarricaConverter converterBarrica;
	
	@Autowired
	@Qualifier("estadoGrupoBarricaConverter")
	EstadoGrupoBarricaConverter converterEstadoGrupoBarrica;

	public GrupoBarrica convertGrupoBarricaModelToGrupoBarrica(GrupoBarricaModel grupoModel){
		GrupoBarrica grupo = new GrupoBarrica();
		grupo.setCodigoGrupo(grupoModel.getCodigoGrupo());
		grupo.setDescripcion(grupoModel.getDescripcion());
		grupo.setEstado(converterEstadoGrupoBarrica.convertEstadoGrupoBarricaModelToEstadoGrupoBarrica(grupoModel.getEstado()));
		
		List<BarricaModel> bModel = grupoModel.getBarricas();
		for(BarricaModel barricasModel:bModel ){
			grupo.getBarricas().add(converterBarrica.convertBarricaModelToBarrica(barricasModel));
		}
		
		return grupo;
	}
	
	public GrupoBarricaModel convertGrupoBarricaToGrupoBarricaModel(GrupoBarrica grupo){
		GrupoBarricaModel grupoModel = new GrupoBarricaModel();
		grupoModel.setCodigoGrupo(grupo.getCodigoGrupo());
		grupoModel.setDescripcion(grupo.getDescripcion());
		grupoModel.setEstado(converterEstadoGrupoBarrica.convertEstadoGrupoBarricaToEstadoGrupoBarricaModel(grupo.getEstado()));
		List<Barrica> barrica = grupo.getBarricas();
		for (Barrica barrica2 : barrica) {
			grupoModel.getBarricas().add(converterBarrica.convertBarricaToBarricaModel(barrica2));
		}
		
		return grupoModel;
	}
	
}
