package com.softdelsur.agricola.service;



import java.util.List;

import com.softdelsur.agricola.entity.Variedad;

public interface VariedadService {

	Variedad addVariedad(Variedad variedad);
	Variedad findVariedadById(String id);
	
	List<Variedad> findVariedades();
}
