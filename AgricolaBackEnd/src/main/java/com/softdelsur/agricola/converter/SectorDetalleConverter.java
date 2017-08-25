package com.softdelsur.agricola.converter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.SectorDetalle;
import com.softdelsur.agricola.model.SectorDetalleModel;

@Component("sectorDetalleConverter")
public class SectorDetalleConverter {
	@Autowired
	@Qualifier("subCuartelConverter")
	SubCuartelConverter subCuartelConverter;
	
	@Autowired
	@Qualifier("tareaDetalleSectorConverter")
	TareaDetalleSectorConverter tareaDetalleSectorConverter;

	public SectorDetalle convertModelToEntity(SectorDetalleModel sectorDetalleModel){
		SectorDetalle sectorDetalle = new SectorDetalle();
		sectorDetalle.setId(sectorDetalleModel.getId());
		sectorDetalle.setCodigo(sectorDetalleModel.getCodigo());
		sectorDetalle.setDescripcion(sectorDetalleModel.getDescripcion());
		sectorDetalle.setSubcuartel(subCuartelConverter.convertSubCuartelModelToSubCuartel(sectorDetalleModel.getSubcuartel()));
		sectorDetalle.setTareasDetalle(tareaDetalleSectorConverter.convertListModelToListEntity(sectorDetalleModel.getTareasDetalle()));
		
		return sectorDetalle;
	}
	
	public SectorDetalleModel convertEntityToModel(SectorDetalle sectorDetalle){
		SectorDetalleModel sectorDetalleModel = new SectorDetalleModel();
		sectorDetalleModel.setId(sectorDetalle.getId());
		sectorDetalleModel.setCodigo(sectorDetalle.getCodigo());
		sectorDetalleModel.setDescripcion(sectorDetalle.getDescripcion());
		sectorDetalleModel.setSubcuartel(subCuartelConverter.convertSubCuartelToSubCuartelModel(sectorDetalle.getSubcuartel()));
		sectorDetalleModel.setTareasDetalle(tareaDetalleSectorConverter.convertListEntityToListModel(sectorDetalle.getTareasDetalle()));
		
		return sectorDetalleModel;
	}

	public List<SectorDetalle> convertListModelToListEntity(List<SectorDetalleModel> sectorDetalleModelList) {
		List<SectorDetalle> sectorDetalleList = new ArrayList<SectorDetalle>();
		
		for(SectorDetalleModel sectorDetalleModel:sectorDetalleModelList){
			sectorDetalleList.add(convertModelToEntity(sectorDetalleModel));
		}
		return sectorDetalleList;
	}

	public List<SectorDetalleModel> convertListEntityToListModel(List<SectorDetalle> sectorDetalleList) {
	List<SectorDetalleModel> sectorDetalleModelList = new ArrayList<SectorDetalleModel>();
		
		for(SectorDetalle sectorDetalle:sectorDetalleList){
			sectorDetalleModelList.add(convertEntityToModel(sectorDetalle));
		}

		
		return sectorDetalleModelList;
	}
}
