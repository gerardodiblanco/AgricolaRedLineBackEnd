package com.softdelsur.enologia.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "elementos")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class ElementosConOperacionesEnologicas {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "id_elemento", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	
	private String id;

	public abstract void operacionEnologica();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}




	
}
