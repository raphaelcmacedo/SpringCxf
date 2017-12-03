package com.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Employee")
@Entity
@Table(name="EMPLOYEE")
public class Employee implements GenericEntity {
	
	@Id
	@Column(name="EMPLOYEE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQ")
	@SequenceGenerator(name = "EMPLOYEE_SEQ", sequenceName = "EMPLOYEE_SEQ",allocationSize = 1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="SITE_ID")
	private Site site;
	
	@ManyToOne
	@JoinColumn(name="POSITION_ID")
	private Position position;
	
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
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	
}
