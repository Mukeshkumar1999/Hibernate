package com.telusko.Demi;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable        // this and below notation use are only second level caching.... 
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Alien {
	@Id
	private int id;
	private String name;
	private String color;

	public Alien(int id, String name, String color) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Alien() {
		super();
		// TODO Auto-generated constructor stubs
	}

	@Override
	public String toString() {
		return this.id +":"+ this.name +":"+ this.color;
	}
	
}
