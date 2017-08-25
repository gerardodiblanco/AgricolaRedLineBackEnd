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
@Table(name = "sector")
public class Sector {
	   private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name= "id", unique = true, nullable = false)
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    @GeneratedValue(generator = "uuid")
	    private String id;
	    
		private int codigo;
		private String descripcion;
		
		@JoinColumn(name = "id_sector")
		@OneToMany
		private List<SectorDetalle> detalleList  = new ArrayList<SectorDetalle>();
		
		@JoinColumn(name = "id_sector")
		@OneToMany
		private List<PersonalSector> personalSectorList = new ArrayList<PersonalSector>();
		//private Deposito m_Deposito;

		public Sector() {
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



		public List<SectorDetalle> getDetalleList() {
			return detalleList;
		}

		public void setDetalleList(List<SectorDetalle> detalleList) {
			this.detalleList = detalleList;
		}

		public List<PersonalSector> getPersonalSectorList() {
			return personalSectorList;
		}

		public void setPersonalSectorList(List<PersonalSector> personalSectorList) {
			this.personalSectorList = personalSectorList;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + codigo;
			result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
			result = prime * result + ((detalleList == null) ? 0 : detalleList.hashCode());
			result = prime * result + ((personalSectorList == null) ? 0 : personalSectorList.hashCode());
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
			Sector other = (Sector) obj;
			if (codigo != other.codigo)
				return false;
			if (descripcion == null) {
				if (other.descripcion != null)
					return false;
			} else if (!descripcion.equals(other.descripcion))
				return false;
			if (detalleList == null) {
				if (other.detalleList != null)
					return false;
			} else if (!detalleList.equals(other.detalleList))
				return false;
			if (personalSectorList == null) {
				if (other.personalSectorList != null)
					return false;
			} else if (!personalSectorList.equals(other.personalSectorList))
				return false;
			return true;
		}


		
	    
}
