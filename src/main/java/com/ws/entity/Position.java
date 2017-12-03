package com.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Position")
@Entity
@Table(name="POSITION")
public class Position implements GenericEntity {
	
	@Id
	@Column(name="POSITION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSITION_SEQ")
	@SequenceGenerator(name = "POSITION_SEQ", sequenceName = "POSITION_SEQ",allocationSize = 1)
	private int id;
	
	@Column(name="NAME")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
