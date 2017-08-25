package com.softdelsur.enologia.service;
import java.util.List;

import com.softdelsur.enologia.model.BosqueModel;

public interface BosqueService {

	public abstract List<BosqueModel> listAllBosque();
	public abstract BosqueModel addBoque(BosqueModel bModel);

}
