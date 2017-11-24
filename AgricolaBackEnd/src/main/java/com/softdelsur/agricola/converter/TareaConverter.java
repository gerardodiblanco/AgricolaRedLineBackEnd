package com.softdelsur.agricola.converter;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Insumo;
import com.softdelsur.agricola.entity.Maquinaria;
import com.softdelsur.agricola.entity.Tarea;
import com.softdelsur.agricola.entity.TareaDetalleSector;
import com.softdelsur.agricola.entity.TareaInsumo;
import com.softdelsur.agricola.entity.TareaMaquinaria;
import com.softdelsur.agricola.entity.TareaTrato;
import com.softdelsur.agricola.entity.Trato;
import com.softdelsur.agricola.model.InsumoModel;
import com.softdelsur.agricola.model.MaquinariaModel;
import com.softdelsur.agricola.model.TareaDetalleSectorModel;
import com.softdelsur.agricola.model.TareaModel;
import com.softdelsur.agricola.model.TratoModel;
import com.softdelsur.agricola.service.InsumoService;
import com.softdelsur.agricola.service.MaquinariaService;
import com.softdelsur.agricola.service.TareaInsumoService;
import com.softdelsur.agricola.service.TareaMaquinariaService;
import com.softdelsur.agricola.service.TareaService;
import com.softdelsur.agricola.service.TareaTratoService;
import com.softdelsur.agricola.service.TratoService;

@Component("tareaConverter")
public class TareaConverter {
	
	@Autowired
	@Qualifier("tareaTratoServiceImpl")
	TareaTratoService tareaTratoService;
	
	@Autowired
	@Qualifier("tareaInsumoServiceImpl")
	TareaInsumoService tareaInsumoService;
	
	@Autowired
	@Qualifier("tareaMaquinariaServiceImpl")
	TareaMaquinariaService tareaMaquinariaService;
	
	@Autowired
	@Qualifier("tratoConverter")
	TratoConverter tratoConverter;
	
	@Autowired
	@Qualifier("insumoConverter")
	InsumoConverter insumoConverter;
	
	@Autowired
	@Qualifier("maquinariaConverter")
	MaquinariaConverter maquinariaConverter;
	
	@Autowired
	@Qualifier("tareaServiceImpl")
	TareaService tareaService;
	
	@Autowired
	@Qualifier("tratoServiceImpl")
	TratoService tratoService;
	
	@Autowired
	@Qualifier("maquinariaServiceImpl")
	MaquinariaService maquinariaService;
	
	@Autowired
	@Qualifier("insumoServiceImpl")
	InsumoService insumoService;

	
	public Tarea convertTareaModelToTarea(TareaModel tareaModel){
		Tarea tarea = null;
		tarea = tareaService.findTareaById(tareaModel.getId());
		if(tarea == null) {
			tarea = new Tarea();
			tarea.setFechaAlta(Date.valueOf(LocalDate.now()));
			tarea.setFechaBaja(null);
			tarea = tareaService.addTarea(tarea);
		}
		tarea.setCodigo(tareaModel.getCodigo());
		tarea.setDescripcion(tareaModel.getDescripcion());

// Tratos		
		
		List<TareaTrato> tareaTratoList = tareaTratoService.findTareaTratoByTarea(tarea);
		
	// agragar nuevos tratos	
		for(TratoModel tratoModel:tareaModel.getTratos()) { // tratos que vienen del font
			boolean esNuevo = true;
			for(TareaTrato tareaTrato:tareaTratoList) { // tratos asociados a la tarea
				if(tratoModel.getId().equals(tareaTrato.getId())) {
					esNuevo = false;
				}
			}
			
			if(esNuevo) {
				Trato trato = null;
				trato = tratoService.findTratoById(tratoModel.getId());
				if (trato != null) {
				
					TareaTrato tareaTrato = new TareaTrato(tarea,trato);
					tareaTrato = tareaTratoService.addTareaTrato(tareaTrato);
					System.out.println("NUEVO TRATO");
				}
			}
			
		}
		
// eliminar tratos
		
		for(TareaTrato tareaTrato:tareaTratoList) {
			boolean seElimino = true;
			for(TratoModel tratoModel:tareaModel.getTratos()) {
				
				if(tareaTrato.getId().equals(tratoModel.getId())) {
					seElimino = false;
				}
			}
			if(seElimino) {
				tareaTrato.setFechaBaja(Date.valueOf(LocalDate.now()));
				tareaTrato = tareaTratoService.addTareaTrato(tareaTrato);
				System.out.println("TRATO ELIMINADO");
			}
		}
		
		
// Maquinaria		
		
		
		
		List<TareaMaquinaria> tareaMaquinariaList = tareaMaquinariaService.findTareaMaquinariaByTarea(tarea);
		
	// agragar nueva Maquinaria
		for(MaquinariaModel maquinariaModel:tareaModel.getMaquinarias()) { // maquinarias que vienen del font
			boolean esNuevo = true;
			for(TareaMaquinaria tareaMaquinaria:tareaMaquinariaList) { // maquinarias asociadas a la tarea
				if(maquinariaModel.getId().equals(tareaMaquinaria.getId())) {
					esNuevo = false;
				}
			}
			
			if(esNuevo) {
				Maquinaria maquinaria = null;
				maquinaria = maquinariaService.findMaquinariaById(maquinariaModel.getId());
				if (maquinaria != null) {
				
					TareaMaquinaria tareaMaquinaria = new TareaMaquinaria(tarea,maquinaria);
					tareaMaquinaria = tareaMaquinariaService.addTareaMaquinaria(tareaMaquinaria);
					System.out.println("NUEVA MAQUINARIA");
				}
			}
			
		}
		
// eliminar maquinaria
		
		for(TareaMaquinaria tareaMaquinaria:tareaMaquinariaList) {
			boolean seElimino = true;
			for(MaquinariaModel maquinariaModel:tareaModel.getMaquinarias()) {
				
				if(tareaMaquinaria.getId().equals(maquinariaModel.getId())) {
					seElimino = false;
				}
			}
			if(seElimino) {
				tareaMaquinaria.setFechaBaja(Date.valueOf(LocalDate.now()));
				tareaMaquinaria = tareaMaquinariaService.addTareaMaquinaria(tareaMaquinaria);
				System.out.println("MAQUINARIA ELIMINADA");
			}
		}
		
	
		
		// Insumo		
				
				
				
				List<TareaInsumo> tareaInsumoList = tareaInsumoService.findTareaInsumoByTarea(tarea);
				
			// agragar nuevo insumo
				for(InsumoModel insumoModel:tareaModel.getInsumos()) { // insumo que vienen del font
					boolean esNuevo = true;
					for(TareaInsumo tareaInsumo:tareaInsumoList) { // insumos asociados a la tarea
						if(insumoModel.getId().equals(tareaInsumo.getId())) {
							esNuevo = false;
						}
					}
					
					if(esNuevo) {
						Insumo insumo = null;
						insumo = insumoService.findInsumoById(insumoModel.getId());
						if (insumo != null) {
						
							TareaInsumo tareaInsumo = new TareaInsumo(tarea,insumo);
							tareaInsumo = tareaInsumoService.addTareaInsumo(tareaInsumo);
							System.out.println("NUEVO INSUMO");
						}else {System.out.println("insumo == NULL -> no se encontro insumo con ese ID");}
					}
					
				}
				
		// eliminar insumo
				
				for(TareaInsumo tareaInsumo:tareaInsumoList) {
					boolean seElimino = true;
					for(InsumoModel insumoModel:tareaModel.getInsumos()) {
						
						if(tareaInsumo.getId().equals(insumoModel.getId())) {
							seElimino = false;
						}
					}
					if(seElimino) {
						tareaInsumo.setFechaBaja(Date.valueOf(LocalDate.now()));
						tareaInsumo = tareaInsumoService.addTareaInsumo(tareaInsumo);
						System.out.println("INSUMO ELIMINADO");
					}
				}
				

		
		
		
		return tarea;
	}
	public TareaModel convertTareaToTareaModel(Tarea tarea){
		TareaModel tareaModel = new TareaModel();
		tareaModel.setId(tarea.getId());
		tareaModel.setCodigo(tarea.getCodigo());
		tareaModel.setDescripcion(tarea.getDescripcion());
		
		List<TareaTrato> tareaTratoList = tareaTratoService.findTareaTratoByTarea(tarea);
		List<TratoModel> tratoModelList = new ArrayList<>();
		
		if(tareaTratoList.size()>0) {
			for (TareaTrato tareaTrato:tareaTratoList) {
		TratoModel tratoModel = tratoConverter.convertTratoToTratoModel(tareaTrato.getTrato());
		tratoModelList.add(tratoModel);
			}
			tareaModel.setTratos(tratoModelList);
		}
		
		
		List<TareaInsumo> tareaInsumoList = tareaInsumoService.findTareaInsumoByTarea(tarea);
		List<InsumoModel> insumoModelList = new ArrayList<>();
		
		if(tareaInsumoList.size()>0) {
			System.out.println("tarea insumo > 0");
			for (TareaInsumo tareaInsumo:tareaInsumoList) {
				System.out.println(tareaInsumo.getInsumo().getDescripcion());
		InsumoModel insumoModel = insumoConverter.convertInsumoToInsumoModel(tareaInsumo.getInsumo());
		insumoModelList.add(insumoModel);
			}
			tareaModel.setInsumos(insumoModelList);
		}
		
		List<TareaMaquinaria> tareaMaquinariaList = tareaMaquinariaService.findTareaMaquinariaByTarea(tarea);
		List<MaquinariaModel> maquinariaModelList = new ArrayList<>();
		
		if(tareaMaquinariaList.size()>0) {
			for (TareaMaquinaria tareaMaquinaria:tareaMaquinariaList) {
		MaquinariaModel maquinariModel = maquinariaConverter.convertMaquinaToMaquinaModel(tareaMaquinaria.getMaquina());
		maquinariaModelList.add(maquinariModel);
			}
			tareaModel.setMaquinarias(maquinariaModelList);
		}
		
		
		
		
		
		return tareaModel;
	}
	public List<Tarea> convertListTareaModelToListTarea(List<TareaModel> tareaModelList) {
		 List<Tarea> tareaList = new ArrayList<Tarea>();
		 
		 for(TareaModel tareaModel:tareaModelList){
			 tareaList.add(convertTareaModelToTarea(tareaModel));
		 }
		return tareaList;
	}


	public List<TareaModel> convertListTareaToTareaListModel(List<Tarea> tareaList) {
		 List<TareaModel> tareaModelList = new ArrayList<TareaModel>();
		 
		 for(Tarea tarea:tareaList){
			 tareaModelList.add(convertTareaToTareaModel(tarea));
		 }
		return tareaModelList;
	}

}
