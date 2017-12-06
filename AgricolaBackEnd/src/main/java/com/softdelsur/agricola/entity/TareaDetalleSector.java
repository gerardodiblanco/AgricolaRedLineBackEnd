package com.softdelsur.agricola.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tareaDetalleSector")
public class TareaDetalleSector {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;

	private int codigo;
	@ManyToOne
	private EstadoTareaDetalleSector estado;
	@ManyToOne
	private Tarea tarea;
	@JoinColumn(name = "id_tarea_detalle_sector")
	@OneToMany
	private List<PersonalTarea> personalTareaList = new ArrayList<PersonalTarea>();
	@JoinColumn(name = "id_tarea_detalle_sector")
	@OneToMany
	private List<ConsumoRealInsumo> consumoRealInsumoList = new ArrayList<ConsumoRealInsumo>();
	@JoinColumn(name = "id_tarea_detalle_sector")
	@OneToMany
	private List<UtilizacionRealMaquina> utilizacionRealMaquinaList = new ArrayList<UtilizacionRealMaquina>();

	public TareaDetalleSector() {
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

	public EstadoTareaDetalleSector getEstado() {
		return estado;
	}

	public void setEstado(EstadoTareaDetalleSector estado) {
		this.estado = estado;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public List<PersonalTarea> getPersonalTareaList() {
		return personalTareaList;
	}

	public void setPersonalTareaList(List<PersonalTarea> personalTareaList) {
		this.personalTareaList = personalTareaList;
	}

	public List<ConsumoRealInsumo> getConsumoRealInsumoList() {
		return consumoRealInsumoList;
	}

	public void setConsumoRealInsumoList(List<ConsumoRealInsumo> consumoRealInsumoList) {
		this.consumoRealInsumoList = consumoRealInsumoList;
	}

	public List<UtilizacionRealMaquina> getUtilizacionRealMaquinaList() {
		return utilizacionRealMaquinaList;
	}

	public void setUtilizacionRealMaquinaList(List<UtilizacionRealMaquina> utilizacionRealMaquinaList) {
		this.utilizacionRealMaquinaList = utilizacionRealMaquinaList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((consumoRealInsumoList == null) ? 0 : consumoRealInsumoList.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((personalTareaList == null) ? 0 : personalTareaList.hashCode());
		result = prime * result + ((tarea == null) ? 0 : tarea.hashCode());
		result = prime * result + ((utilizacionRealMaquinaList == null) ? 0 : utilizacionRealMaquinaList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TareaDetalleSector other = (TareaDetalleSector) obj;
		if (codigo != other.codigo)
			return false;
		if (consumoRealInsumoList == null) {
			if (other.consumoRealInsumoList != null)
				return false;
		} else if (!consumoRealInsumoList.equals(other.consumoRealInsumoList))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (personalTareaList == null) {
			if (other.personalTareaList != null)
				return false;
		} else if (!personalTareaList.equals(other.personalTareaList))
			return false;
		if (tarea == null) {
			if (other.tarea != null)
				return false;
		} else if (!tarea.equals(other.tarea))
			return false;
		if (utilizacionRealMaquinaList == null) {
			if (other.utilizacionRealMaquinaList != null)
				return false;
		} else if (!utilizacionRealMaquinaList.equals(other.utilizacionRealMaquinaList))
			return false;
		return true;
	}

}
