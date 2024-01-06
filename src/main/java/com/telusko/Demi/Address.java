package com.telusko.Demi;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="alien_address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addresId;
	@Column(length = 50, name="STREET")
	private String street;
	@Column(length = 100, name="CITY")
	private String city;
	@Column(name="is_open")
	private boolean isOpen;
	@Transient
	private double x;
	@Column(name="added_date")
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	
	
	public Address(int addresId, String street, String city, boolean isOpen, double x, Date addedDate) {
		super();
		this.addresId = addresId;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addedDate = addedDate;
	}

	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getAddresId() {
		return addresId;
	}
	public void setAddresId(int addresId) {
		this.addresId = addresId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}



	@Override
	public String toString() {
		return  this.addresId +" : " +this.city +" : " +  this.street +" : " + this.x;
	}
	
	

}
