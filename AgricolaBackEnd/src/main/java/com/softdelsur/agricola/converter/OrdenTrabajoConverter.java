package com.softdelsur.agricola.converter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.configuration.EntidadesBasicas;
import com.softdelsur.agricola.entity.EstadoOrdenTrabajoTarea;
import com.softdelsur.agricola.entity.Insumo;
import com.softdelsur.agricola.entity.Maquinaria;
import com.softdelsur.agricola.entity.OrdenTrabajo;
import com.softdelsur.agricola.entity.OrdenTrabajoTarea;
import com.softdelsur.agricola.entity.OrdenTrabajoTareaInsumo;
import com.softdelsur.agricola.entity.OrdenTrabajoTareaMaquinaria;
import com.softdelsur.agricola.entity.OrdenTrabajoUnidadTrabajoDeposito;
import com.softdelsur.agricola.entity.OrdenTrabajoUnidadTrabajoPersonal;
import com.softdelsur.agricola.entity.OrdenTrabajoUnidadTrabajoSubCuartel;
import com.softdelsur.agricola.entity.Tarea;
import com.softdelsur.agricola.entity.Trato;
import com.softdelsur.agricola.entity.UnidadTrabajo;
import com.softdelsur.agricola.entity.UnidadTrabajoDeposito;
import com.softdelsur.agricola.entity.UnidadTrabajoPersonal;
import com.softdelsur.agricola.entity.UnidadTrabajoSubCuartel;
import com.softdelsur.agricola.model.InsumoModel;
import com.softdelsur.agricola.model.MaquinariaModel;
import com.softdelsur.agricola.model.OrdenTrabajoModel;
import com.softdelsur.agricola.model.TareaModel;
import com.softdelsur.agricola.model.UnidadTrabajoDepositoModel;
import com.softdelsur.agricola.model.UnidadTrabajoModel;
import com.softdelsur.agricola.model.UnidadTrabajoPersonalModel;
import com.softdelsur.agricola.model.UnidadTrabajoSubCuartelModel;
import com.softdelsur.agricola.service.EstadoOrdenTrabajoTareaService;
import com.softdelsur.agricola.service.InsumoService;
import com.softdelsur.agricola.service.MaquinariaService;
import com.softdelsur.agricola.service.OrdenTrabajoService;
import com.softdelsur.agricola.service.OrdenTrabajoTareaService;
import com.softdelsur.agricola.service.OrdenTrabajoUnidadTrabajoSubCuartelService;
import com.softdelsur.agricola.service.TareaService;
import com.softdelsur.agricola.service.TratoService;
import com.softdelsur.agricola.service.UnidadTrabajoDepositoService;
import com.softdelsur.agricola.service.UnidadTrabajoPersonalService;
import com.softdelsur.agricola.service.UnidadTrabajoService;
import com.softdelsur.agricola.service.UnidadTrabajoSubCuartelService;

@Component("ordenTrabajoConverter")
public class OrdenTrabajoConverter {

	@Autowired
	@Qualifier("ordenTrabajoServiceImpl")
	OrdenTrabajoService ordenTrabajoService;

	@Autowired
	@Qualifier("unidadTrabajoServiceImpl")
	UnidadTrabajoService unidadTrabajoService;

	@Autowired
	@Qualifier("unidadTrabajoSubCuartelServiceImpl")
	UnidadTrabajoSubCuartelService unidadTrabajoSubCuartelService;

	@Autowired
	@Qualifier("unidadTrabajoPersonalServiceImpl")
	UnidadTrabajoPersonalService unidadTrabajoPersonalService;

	@Autowired
	@Qualifier("unidadTrabajoDepositoServiceImpl")
	UnidadTrabajoDepositoService unidadTrabajoDepositoService;

	@Autowired
	@Qualifier("unidadTrabajoConverter")
	UnidadTrabajoConverter unidadTrabajoConverter;

	@Autowired
	@Qualifier("ordenTrabajoUnidadTrabajoSubCuartelServiceImpl")
	OrdenTrabajoUnidadTrabajoSubCuartelService ordenTrabajoUnidadTrabajoSubCuartelService;

	@Autowired
	@Qualifier("tareaServiceImpl")
	TareaService tareaService;

	@Autowired
	@Qualifier("estadoOrdenTrabajoTareaServiceImpl")
	EstadoOrdenTrabajoTareaService estadoOrdenTrabajoTareaService;

	@Autowired
	@Qualifier("tratoServiceImpl")
	TratoService tratoService;

	@Autowired
	@Qualifier("insumoServiceImpl")
	InsumoService insumoService;

	@Autowired
	@Qualifier("ordenTrabajoTareaServiceImpl")
	OrdenTrabajoTareaService ordenTrabajoTareaService;

	@Autowired
	@Qualifier("maquinariaServiceImpl")
	MaquinariaService maquinariaService;

	@Autowired
	@Qualifier("tareaConverter")
	TareaConverter tareaConverter;

	@Autowired
	@Qualifier("tratoConverter")
	TratoConverter tratoConverter;

	public OrdenTrabajo convertOrdenTrabajoModelToOrdenTrabajo(OrdenTrabajoModel ordenTrabajoModel) {

		OrdenTrabajo ordenTrabajo = null;
		ordenTrabajo = ordenTrabajoService.findOrdenTrabajoById(ordenTrabajoModel.getId());

		if (ordenTrabajo == null) {

			ordenTrabajo = new OrdenTrabajo();
			ordenTrabajo.setFechaAlta(Date.valueOf(LocalDate.now()));
			System.out.println("se creo una nueva orden de trabajo");
		}
		ordenTrabajo.setDescripcion(ordenTrabajoModel.getDescripcion());

		// manejo unidad de trabajo

		UnidadTrabajo unidadTrabajo = unidadTrabajoService
				.findUnidadTrabajoById(ordenTrabajoModel.getUnidadTrabajo().getId());

		if (unidadTrabajo == null) {
			System.out.println("no se encontro unidad de trabajo");
		} else {

			ordenTrabajo.setUnidadTrabajo(unidadTrabajo);
			System.out.println("unidad de trabajo seteada");

			// UnidadTrabajoSubCuartelModel
			for (UnidadTrabajoSubCuartelModel unidadTrabajoSubCuartelModel : ordenTrabajoModel.getUnidadTrabajo()
					.getSubCuarteles()) {
				System.out.println("unidad trabajo sub cuartel model ");
				System.out.println("idUTSC " + unidadTrabajoSubCuartelModel.getIdUnidadTrabajoSubCuartel());
				System.out.println("id " + unidadTrabajoSubCuartelModel.getId());
				UnidadTrabajoSubCuartel unidadTrabajoSubCuartel = unidadTrabajoSubCuartelService
						.findById(unidadTrabajoSubCuartelModel.getIdUnidadTrabajoSubCuartel());
				OrdenTrabajoUnidadTrabajoSubCuartel ordenTrabajoUnidadTrabajoSubCuartel = new OrdenTrabajoUnidadTrabajoSubCuartel(
						unidadTrabajoSubCuartelModel.isCheckbox(), unidadTrabajoSubCuartel);
				ordenTrabajoUnidadTrabajoSubCuartel.setUnidadTrabajoSubCuartel(unidadTrabajoSubCuartel);
				ordenTrabajoUnidadTrabajoSubCuartel = ordenTrabajoUnidadTrabajoSubCuartelService
						.addOrdenTrabajoUnidadTrabajoSubCuartelRepository(ordenTrabajoUnidadTrabajoSubCuartel);
				ordenTrabajo.getOrdenTrabajoUnidadTrabajoSubCuartelList().add(ordenTrabajoUnidadTrabajoSubCuartel);
			}

			// UnidadTrabajoPersonalModel
			for (UnidadTrabajoPersonalModel unidadTrabajoPersonalModel : ordenTrabajoModel.getUnidadTrabajo()
					.getPersonaless()) {
				System.out.println("unidad trabajo personal model");
				UnidadTrabajoPersonal unidadTrabajoPersonal = unidadTrabajoPersonalService
						.findById(unidadTrabajoPersonalModel.getId());
				OrdenTrabajoUnidadTrabajoPersonal ordenTrabajoUnidadTrabajoPersonal = new OrdenTrabajoUnidadTrabajoPersonal(
						unidadTrabajoPersonalModel.isCheckbox(), unidadTrabajoPersonal);
				ordenTrabajo.getOrdenTrabajoUnidadTrabajoPersonalList().add(ordenTrabajoUnidadTrabajoPersonal);
			}

			// UnidadTrabajoDepositoModel
			for (UnidadTrabajoDepositoModel unidadTrabajoDepositoModel : ordenTrabajoModel.getUnidadTrabajo()
					.getDepositos()) {
				System.out.println("unidad trabajo deposito model");
				UnidadTrabajoDeposito unidadTrabajoDeposito = unidadTrabajoDepositoService
						.findById(unidadTrabajoDepositoModel.getId());
				OrdenTrabajoUnidadTrabajoDeposito ordenTrabajoUnidadTrabajoDeposito = new OrdenTrabajoUnidadTrabajoDeposito(
						unidadTrabajoDepositoModel.isCheckbox(), unidadTrabajoDeposito);
				ordenTrabajo.getOrdenTrabajoUnidadTrabajoDepositoList().add(ordenTrabajoUnidadTrabajoDeposito);
			}

		}
		ordenTrabajo = ordenTrabajoService.addOrdenTrabajo(ordenTrabajo);

		System.out.println("TAREAS");

		// manejo Tareas

		// eliminar tareas para volverlas a crear
		EstadoOrdenTrabajoTarea estadoOrdenTrabajoTareaCreado = estadoOrdenTrabajoTareaService
				.findByNombre(EntidadesBasicas.estadoOrdenTrabajoTareaCreado);

		List<OrdenTrabajoTarea> ordenTrabajoTareaList = ordenTrabajoTareaService
				.findOrdenTrabajoTareaByOrdenTrabajoAndEstado(ordenTrabajo, estadoOrdenTrabajoTareaCreado);
		for (OrdenTrabajoTarea ordenTrabajoTarea : ordenTrabajoTareaList) {
			ordenTrabajoTareaService.delelteOrdenTrabajoTarea(ordenTrabajoTarea);
		}

		for (TareaModel tareaModel : ordenTrabajoModel.getTareaModelList()) {
			System.out.println("recorriendo la lista de tareas " + tareaModel.getDescripcion());
			OrdenTrabajoTarea ordenTrabajoTarea = new OrdenTrabajoTarea();
			Tarea tarea = tareaService.findTareaById(tareaModel.getId());
			ordenTrabajoTarea.setTarea(tarea);
			ordenTrabajoTarea.setOrdenTrabajo(ordenTrabajo);

			ordenTrabajoTarea.setEstado(estadoOrdenTrabajoTareaCreado);
			Trato trato = tratoService.findTratoById(tareaModel.getTratoModel().getId());
			ordenTrabajoTarea.setTrato(trato);

			ordenTrabajoTarea.setCantidadPersonal(tareaModel.getCantidadPersonal());

			// Insumo
			for (InsumoModel insumoModel : tareaModel.getInsumos()) {
				OrdenTrabajoTareaInsumo ordenTrabajoTareaInsumo = new OrdenTrabajoTareaInsumo();
				ordenTrabajoTareaInsumo.setCantidad(insumoModel.getCantidad());
				Insumo insumo = insumoService.findInsumoById(insumoModel.getId());
				ordenTrabajoTareaInsumo.setInsumo(insumo);
				ordenTrabajoTarea.getOrdenTrabajoTareaInsumoList().add(ordenTrabajoTareaInsumo);
			}
			ordenTrabajoTarea = ordenTrabajoTareaService.addOrdenTrabajoTarea(ordenTrabajoTarea);
			// maquinaria
			for (MaquinariaModel maquinariaModel : tareaModel.getMaquinarias()) {
				OrdenTrabajoTareaMaquinaria ordenTrabajoTareaMaquinaria = new OrdenTrabajoTareaMaquinaria();
				ordenTrabajoTareaMaquinaria.setCantidad(maquinariaModel.getCantidad());
				Maquinaria maquinaria = maquinariaService.findMaquinariaById(maquinariaModel.getId());
				ordenTrabajoTareaMaquinaria.setMaquinaria(maquinaria);
				ordenTrabajoTarea.getOrdenTrabajoTareaMaquinariaList().add(ordenTrabajoTareaMaquinaria);
			}
			ordenTrabajoTarea = ordenTrabajoTareaService.addOrdenTrabajoTarea(ordenTrabajoTarea);

		}

		System.out.println("despues de guardar todo");
		return ordenTrabajo;

	}

	public OrdenTrabajoModel convertOrdenTrabajoModelToOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		OrdenTrabajoModel ordenTrabajoModel = new OrdenTrabajoModel();
		ordenTrabajoModel.setDescripcion(ordenTrabajo.getDescripcion());
		ordenTrabajoModel.setId(ordenTrabajo.getId());
		ordenTrabajoModel.setFechaAlta(ordenTrabajo.getFechaAlta());
		UnidadTrabajoModel unidadTrabajoModel = unidadTrabajoConverter
				.convertUnidadTrabajoToUnidadTrabajoModel(ordenTrabajo.getUnidadTrabajo());

		// for por deposito personal y sub cuartel -> checkbox = true si
		// ordenTrabajoUnidadTrabajo = true

		// sub cuartel
		for (OrdenTrabajoUnidadTrabajoSubCuartel ordenTrabajoUnidadTrabajoSubCuartel : ordenTrabajo
				.getOrdenTrabajoUnidadTrabajoSubCuartelList()) {
			for (UnidadTrabajoSubCuartelModel unidadTrabajoSubCuartelModel : unidadTrabajoModel.getSubCuarteles()) {
				if (ordenTrabajoUnidadTrabajoSubCuartel.getUnidadTrabajoSubCuartel().getId()
						.equals(unidadTrabajoSubCuartelModel.getIdUnidadTrabajoSubCuartel())) {
					unidadTrabajoSubCuartelModel.setCheckbox(ordenTrabajoUnidadTrabajoSubCuartel.isSeleccion());
				}
			}
		}
		// deposito
		for (OrdenTrabajoUnidadTrabajoDeposito ordenTrabajoUnidadTrabajoDeposito : ordenTrabajo
				.getOrdenTrabajoUnidadTrabajoDepositoList()) {
			for (UnidadTrabajoDepositoModel unidadTrabajoDepositoModel : unidadTrabajoModel.getDepositos()) {
				if (ordenTrabajoUnidadTrabajoDeposito.getUnidadTrabajoDeposito().getId()
						.equals(unidadTrabajoDepositoModel.getId())) {
					unidadTrabajoDepositoModel.setCheckbox(ordenTrabajoUnidadTrabajoDeposito.isSeleccion());
				}
			}
		}

		// personal
		for (OrdenTrabajoUnidadTrabajoPersonal ordenTrabajoUnidadTrabajoPersonal : ordenTrabajo
				.getOrdenTrabajoUnidadTrabajoPersonalList()) {
			for (UnidadTrabajoPersonalModel unidadTrabajoPersonalModel : unidadTrabajoModel.getPersonaless()) {
				if (ordenTrabajoUnidadTrabajoPersonal.getUnidadTrabajoPersonal().getId()
						.equals(unidadTrabajoPersonalModel.getId())) {
					unidadTrabajoPersonalModel.setCheckbox(ordenTrabajoUnidadTrabajoPersonal.isSeleccion());
				}
			}
		}

		// tareas
		EstadoOrdenTrabajoTarea estadoOrdenTrabajoTarea = estadoOrdenTrabajoTareaService
				.findByNombre(EntidadesBasicas.estadoOrdenTrabajoTareaCreado);

		List<OrdenTrabajoTarea> ordenTrabajoTareaList = ordenTrabajoTareaService
				.findOrdenTrabajoTareaByOrdenTrabajoAndEstado(ordenTrabajo, estadoOrdenTrabajoTarea);

		for (OrdenTrabajoTarea ordenTrabajoTarea : ordenTrabajoTareaList) {
			TareaModel tareaModel = tareaConverter.convertTareaToTareaModel(ordenTrabajoTarea.getTarea());
			tareaModel.setCantidadPersonal(ordenTrabajoTarea.getCantidadPersonal());
			tareaModel.setTratoModel(tratoConverter.convertTratoToTratoModel(ordenTrabajoTarea.getTrato()));

			for (MaquinariaModel maquinariaModel : tareaModel.getMaquinarias()) {
				for (OrdenTrabajoTareaMaquinaria ordenTrabajoTareaMaquinaria : ordenTrabajoTarea
						.getOrdenTrabajoTareaMaquinariaList()) {
					if (ordenTrabajoTareaMaquinaria.getMaquinaria().getId().equals(maquinariaModel.getId())) {
						maquinariaModel.setCantidad(ordenTrabajoTareaMaquinaria.getCantidad());
					}
				}

			}
			for (InsumoModel insumoModel : tareaModel.getInsumos()) {
				for (OrdenTrabajoTareaInsumo ordenTrabajoTareaInsumo : ordenTrabajoTarea
						.getOrdenTrabajoTareaInsumoList()) {
					if (ordenTrabajoTareaInsumo.getInsumo().getIdInsumo().equals(insumoModel.getId())) {
						insumoModel.setCantidad(ordenTrabajoTareaInsumo.getCantidad());
					}
				}

			}

			ordenTrabajoModel.getTareaModelList().add(tareaModel);
		}

		ordenTrabajoModel.setUnidadTrabajo(unidadTrabajoModel);

		return ordenTrabajoModel;
	}

	public List<OrdenTrabajoModel> convertListOrdenTrabajoToListOrdenTrabajoModel(List<OrdenTrabajo> ordenTrabajoList) {
		List<OrdenTrabajoModel> ordentTrabajoModelList = new ArrayList<>();

		for (OrdenTrabajo ordenTrabajo : ordenTrabajoList) {
			ordentTrabajoModelList.add(convertOrdenTrabajoModelToOrdenTrabajo(ordenTrabajo));
		}
		return ordentTrabajoModelList;

	}

}
