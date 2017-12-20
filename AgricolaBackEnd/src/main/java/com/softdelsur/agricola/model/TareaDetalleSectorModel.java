package com.softdelsur.agricola.model;

import java.util.ArrayList;
import java.util.List;

public class TareaDetalleSectorModel {

	private String id;

	private int codigo;

	private EstadoTareaDetalleSectorModel estado;

	private TareaModel tarea;

	private List<PersonalTareaModel> personalTareaList = new ArrayList<PersonalTareaModel>();

	private List<ConsumoRealInsumoModel> consumoRealInsumoList = new ArrayList<ConsumoRealInsumoModel>();

	private List<UtilizacionRealMaquinaModel> utilizacionRealMaquinaList = new ArrayList<UtilizacionRealMaquinaModel>();

	public TareaDetalleSectorModel() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public EstadoTareaDetalleSectorModel getEstado() {
		return estado;
	}

	public void setEstado(EstadoTareaDetalleSectorModel estado) {
		this.estado = estado;
	}

	public TareaModel getTarea() {
		return tarea;
	}

	public void setTarea(TareaModel tarea) {
		this.tarea = tarea;
	}

	public List<PersonalTareaModel> getPersonalTareaList() {
		return personalTareaList;
	}

	public void setPersonalTareaList(List<PersonalTareaModel> personalTareaList) {
		this.personalTareaList = personalTareaList;
	}

	public List<ConsumoRealInsumoModel> getConsumoRealInsumoList() {
		return consumoRealInsumoList;
	}

	public void setConsumoRealInsumoList(List<ConsumoRealInsumoModel> consumoRealInsumoList) {
		this.consumoRealInsumoList = consumoRealInsumoList;
	}

	public List<UtilizacionRealMaquinaModel> getUtilizacionRealMaquinaList() {
		return utilizacionRealMaquinaList;
	}

	public void setUtilizacionRealMaquinaList(List<UtilizacionRealMaquinaModel> utilizacionRealMaquinaList) {
		this.utilizacionRealMaquinaList = utilizacionRealMaquinaList;
	}

}
