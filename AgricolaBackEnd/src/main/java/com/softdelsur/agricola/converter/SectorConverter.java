package com.softdelsur.agricola.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Sector;
import com.softdelsur.agricola.model.SectorModel;

@Component("sectorConverter")
public class SectorConverter {
	
	@Autowired
	@Qualifier("sectorDetalleConverter")
	SectorDetalleConverter sectorDetalleConverter;
	
	public Sector convertModelToEntity(SectorModel sectorModel){
		Sector sector = new Sector();
		sector.setId(sectorModel.getId());
		sector.setCodigo(sectorModel.getCodigo());
		sector.setDescripcion(sectorModel.getDescripcion());
		sector.setDetalleList(sectorDetalleConverter.convertListModelToListEntity(sectorModel.getDetalleList()));
		
		return sector;
	}
	
	public SectorModel convertEntityToModel(Sector sector){
		SectorModel sectorModel = new SectorModel();
		sectorModel.setId(sector.getId());
		sectorModel.setCodigo(sector.getCodigo());
		sectorModel.setDescripcion(sector.getDescripcion());
		sectorModel.setDetalleList(sectorDetalleConverter.convertListEntityToListModel(sector.getDetalleList()));
		
		return sectorModel;
	}

}
