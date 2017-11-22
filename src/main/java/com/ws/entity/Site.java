package com.ws.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Site")
@Entity
@Table(name="SITE")
public class Site implements GenericEntity {
	@Id
	@Column(name="SITE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SITE_SEQ")
	@SequenceGenerator(name = "SITE_SEQ", sequenceName = "SITE_SEQ",allocationSize = 1)  
	private int id;
	@Column(name="NAME")
	private String name;
	
	public Site() {
		
	}
	
	public Site(int id, String name) {
		this();
		this.id = id;
		this.name = name;
	}
	
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
