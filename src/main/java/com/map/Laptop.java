package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	@Id
	@Column(name="laptop_id")
	private int id;
	@Column(name="laptop_name")
	private String lapName;
	@ManyToOne
	private Person person;
	
	
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Laptop(int id, String lapName, Person person) {
		super();
		this.id = id;
		this.lapName = lapName;
		this.person = person;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLapName() {
		return lapName;
	}
	public void setLapName(String lapName) {
		this.lapName = lapName;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	

}
