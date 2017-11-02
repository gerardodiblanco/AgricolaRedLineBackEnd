package com.softdelsur.agricola.converter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.PeriodoVariedad;
import com.softdelsur.agricola.entity.SubCuartel;
import com.softdelsur.agricola.entity.Variedad;
import com.softdelsur.agricola.model.SubCuartelModel;
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
	
	public SubCuartel convertSubCuartelModelToSubCuartel(SubCuartelModel subCuartelModel){
		SubCuartel subCuartel = null;
		
		if(subCuartelModel.getIdSubCuartel().equals(null)) {
			subCuartel = new SubCuartel();
			subCuartel = subCuartelService.addSubCuartel(subCuartel);
			
		}else {
		subCuartel = subCuartelService.buscarPorId(subCuartelModel.getIdSubCuartel());
		if(subCuartel == null) {
			subCuartel = new SubCuartel();
			subCuartel = subCuartelService.addSubCuartel(subCuartel);
		}
		}
		
		
		subCuartel.setCodigo(subCuartelModel.getCodigo());
		subCuartel.setDescripcion(subCuartelModel.getDescripcion());
		subCuartel.setHectarea(subCuartelModel.getHectarea());
		subCuartel.setCaracteristicas(caracteristicaConverter.convertListCaracteristicaModelToListCaracteristica(subCuartelModel.getCaracteristicas()));
		
		subCuartel.setCoordenadaList(coordenadaConverter.convertListModelToListEntity(subCuartelModel.getCoordenadaList()));
		
		subCuartel.setEstado(estadoSubCuartelService.buscarEstadoActivo());
	//	subCuartel.setAtributosSubCuartel(atributoSubCuartelConverter.convertListAtributoSubCuartelModelToListAtributoSubCuartel(subCuartelModel.getAtributosSubCuartel()));
		
		Variedad variedad = variedadService.findVariedadById(subCuartelModel.getIdVariedad());
		
		if(subCuartel.getPeriodosVariedad().isEmpty()) {
			PeriodoVariedad periodoVariedad = new PeriodoVariedad();
			periodoVariedad.setFechaInicioPeriodo(Date.valueOf(LocalDate.now()));
			periodoVariedad.setFechaFinPeriodo(null);
			periodoVariedad = periodoVariedadService.addPeriodoVariedad(periodoVariedad);
			periodoVariedad.setVariedad(variedad);
			
			subCuartel.getPeriodosVariedad().add(periodoVariedad);
			
		}else {
		
		for(PeriodoVariedad periodo: subCuartel.getPeriodosVariedad()) {
			if(periodo.getFechaFinPeriodo() == null) {
				if(periodo.getVariedad().equals(variedad)) {
					
				}else {
					periodo.setFechaFinPeriodo(Date.valueOf(LocalDate.now()));
					
					PeriodoVariedad periodoVariedad = new PeriodoVariedad();
					periodoVariedad.setFechaInicioPeriodo(Date.valueOf(LocalDate.now()));
					periodoVariedad.setFechaFinPeriodo(null);
					periodoVariedad = periodoVariedadService.addPeriodoVariedad(periodoVariedad);
					periodoVariedad.setVariedad(variedad);
				}
			  }
				
			}
			
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
		subCuartelModel.setAtributosSubCuartel(atributoSubCuartelConverter.convertListAtributoSubCuartelToListAtributoSubCuartelModel(subCuartel.getAtributoSubCuartelList()));
	System.out.println("despues del converter de atrubuto sc");
		subCuartelModel.setIdCuartel(subCuartel.getCuartel().getIdCuartel());
		subCuartelModel.setNombreCuartel(subCuartel.getCuartel().getDescripcion());
		
		for (PeriodoVariedad periodo: subCuartel.getPeriodosVariedad()) {
			
			if(periodo.getFechaFinPeriodo() == null) {
				subCuartelModel.setVariedad(periodo.getVariedad().getNombre());
				subCuartelModel.setColorVariedad(periodo.getVariedad().getColorVariedad());
				subCuartelModel.setIdVariedad(periodo.getVariedad().getId());
			}
			
		}
		subCuartelModel.setNombreCampo(subCuartel.getCuartel().getCampo().getNombre());
		
		subCuartelModel.setCoordenadaList(coordenadaConverter.convertListEntityToListModel(subCuartel.getCoordenadaList()));
		return subCuartelModel;
	}
	
	public List<SubCuartel> convertListSubCuartelModelToListSubCuartel(List<SubCuartelModel> listSubCuartelModel){
		List<SubCuartel> subCuartelList = new ArrayList<SubCuartel>();
		for (SubCuartelModel subCuartelModel : listSubCuartelModel) {
			subCuartelList.add(convertSubCuartelModelToSubCuartel(subCuartelModel));
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
