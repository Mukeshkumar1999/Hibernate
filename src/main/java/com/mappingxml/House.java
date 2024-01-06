package com.mappingxml;

public class House {
	private int hid;
	private String hName;
	private String ownerName;
	public House() {
		super();
		// TODO Auto-generated constructor stub
	}
	public House(int hid, String hName, String ownerName) {
		super();
		this.hid = hid;
		this.hName = hName;
		this.ownerName = ownerName;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	

}
