package com.softdelsur.agricola.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.softdelsur.agricola.entity.Cuartel;
import com.softdelsur.agricola.model.CuartelModel;
import com.softdelsur.agricola.service.CampoService;
import com.softdelsur.agricola.service.CuartelService;
import com.softdelsur.agricola.service.EstadoCuartelService;

@Component("cuartelConverter")
public class CuartelConverter {
	@Autowired
	@Qualifier("subCuartelConverter")
	SubCuartelConverter subCuartelConverter;

	@Autowired
	@Qualifier("coordenadaConverter")
	CoordenadaConverter coordenadaConverter;

	@Autowired
	@Qualifier("cuartelServiceImpl")
	CuartelService cuartelService;

	@Autowired
	@Qualifier("estadoCuartelServiceImpl")
	EstadoCuartelService estadoCuartelService;

	@Autowired
	@Qualifier("campoServiceImpl")
	CampoService campoService;

	public Cuartel convertCuartelModelToCuartel(CuartelModel cuartelModel) {

		Cuartel cuartel = null;
		cuartel = cuartelService.findCuartelById(cuartelModel.getIdCuartel());
		if (cuartel == null) {
			cuartel = new Cuartel();
			cuartel.setEstadoCuartel(estadoCuartelService.findEstadoCuartelByNombre("Activo"));
			cuartel.setCampo(campoService.findByIdCampo(cuartelModel.getIdCampo()));

		}

		cuartel.setCodigo(cuartelModel.getCodigo());
		cuartel.setDescripcion(cuartelModel.getDescripcion());
		cuartel.setHectarea(cuartelModel.getHectarea());
		cuartel.setCoordenadaList(coordenadaConverter.convertListModelToListEntity(cuartelModel.getCoordenadaList()));

		return cuartel;
	}

	public CuartelModel convertCuartelToCuartelModel(Cuartel cuartel) {
		CuartelModel cuartelModel = new CuartelModel();
		cuartelModel.setCodigo(cuartel.getCodigo());
		cuartelModel.setCodigoCampo(cuartel.getCampo().getCodigo());
		cuartelModel.setCuitCampo(cuartel.getCampo().getCUIT());
		cuartelModel.setDomicilioCampo(
				cuartel.getCampo().getDomicilio().getCalle() + cuartel.getCampo().getDomicilio().getNumero());
		cuartelModel.setEstadoCampo(cuartel.getCampo().getEstadoCampo().getNombre());
		cuartelModel.setHectarea(cuartel.getHectarea());
		cuartelModel.setHectareaCampo(cuartel.getCampo().getHectarea());
		cuartelModel.setIdCuartel(cuartel.getIdCuartel());
		cuartelModel.setDescripcion(cuartel.getDescripcion());
		cuartelModel.setNombreCampo(cuartel.getCampo().getNombre());
		cuartelModel.setProveedorCampo(cuartel.getCampo().getProveedor().getRazonSocial());
		cuartelModel.setTipoCampo(cuartel.getCampo().getTipo().getNombre());
		cuartelModel.setCoordenadaList(coordenadaConverter.convertListEntityToListModel(cuartel.getCoordenadaList()));

		cuartelModel.setIdCampo(cuartel.getCampo().getIdCampo());

		return cuartelModel;
	}

	public List<CuartelModel> convertListCuartelToListCuartelModel(List<Cuartel> listCuartel) {
		List<CuartelModel> cuartelModelList = new ArrayList<CuartelModel>();
		for (Cuartel cuartel : listCuartel) {
			cuartelModelList.add(convertCuartelToCuartelModel(cuartel));

		}
		return cuartelModelList;
	}

	/*
	 * public List<Cuartel> convertListCuartelModelToListCuartel(List<CuartelModel>
	 * listCuartelModel){ List<Cuartel> cuartelList = new ArrayList<Cuartel>(); for
	 * (CuartelModel cuartelModel : listCuartelModel) {
	 * cuartelList.add(convertCuartelModelToCuartel(cuartelModel));
	 * 
	 * } return cuartelList; }
	 */
}
