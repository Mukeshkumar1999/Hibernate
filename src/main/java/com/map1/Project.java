package com.map1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Project {
	@Id
	@Column(name="project_id")
	private int projectId;
	@Column(name="project_name")
	private String projectName;
	@ManyToMany(mappedBy = "project")
	private List<Emp> employe;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int projectId, String projectName, List<Emp> employe) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.employe = employe;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<Emp> getEmploye() {
		return employe;
	}
	public void setEmploye(List<Emp> employe) {
		this.employe = employe;
	}
    
}
