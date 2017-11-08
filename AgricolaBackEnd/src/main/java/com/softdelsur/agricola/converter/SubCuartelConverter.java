package com.softdelsur.agricola.converter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.AtributoSubCuartel;
import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.entity.PeriodoVariedad;
import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.entity.Variedad;
import com.softdelsur.agricola.model.AtributoSubCuartelModel;
import com.softdelsur.agricola.model.SubCuartelModel;
import com.softdelsur.agricola.service.AtributoSubCuartelService;
import com.softdelsur.agricola.service.CuartelService;
import com.softdelsur.agricola.service.EstadoSubCuartelService;
import com.softdelsur.agricola.service.PeriodoVariedadService;
import com.softdelsur.agricola.service.SubCuartelService;
import com.softdelsur.agricola.service.VariedadService;


@Component("subCuartelConverter")
public class SubCuartelConverter {
	@Autowired
	@Qualifier("caracteristicaConverter")
	CaracteristicaConverter caracteristicaConverter;
	@Autowired
	@Qualifier("estadoSubCuartelConverter")
	EstadoSubCuartelConverter estadoSubCuartelConverter;
	
	@Autowired
	@Qualifier("atributoSubCuartelConverter")
	AtributoSubCuartelConverter atributoSubCuartelConverter;
	
	@Autowired
	@Qualifier("periodoVariedadConverter")
	PeriodoVariedadConverter periodoVariedadConverter;
	
	@Autowired
	@Qualifier("coordenadaConverter")
	CoordenadaConverter coordenadaConverter;
	
	@Autowired
	@Qualifier("subCuartelServiceImpl")
	SubCuartelService subCuartelService;
	
	@Autowired
	@Qualifier("estadoSubCuartelServiceImpl")
	EstadoSubCuartelService estadoSubCuartelService;
	
	@Autowired
	@Qualifier("variedadServiceImpl")
	VariedadService variedadService;
	
	@Autowired
	@Qualifier("periodoVariedadServiceImpl")
	PeriodoVariedadService periodoVariedadService;
	
	@Autowired
	@Qualifier("atributoSubCuartelServiceImpl")
	AtributoSubCuartelService atributoSubCuartelService;
	
	@Autowired
	@Qualifier("cuartelServiceImpl")
	CuartelService cuartelService;
	
	public SubCuartel convertSubCuartelModelToSubCuartel(SubCuartelModel subCuartelModel) {
		SubCuartel subCuartel = null;
		System.out.println("converter");

		Cuartel cuartel = null;
		cuartel = cuartelService.findCuartelById(subCuartelModel.getIdCuartel());
		if (cuartel != null) {

			if (subCuartelModel.getIdSubCuartel() == null) {
				System.out.println("id es NULL -> NUEVO sub cuartel");
				subCuartel = new SubCuartel();
				subCuartel = subCuartelService.addSubCuartel(subCuartel);

			} else {
				subCuartel = subCuartelService.buscarPorId(subCuartelModel.getIdSubCuartel());
				System.out.println("id no nulo -> buscando en la base el sub cuartel");
				if (subCuartel == null) {
					System.out.println("sub cuartel no encontrado en la base");
					subCuartel = new SubCuartel();
					subCuartel = subCuartelService.addSubCuartel(subCuartel);
				}
			}

			System.out.println("seteando codigo, descripcion y hectarea");
			subCuartel.setCodigo(subCuartelModel.getCodigo());
			subCuartel.setDescripcion(subCuartelModel.getDescripcion());
			subCuartel.setHectarea(subCuartelModel.getHectarea());
			System.out.println("convert caracteristicas");
			subCuartel.setCaracteristicas(caracteristicaConverter
					.convertListCaracteristicaModelToListCaracteristica(subCuartelModel.getCaracteristicas()));
			System.out.println(" convet coordenadas");
			subCuartel.setCoordenadaList(
					coordenadaConverter.convertListModelToListEntity(subCuartelModel.getCoordenadaList()));
			System.out.println("set estado");
			subCuartel.setEstado(estadoSubCuartelService.buscarEstadoActivo());

			System.out.println("buscando variedad");
			Variedad variedad = variedadService.findVariedadByNombre(subCuartelModel.getVariedad());
			System.out.println("periodo variedad");
			
			PeriodoVariedad periodoVariedadVigente = null;
			periodoVariedadVigente = periodoVariedadService.findPeriodoBariedadVigenteBySubCuartel(subCuartel);
			
			if (periodoVariedadVigente == null) {
				System.out.println("periodo varidad vigente == null");
				PeriodoVariedad periodoVariedadNuevo = new PeriodoVariedad(subCuartel,variedad);
				periodoVariedadNuevo = periodoVariedadService.addPeriodoVariedad(periodoVariedadNuevo);
								
			} else {
System.out.println("Variedad vigente  " +periodoVariedadVigente.getVariedad().getNombre());
System.out.println("Variedad proveniente del DTO "+ variedad.getNombre());
				if (periodoVariedadVigente.getVariedad().getId().equals(variedad.getId())) {
					System.out.println("no se modifico la variedad ");
				}else {
					System.out.println("periodo variedad modificada");
					periodoVariedadVigente.setFechaFinPeriodo(Date.valueOf(LocalDate.now()));
					periodoVariedadVigente = periodoVariedadService.addPeriodoVariedad(periodoVariedadVigente);
					PeriodoVariedad periodoVariedadNuevo = new PeriodoVariedad(subCuartel,variedad);
					periodoVariedadNuevo = periodoVariedadService.addPeriodoVariedad(periodoVariedadNuevo);	
				}
			}
			
			// setear id del sub cuartel a los atributos sub cuartel 
			
			for(AtributoSubCuartelModel atributoSubCuartelModel:subCuartelModel.getAtributosSubCuartel()) {
				atributoSubCuartelModel.setIdSubCuartel(subCuartel.getIdSubCuartel());
			}
			
			System.out.println("seteando atributos");
			List<AtributoSubCuartel> atributoSubCuartelListNuevos = atributoSubCuartelConverter
					.convertListAtributoSubCuartelModelToListAtributoSubCuartel(
							subCuartelModel.getAtributosSubCuartel());
	
			// dar de baja los atributos eliminados

			List<AtributoSubCuartel> atributoSubCuartelListAll = atributoSubCuartelService
					.findAtributosSubCuartelesBySubCuartel(subCuartel);

			System.out.println("TAMAÑO NUEVOS " + atributoSubCuartelListNuevos.size());
			System.out.println("TAMAÑO viejos " + atributoSubCuartelListAll.size());

			for (AtributoSubCuartel atributoSubCuartelTodo : atributoSubCuartelListAll) {
				System.out.println(
						"atributo viejo " + atributoSubCuartelTodo.getOpcion().getAtributo().getNombreAtributo());

				boolean eliminar = true;
				for (AtributoSubCuartel atributoSubCuartelNuevo : atributoSubCuartelListNuevos) {
					System.out.println(
							"atributo nuevo " + atributoSubCuartelNuevo.getOpcion().getAtributo().getNombreAtributo());

					if (atributoSubCuartelTodo.getOpcion().getAtributo().getId()
							.equals(atributoSubCuartelNuevo.getOpcion().getAtributo().getId())) {
						eliminar = false;
						System.out.println("          eliminar FALSE");
					}
				}
				if (eliminar) {
					System.out.println(
							"ELIMINADO " + atributoSubCuartelTodo.getOpcion().getAtributo().getNombreAtributo());
					atributoSubCuartelTodo.setFechaFinVigencia(Timestamp.valueOf(LocalDateTime.now()));
					atributoSubCuartelService.addAtributoSubCuartel(atributoSubCuartelTodo);
				}
			}
			subCuartel = subCuartelService.addSubCuartel(subCuartel);
			subCuartel.setCuartel(cuartel);
		}
		return subCuartel;
	}
	
	
	
	
	public SubCuartelModel convertSubCuartelToSubCuartelModel(SubCuartel subCuartel){
		SubCuartelModel subCuartelModel = new SubCuartelModel();
		subCuartelModel.setIdSubCuartel(subCuartel.getIdSubCuartel());
		subCuartelModel.setCodigo(subCuartel.getCodigo());
		subCuartelModel.setDescripcion(subCuartel.getDescripcion());
		subCuartelModel.setHectarea(subCuartel.getHectarea());
//		subCuartelModel.setCaracteristicas(caracteristicaConverter.convertListCaracteristicaToListCaracteristicaModel(subCuartel.getCaracteristicas()));
		subCuartelModel.setEstado(subCuartel.getEstado().getDescripcion());
		System.out.println("antes de llamar al converter de atributo sub cuartel");
		subCuartelModel.setAtributosSubCuartel(atributoSubCuartelConverter.convertListAtributoSubCuartelToListAtributoSubCuartelModel(
				atributoSubCuartelService.findAtributosSubCuartelesBySubCuartel(subCuartel)
				));
	System.out.println("despues del converter de atrubuto sc");
		subCuartelModel.setIdCuartel(subCuartel.getCuartel().getIdCuartel());
		subCuartelModel.setNombreCuartel(subCuartel.getCuartel().getDescripcion());
		
		PeriodoVariedad periodoVariedad = null;
			periodoVariedad = periodoVariedadService.findPeriodoBariedadVigenteBySubCuartel(subCuartel);
			if(periodoVariedad != null) {
				subCuartelModel.setVariedad(periodoVariedad.getVariedad().getNombre());
				subCuartelModel.setColorVariedad(periodoVariedad.getVariedad().getColorVariedad());
				subCuartelModel.setIdVariedad(periodoVariedad.getVariedad().getId());
			}
			
		
		subCuartelModel.setNombreCampo(subCuartel.getCuartel().getCampo().getNombre());
		
		subCuartelModel.setCoordenadaList(coordenadaConverter.convertListEntityToListModel(subCuartel.getCoordenadaList()));
		return subCuartelModel;
	}
	
	public List<SubCuartel> convertListSubCuartelModelToListSubCuartel(List<SubCuartelModel> listSubCuartelModel){
		List<SubCuartel> subCuartelList = new ArrayList<SubCuartel>();
		for (SubCuartelModel subCuartelModel : listSubCuartelModel) {
		//	subCuartelList.add(convertSubCuartelModelToSubCuartel(subCuartelModel));
		}
		return subCuartelList;
	}
	public List<SubCuartelModel> convertListSubCuartelToListSubCuartelModel(List<SubCuartel> listSubCuartel){
		List<SubCuartelModel> subCuartelModelList = new ArrayList<SubCuartelModel>();
		for (SubCuartel subCuartel : listSubCuartel) {
			System.out.println("dentro del converterList-> sub cuartel = "+subCuartel.getDescripcion());
			subCuartelModelList.add(convertSubCuartelToSubCuartelModel(subCuartel));
		}
		return subCuartelModelList;
	}

}
