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

import com.mysql.fabric.xmlrpc.base.Array;


@Entity
@Table(name = "tareas")
public class Tarea {

	   private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name= "id", unique = true, nullable = false)
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @GeneratedValue(generator = "uuid")
	    private String id;
		private int codigo;
		private String descripcion;
		@JoinColumn(name = "id_tarea")
		@OneToMany
		private List<TareaInsumo> insumosTarea = new ArrayList<TareaInsumo>();
		@JoinColumn(name = "id_tarea")
		@OneToMany
		private List<TareaMaquina> maquinasTarea =  new ArrayList<TareaMaquina>();
		
		public Tarea() {
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

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public List<TareaInsumo> getInsumosTarea() {
			return insumosTarea;
		}

		public void setInsumosTarea(List<TareaInsumo> insumosTarea) {
			this.insumosTarea = insumosTarea;
		}

		public List<TareaMaquina> getMaquinasTarea() {
			return maquinasTarea;
		}

		public void setMaquinasTarea(List<TareaMaquina> maquinasTarea) {
			this.maquinasTarea = maquinasTarea;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + codigo;
			result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
			result = prime * result + ((insumosTarea == null) ? 0 : insumosTarea.hashCode());
			result = prime * result + ((maquinasTarea == null) ? 0 : maquinasTarea.hashCode());
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
			Tarea other = (Tarea) obj;
			if (codigo != other.codigo)
				return false;
			if (descripcion == null) {
				if (other.descripcion != null)
					return false;
			} else if (!descripcion.equals(other.descripcion))
				return false;
			if (insumosTarea == null) {
				if (other.insumosTarea != null)
					return false;
			} else if (!insumosTarea.equals(other.insumosTarea))
				return false;
			if (maquinasTarea == null) {
				if (other.maquinasTarea != null)
					return false;
			} else if (!maquinasTarea.equals(other.maquinasTarea))
				return false;
			return true;
		}
		
		
}
