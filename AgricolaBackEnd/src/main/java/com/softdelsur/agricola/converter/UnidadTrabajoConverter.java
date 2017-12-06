package com.softdelsur.agricola.converter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.util.beans.BeanInfoHelper.ReturningBeanInfoDelegate;
import org.hibernate.loader.plan.exec.process.spi.ReturnReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.RequestToViewNameTranslator;

import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.entity.UnidadTrabajo;
import com.softdelsur.agricola.entity.UnidadTrabajoDeposito;
import com.softdelsur.agricola.entity.UnidadTrabajoPersonal;
import com.softdelsur.agricola.entity.UnidadTrabajoSubCuartel;
import com.softdelsur.agricola.model.UnidadTrabajoDepositoModel;
import com.softdelsur.agricola.model.UnidadTrabajoModel;
import com.softdelsur.agricola.model.UnidadTrabajoPersonalModel;
import com.softdelsur.agricola.model.UnidadTrabajoSubCuartelModel;
import com.softdelsur.agricola.service.DepositoService;
import com.softdelsur.agricola.service.SubCuartelService;
import com.softdelsur.agricola.service.UnidadTrabajoDepositoService;
import com.softdelsur.agricola.service.UnidadTrabajoPersonalService;
import com.softdelsur.agricola.service.UnidadTrabajoService;
import com.softdelsur.agricola.service.UnidadTrabajoSubCuartelService;

@Component("unidadTrabajoConverter")
public class UnidadTrabajoConverter {

	@Autowired
	@Qualifier("unidadTrabajoServiceImpl")
	UnidadTrabajoService unidadTrabajoService;

	@Autowired
	@Qualifier("unidadTrabajoDespositoServiceImpl")
	UnidadTrabajoDepositoService unidadTrabajoDepositoService;

	@Autowired
	@Qualifier("unidadTrabajoPersonalServiceImpl")
	UnidadTrabajoPersonalService unidadTrabajoPersonalService;

	@Autowired
	@Qualifier("unidadTrabajoSubCuartelServiceImpl")
	UnidadTrabajoSubCuartelService unidadTrabajoSubCuartelService;

	@Autowired
	@Qualifier("depositoServiceImpl")
	DepositoService depositoService;

	@Autowired
	@Qualifier("subCuartelServiceImpl")
	SubCuartelService subCuartelService;

	public UnidadTrabajoModel convertUnidadTrabajoToUnidadTrabajoModel(UnidadTrabajo unidadTrabajo) {
		UnidadTrabajoModel unidadTrabajoModel = new UnidadTrabajoModel();

		if (unidadTrabajo != null) {
			unidadTrabajoModel.setId(unidadTrabajo.getId());
			unidadTrabajoModel.setNombre(unidadTrabajo.getNombre());

			// converter unidadTrabajoDesposito a model
			UnidadTrabajoDepositoModel unidadTrabajoDepositoModel = convertUnidadTrabajoDepositoToModel(unidadTrabajo);
			if (unidadTrabajoDepositoModel != null) {
				unidadTrabajoModel.getDepositos().add(unidadTrabajoDepositoModel);
			}

			// converter unidadTrabajoPersonal a model
			UnidadTrabajoPersonalModel unidadTrabajoPersonalModel = convertUnidadTrabajoPersonalToModel(unidadTrabajo);
			if (unidadTrabajoPersonalModel != null) {
				unidadTrabajoModel.getPersonaless().add(unidadTrabajoPersonalModel);

			}

			// converter unidadTrabajoSubCuartel a model

			List<UnidadTrabajoSubCuartelModel> unidadTrabajoSubCuartelModels = convertUnidadTrabajoSubCuartelToModel(
					unidadTrabajo);

			if (unidadTrabajoSubCuartelModels != null) {
				for(UnidadTrabajoSubCuartelModel unidadTrabajoSubCuartelModel: unidadTrabajoSubCuartelModels)
				unidadTrabajoModel.getSubCuarteles().add(unidadTrabajoSubCuartelModel);
			}

		}

		return unidadTrabajoModel;
	}

	
	
	public List<UnidadTrabajoModel> convertListUnidadTrabajoToListUnidadTrabajoModel(
			List<UnidadTrabajo> unidadTrabajoList) {
		List<UnidadTrabajoModel> unidadTrabajoModelList = new ArrayList<>();

		for (UnidadTrabajo unidadTrabajo : unidadTrabajoList) {
			unidadTrabajoModelList.add(convertUnidadTrabajoToUnidadTrabajoModel(unidadTrabajo));
		}
		return unidadTrabajoModelList;
	}

	public UnidadTrabajo convertUnidadTrabajoModelToUnidadTrabajo(UnidadTrabajoModel unidadTrabajoModel) {
		UnidadTrabajo unidadTrabajo = null;
		System.out.println("Ingreso la converter");
		if (unidadTrabajoModel != null) {
			unidadTrabajo = unidadTrabajoService.findUnidadTrabajoById(unidadTrabajoModel.getId());
			System.out.println("buscar UT");
			if (unidadTrabajo == null) {
				System.out.println("unidad trabajo == NULL -> es nueva");
				unidadTrabajo = new UnidadTrabajo();
				unidadTrabajo.setEstadoActivo(true);
			}
			unidadTrabajo.setNombre(unidadTrabajoModel.getNombre());
			System.out.println("antes de guardar la unidad de trabajo");
			unidadTrabajo = unidadTrabajoService.addUnidadTrabajo(unidadTrabajo);
			System.out.println("se guardo la unidad de trabajo");
			
			
			// eliminar UnidadTrabajoDeposito , UnidadTrabajoPersonal y
			// UnidaTrabajoSubCuartel
			
			List<UnidadTrabajoSubCuartel> unidadTrabajoSubCuartelList = null;
			unidadTrabajoSubCuartelList = unidadTrabajoSubCuartelService.findVigenteByUnidadTrabajo(unidadTrabajo);
			if (unidadTrabajoSubCuartelList != null) {
				for (UnidadTrabajoSubCuartel unidadTrabajoSubCuartel : unidadTrabajoSubCuartelList) {
					unidadTrabajoSubCuartel.setFechaBaja(Date.valueOf(LocalDate.now()));
					unidadTrabajoSubCuartel = unidadTrabajoSubCuartelService.addUnidadTrabajoSubCuartel(unidadTrabajoSubCuartel);
				}
			}
			
	// crear realciones 		

			for (UnidadTrabajoDepositoModel unidadTrabajoDepositoModel : unidadTrabajoModel.getDepositos()) {
				UnidadTrabajoDeposito unidadTrabajoDeposito = null;
				unidadTrabajoDeposito = unidadTrabajoDepositoService.findById(unidadTrabajoDepositoModel.getId());
				if (unidadTrabajoDeposito == null) {
					System.out.println("unidad trabajo deposito null");
					unidadTrabajoDeposito = new UnidadTrabajoDeposito();
					unidadTrabajoDeposito.setFechaAlta(Date.valueOf(LocalDate.now()));
					unidadTrabajoDeposito.setFechaBaja(null);
					unidadTrabajoDeposito.setUnidadTrabajo(unidadTrabajo);
					unidadTrabajoDeposito
							.setDeposito(depositoService.findDepositoById(unidadTrabajoDepositoModel.getIdDeposito()));

					unidadTrabajoDeposito = unidadTrabajoDepositoService
							.addUnidadTrabajoDeposito(unidadTrabajoDeposito);
					System.out.println("se guardo la U T Deposito");
				}

			}
			for (UnidadTrabajoPersonalModel unidadTrabajoPersonalModel : unidadTrabajoModel.getPersonaless()) {
				UnidadTrabajoPersonal unidadTrabajoPersonal = null;
				unidadTrabajoPersonal = unidadTrabajoPersonalService.findById(unidadTrabajoPersonalModel.getId());
				if (unidadTrabajoPersonal == null) {
					System.out.println("unidad trabajo PERSONAL null");

					unidadTrabajoPersonal = new UnidadTrabajoPersonal();
					unidadTrabajoPersonal.setFechaAlta(Date.valueOf(LocalDate.now()));
					unidadTrabajoPersonal.setFechaBaja(null);
					unidadTrabajoPersonal.setUnidadTrabajo(unidadTrabajo);
					unidadTrabajoPersonal.setIdPersonal(unidadTrabajoPersonalModel.getIdPersonal());

					unidadTrabajoPersonal = unidadTrabajoPersonalService
							.addUnidadTrabajoPersonal(unidadTrabajoPersonal);

					System.out.println("se guardo la U T Personal");

				}

			}

			for (UnidadTrabajoSubCuartelModel unidadTrabajoSubCuartelModel : unidadTrabajoModel.getSubCuarteles()) {
				UnidadTrabajoSubCuartel unidadTrabajoSubCuartel = null;
				unidadTrabajoSubCuartel = unidadTrabajoSubCuartelService.findById(unidadTrabajoSubCuartelModel.getId());
				if (unidadTrabajoSubCuartel == null) {
					System.out.println("unidad trabajo SUB CUARTEL null");

					unidadTrabajoSubCuartel = new UnidadTrabajoSubCuartel();
					unidadTrabajoSubCuartel.setFechaAlta(Date.valueOf(LocalDate.now()));
					unidadTrabajoSubCuartel.setFechaBaja(null);
					unidadTrabajoSubCuartel.setUnidadTrabajo(unidadTrabajo);
					SubCuartel subCuartel = subCuartelService.buscarPorId(unidadTrabajoSubCuartelModel.getId());
					System.out.println("sub cuartel " + subCuartel.getDescripcion());
					unidadTrabajoSubCuartel.setSubCuartel(subCuartel);

					unidadTrabajoSubCuartel = unidadTrabajoSubCuartelService
							.addUnidadTrabajoSubCuartel(unidadTrabajoSubCuartel);

					System.out.println(" se guardo la U T SubCuertel ");

				}

			}

		}
		return unidadTrabajo;

	}

	List<UnidadTrabajoSubCuartelModel> convertUnidadTrabajoSubCuartelToModel(UnidadTrabajo unidadTrabajo) {
		List<UnidadTrabajoSubCuartel> unidadTrabajoSubCuartelList = null;
		List<UnidadTrabajoSubCuartelModel> unidadTrabajoSubCuartelModelList = new ArrayList<>();
		unidadTrabajoSubCuartelList = unidadTrabajoSubCuartelService.findVigenteByUnidadTrabajo(unidadTrabajo);
		if (unidadTrabajoSubCuartelList != null) {
			for (UnidadTrabajoSubCuartel uts : unidadTrabajoSubCuartelList) {
				UnidadTrabajoSubCuartelModel unidadTrabajoSubCuartelModel = new UnidadTrabajoSubCuartelModel();
				// GETS Y SETS
				unidadTrabajoSubCuartelModel.setId(uts.getId());
				unidadTrabajoSubCuartelModel.setId(uts.getSubCuartel().getIdSubCuartel());
				unidadTrabajoSubCuartelModel.setCodigoSubCuartel(uts.getSubCuartel().getCodigo());
				unidadTrabajoSubCuartelModel.setDescripcion(uts.getSubCuartel().getDescripcion());
				unidadTrabajoSubCuartelModel.setHectarea(uts.getSubCuartel().getHectarea());
				unidadTrabajoSubCuartelModel.setEstado(uts.getSubCuartel().getEstado().getDescripcion());
				unidadTrabajoSubCuartelModel.setIdCuartel(uts.getSubCuartel().getCuartel().getIdCuartel());
				unidadTrabajoSubCuartelModel.setNombreCampo(uts.getSubCuartel().getCuartel().getCampo().getNombre());
				unidadTrabajoSubCuartelModel.setNombreCuartel(uts.getSubCuartel().getCuartel().getDescripcion());
				
				unidadTrabajoSubCuartelModelList.add(unidadTrabajoSubCuartelModel);

			}

		}
		return unidadTrabajoSubCuartelModelList;
	}
	
	UnidadTrabajoPersonalModel convertUnidadTrabajoPersonalToModel(UnidadTrabajo unidadTrabajo) {
		List<UnidadTrabajoPersonal> unidadTrabajoPersonalList = null;
		UnidadTrabajoPersonalModel unidadTrabajoPersonalModel = null;
		unidadTrabajoPersonalList = unidadTrabajoPersonalService.findActivosByUnidadTrabajo(unidadTrabajo);
		if (unidadTrabajoPersonalList != null) {
			for (UnidadTrabajoPersonal utp : unidadTrabajoPersonalList) {
				unidadTrabajoPersonalModel = new UnidadTrabajoPersonalModel();
				// GETS Y SETS
				//
				//
			}
		}
		return unidadTrabajoPersonalModel;
	}

	UnidadTrabajoDepositoModel convertUnidadTrabajoDepositoToModel(UnidadTrabajo unidadTrabajo) {
		List<UnidadTrabajoDeposito> unidadTrabajoDepositoList = null;
		UnidadTrabajoDepositoModel unidadTrabajoDepositoModel = null;
		unidadTrabajoDepositoList = unidadTrabajoDepositoService.findVigenteByUnidadTrabajo(unidadTrabajo);
		if (unidadTrabajoDepositoList != null) {
			for (UnidadTrabajoDeposito utd : unidadTrabajoDepositoList) {
				unidadTrabajoDepositoModel = new UnidadTrabajoDepositoModel();
				// GETS Y SETS
				//
				//
			}
		}
		return unidadTrabajoDepositoModel;
	}
	
	public UnidadTrabajoSubCuartelModel convertSubCuartelToUnidadTrabajoSubCuartelModel(SubCuartel subCuartel) {
		UnidadTrabajoSubCuartelModel unidadTrabajoSubCuartelModel = new UnidadTrabajoSubCuartelModel();
		unidadTrabajoSubCuartelModel.setId(null);
		unidadTrabajoSubCuartelModel.setId(subCuartel.getIdSubCuartel());
		unidadTrabajoSubCuartelModel.setDescripcion(subCuartel.getDescripcion());
		unidadTrabajoSubCuartelModel.setCodigoSubCuartel(subCuartel.getCodigo());
		unidadTrabajoSubCuartelModel.setHectarea(subCuartel.getHectarea());
		unidadTrabajoSubCuartelModel.setIdCuartel(subCuartel.getCuartel().getIdCuartel());
		unidadTrabajoSubCuartelModel.setNombreCampo(subCuartel.getCuartel().getCampo().getNombre());
		unidadTrabajoSubCuartelModel.setNombreCuartel(subCuartel.getCuartel().getDescripcion());
		return unidadTrabajoSubCuartelModel;
	}
}