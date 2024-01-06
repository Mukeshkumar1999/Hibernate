package com.map;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	@Id
	@Column(name="person_id")
	private int id;
	@Column(name="person_name")
	private String pname;
	@OneToMany(mappedBy = "person",cascade=CascadeType.ALL)
	private List<Laptop> laptop;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String pname, List<Laptop> laptop) {
		super();
		this.id = id;
		this.pname = pname;
		this.laptop = laptop;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	
	
	
	

}
