package com.map1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Emp {
	@Id
	@Column(name="employe_id")
	private int eId;
	@Column(name="employe_name")
	private String eName;
	@Column(name="employe_city")
	private String eCity;
	@ManyToMany
	@JoinTable(name="emp_learn",joinColumns = {@JoinColumn(name="e_id")},inverseJoinColumns = {@JoinColumn(name="pr_id")})
	private List<Project> project;
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Emp(int eId, String eName, String eCity, List<Project> project) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eCity = eCity;
		this.project = project;
	}



	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteCity() {
		return eCity;
	}
	public void seteCity(String eCity) {
		this.eCity = eCity;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}
	
	

}
