package com.softdelsur.enologia.service;
import java.util.List;

import com.softdelsur.enologia.model.GrupoBarricaModel;

public interface GrupoBarricaService {

	
	public abstract List<GrupoBarricaModel> listAllGruposBarrica();
	public abstract GrupoBarricaModel addGrupo(GrupoBarricaModel grupoModel);
	public abstract GrupoBarricaModel addBarrica(String idGrupo, String idBarrica);
	public abstract GrupoBarricaModel findGrupoBarricaById(String id);
}
